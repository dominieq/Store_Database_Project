package DatabaseApp.helpers;

import DatabaseApp.exceptions.ParsingError;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParser {

    public DateParser() {

    }

    /**
     * Transforms dateString (String) to Date.sql  with format "dd/mm/yyyy"
     * @param dateString String
     * @return Date.sql: dateString transformed to Date.sql
     * @throws ParsingError when encounters ParseException
     */
    public Date transformStringToDate(String dateString) throws ParsingError {
        Date resDate;
        try {
            java.util.Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dateString);
            resDate = new Date(date.getTime());
        } catch (ParseException exception) {
            throw new ParsingError(dateString);
        }
        return resDate;
    }
}
