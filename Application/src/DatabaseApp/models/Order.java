package DatabaseApp.models;

import DatabaseApp.exceptions.ParsingError;
import DatabaseApp.exceptions.WrongDateError;
import DatabaseApp.helpers.DateParser;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Order {

    private int invoiceNumber;

    private Date startDate;

    private Date endDate;

    private Recipient recipient;

    private Courier courier;

    /**
     * Creates new Order object using invoiceNumber, startDate, endDate, recipient and courier.
     * Preferably used at the beginning when selecting all Orders from Database and creating new objects
     * (startDate and endDate are Date.sql).
     * @param invoiceNumber int
     * @param startDate Date.sql
     * @param endDate Date.sql
     * @param recipient Recipient
     * @param courier Courier
     */
    public Order(int invoiceNumber,  Date startDate, Date endDate, Recipient recipient, Courier courier) {
        this.invoiceNumber =  invoiceNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.recipient = recipient;
        this.courier = courier;
    }

    /**
     * Creates new Order object using invoiceNumber, startDate, endDate, recipient and courier.
     * Preferably used when creating new object from application (startDate and endDate are Strings).
     * @param invoiceNumber int
     * @param startDate String
     * @param endDate String
     * @param recipient Recipient
     * @param courier Courier
     * @throws WrongDateError when a startDate or endStart has wrong format
     */
    public Order(int invoiceNumber, String startDate, String endDate,
                 Recipient recipient, Courier courier) throws WrongDateError {
        try {
            this.startDate = new DateParser().transformStringToDate(startDate);
            this.endDate = new DateParser().transformStringToDate(endDate);
        } catch (ParsingError parsingError) {
            throw new WrongDateError(parsingError.getWrongDate());
        } finally {
            this.invoiceNumber = invoiceNumber;
            this.recipient = recipient;
            this.courier = courier;
        }
    }

    /**
     * Creates new Order object using invoiceNumber, startDate, recipient and courier.
     * Preferably used when creating new object from application (startDate is String)
     * @param invoiceNumber int
     * @param startDate String
     * @param recipient Recipient
     * @param courier Courier
     * @throws WrongDateError when a startDate has wrong format
     */
    public Order(int invoiceNumber, String startDate, Recipient recipient,
                 Courier courier) throws WrongDateError {
        try{
            this.startDate = new DateParser().transformStringToDate(startDate);
        } catch (ParsingError parsingError) {
            throw new WrongDateError(parsingError.getWrongDate());
        } finally {
            this.invoiceNumber = invoiceNumber;
            this.recipient = recipient;
            this.courier = courier;
        }
    }

    /**
     * Overridden function that return Order's index.
     * @return String: Order's index
     */
    @Override public String toString() {
        return String.valueOf(this.invoiceNumber);
    }




    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = Integer.parseInt(invoiceNumber);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(String startDate) throws WrongDateError{
        try {
            this.startDate = new DateParser().transformStringToDate(startDate);
        } catch (ParsingError parsingError) {
            throw new WrongDateError(parsingError.getWrongDate());
        }
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(String endDate) throws WrongDateError{
        try {
            this.endDate = new DateParser().transformStringToDate(endDate);
        } catch (ParsingError parsingError) {
            throw new WrongDateError(parsingError.getWrongDate());
        }
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }



    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getInvoiceString() {
        return String.valueOf(this.invoiceNumber);
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStartDateString() {
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        return format.format(this.startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    private String getEndDateString() {
        DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        return format.format(this.endDate);
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Courier getCourier() {
        return courier;
    }
}
