package ru.parsersqlru;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nikolay on 20/07/17.
 */
public class LinkParser extends Parser {
    /**
     * Srart address for parse.
     */
    private String startAddress;
    /**
     * Num of max page of ad list.
     */
    private int maxPage = 0;
    /**
     * Current page on list.
     */
    private int currentPage = 1;
    /**
     * Date of new year.
     */
    private Date newYear;
    /**
     * Flag for exit.
     */
    private boolean exit = false;
    /**
     * Queue for links of ads.
     */
    private BlockingQueue<String> queue;
    /**
     * Constructor.
     * @param lastParse - last parse date.
     * @param queue - queue.
     */
    public LinkParser(BlockingQueue<String> queue, Date lastParse) {
        this.queue = queue;

        if (lastParse != null) {
            newYear = lastParse;
        } else {
            newYear = parseDate("1 янв 2017, 00:00");
        }
    }
    /**
     * Max page searcher.
     * @throws IOException - .
     */
    private void searchMaxPage() throws IOException {
        String pattern = startAddress + "job/[0-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m;

        Document doc = Jsoup.connect(startAddress + "/job").get();
        Elements el = doc.select("a[href]");

        for (Element e : el) {
            m = p.matcher(e.attr("href"));

            if (m.matches()) {
                int tmp = Integer.parseInt(e.text());
                if (tmp > maxPage) {
                    maxPage = tmp;
                }
            }
        }
    }
    /**
     * Parse.
     * @param address - address for parse.
     */
    public void parse(String address) {
        this.startAddress = address;
        try {
            searchMaxPage();
            while (currentPage <= maxPage && !exit) {
                start(startAddress + "job/" + currentPage);
            }
        } catch (IOException e) {
            getLogger().error(e.getMessage());
        }
    }
    /**
     * Parse current page.
     * @param adr - address for parse.
     * @throws IOException - .
     */
    private void start(String adr) throws IOException {
        String pattern = startAddress + "[0-9]+/.+";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher;
        boolean br;

        Document doc = Jsoup.connect(adr).get();
        Elements el = doc.select("tr");
        for (Element e : el) {
            br = false;
            if (e.text().contains("[закрыт]")) {
                continue;
            }
            Elements link = e.select("td.postslisttopic > a[href]");
            Elements date = e.select("td.altCol[style]");

            for (Element elem : date) {
                if (br) {
                    break;
                }
                Date d = parseDate(elem.text());
                if (d == null) {
                    continue;
                }
                if (d.before(newYear)) {
                    exit = true;
                    return;
                } else {
                    for (Element ele : link) {
                        matcher = p.matcher(ele.attr("href"));
                        if (matcher.matches()) {
                            try {
                                queue.put(ele.attr("href"));
                            } catch (InterruptedException e1) {
                                getLogger().error(e1.getMessage());
                            }
                            br = true;
                            break;
                        }
                    }
                }
            }
        }
        currentPage++;
    }
}
