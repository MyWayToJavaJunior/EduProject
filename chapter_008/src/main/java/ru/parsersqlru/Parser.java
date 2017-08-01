package ru.parsersqlru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nikolay on 23/07/17.
 */
public abstract class Parser {
    /**
     * Logger for parsers.
     */
    private Logger logger = LogManager.getLogger(this.getClass().getName());
    /**
     * Start parser.
     * @param s - path for parse.
     */
    public abstract void parse(String s);
    /**
     * Getter for logger.
     * @return - logger.
     */
    public Logger getLogger() {
        return logger;
    }
    /**
     * Parse date from string.
     * @param s - string for parse.
     * @return - date if contains.
     */
    public Date parseDate(String s) {

        Locale locale = new Locale("ru", "RU");
        SimpleDateFormat ft = new SimpleDateFormat("dd MMM yy, HH:mm", locale);
        Calendar parsingDate = new GregorianCalendar();

        if (s.contains("сегодня")) {
            parsingDate.setTime(new Date());
            parsingDate.set(Calendar.HOUR, 00);
            parsingDate.set(Calendar.MINUTE, 00);
            parsingDate.set(Calendar.SECOND, 00);
            return parsingDate.getTime();
        }

        if (s.contains("вчера")) {
            parsingDate.setTime(new Date());
            parsingDate.set(Calendar.DAY_OF_MONTH, parsingDate.get(Calendar.DAY_OF_MONTH) - 1);
            parsingDate.set(Calendar.HOUR, 00);
            parsingDate.set(Calendar.MINUTE, 00);
            parsingDate.set(Calendar.SECOND, 00);
            return parsingDate.getTime();
        }

        String pattern = "[0-9]+\\s.{3}\\s[0-9]+,\\s[0-9]+:[0-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        m.find();
        String result = s.substring(m.start(), m.end());

        try {
            parsingDate.setTime(ft.parse(result));
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return parsingDate.getTime();
    }
}
