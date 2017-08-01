package ru.parsersqlru;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Date;

/**
 * Created by nikolay on 22/07/17.
 */
public class AdParser extends Parser {
    /**
     * Link to ad.
     */
    private String link;
    /**
     * Date of ad creation.
     */
    private Date date;
    /**
     * Subject of ad.
     */
    private String subject;
    /**
     * Content of ad.
     */
    private String content;
    /**
     * db tool.
     */
    private WorkWithDB db;
    /**
     * Constructor.
     * @param db - db.
     */
    public AdParser(WorkWithDB db) {
        this.db = db;
    }
    /**
     * Parse ad.
     * @param link - ad link.
     */
    public void parse(String link) {
        this.link = link;
        try {
            parseContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Parse content.
     * @throws IOException - .
     */
    private void parseContent() throws IOException {
        Document doc = Jsoup.connect(link).get();
        Elements el = doc.select("table.msgTable");

        for (Element e : el) {

            if (!e.text().contains("Re:")) {
                Elements sub = e.select("td.messageHeader");
                Elements con = e.select("td.msgBody:not(td[style])");
                Elements dat = e.select("td.msgFooter");
                for (Element e1 : sub) {
                    String s = e1.text();
                    s = s.replace("[new]", "");
                    subject = s;
                }
                for (Element e2 : con) {
                    content = e2.text();
                }
                for (Element e3 : dat) {
                    date = parseDate(e3.text());
                }

                if (hasJava(subject) || hasJava(content)) {
                    db.add(link, subject, content, date.getTime());
                }
            }
        }
    }
    /**
     * Word filter.
     * @param s - text to filter.
     * @return - result.
     */
    private boolean hasJava(String s) {
        s = s.replace("java script", "").replace("javascript", "").replace("JavaScript", "").replace("Java Script", "");
        return (s.contains("java") || s.contains("Java"));
    }
}
