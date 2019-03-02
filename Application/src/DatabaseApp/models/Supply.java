package DatabaseApp.models;

import DatabaseApp.exceptions.ParsingError;
import DatabaseApp.exceptions.WrongDateError;
import DatabaseApp.helpers.DateParser;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Supply {

    private int invoiceNumber;

    private Date startDate;

    private Date endDate;

    private Supplier supplier;

    /**
     * Creates new Supply object using invoiceNumber, supplier.
     * Preferably used at the beginning when selecting all Supplies from Database and creating new objects.
     * @param invoiceNumber int
     * @param supplier Supplier
     */
    public Supply(int invoiceNumber, Supplier supplier) {
        try {
            this.startDate = new DateParser().transformStringToDate("01/01/0001");
            this.endDate = new DateParser().transformStringToDate("01/01/0001");
        } catch (ParsingError parsingError) {
            System.out.println("SUPPLY EARLY STATE: Wrong date format");
        } finally {
            this.invoiceNumber = invoiceNumber;
            this.supplier = supplier;
        }
    }

    /**
     * Creates new Supply object using invoiceNumber, startDate, endDate, supplier.
     * Preferably used at the beginning when selecting all Supplies from Database and creating new objects.
     * (startDate and endDate are Date.sql).
     * @param invoiceNumber int
     * @param startDate Date.sql
     * @param endDate Date.sql
     * @param supplier Supplier
     */
    public Supply(int invoiceNumber, Date startDate, Date endDate, Supplier supplier) {
        this.invoiceNumber = invoiceNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.supplier = supplier;
    }

    /**
     * Creates new Supply object using invoiceNumber, startDate, endDate, supplier.
     * Preferably used when creating new object from application (startDate and endDate are Strings).
     * @param invoiceNumber int
     * @param startDate String
     * @param endDate String
     * @param supplier Supplier
     * @throws WrongDateError when a startDate or endDate has wrong format
     */
    public Supply(int invoiceNumber, String startDate, String endDate, Supplier supplier) throws WrongDateError {
        try {
            this.startDate = new DateParser().transformStringToDate(startDate);
            this.endDate = new DateParser().transformStringToDate(endDate);
        } catch (ParsingError parsingError) {
            throw new WrongDateError(parsingError.getWrongDate());
        } finally {
            this.invoiceNumber = invoiceNumber;
            this.supplier = supplier;
        }
    }

    /**
     * Overridden function that return Supply's index.
     * @return String: Supply's index
     */
    @Override public String toString() {
        return this.invoiceNumber + " DELIVERED BY: " + this.supplier.getName();
    }



    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setInvoicNumber(String invoiceNumber) {
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

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }



    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getInvoiceNumberString() {
        return String.valueOf(this.invoiceNumber);
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStartDateString() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getEndDateString() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.endDate);
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getSupplierString() {
        return this.supplier.toString();
    }
}
