package DatabaseApp.models;

/**
 * TODO comments
 */
public class Worker {

    private int index;

    private String name;

    private String surname;

    private String address;

    private String telNum;

    private String mail;

    private String PESEL;

    private int warehouseIndex;

    /**
     * Creates Worker object using index, name, surname, address and PESEL
     * @param index String
     * @param name String
     * @param surname String
     * @param address String
     * @param PESEL String
     * @param warehouseIndex int
     */
    public Worker (int index, String name, String surname,
                   String address, String PESEL, int warehouseIndex) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telNum = "";
        this.mail = "";
        this.PESEL = PESEL;
        this.warehouseIndex = warehouseIndex;
    }

    /**
     * Creates new Worker object using index, name, surname, address, telNum, mail, PESEL and warehouseIndex.
     * Preferably used at the beginning when selecting all Workers from Database and creating new objects.
     * (index and warehouseIndex are ints)
     * @param index String
     * @param name String
     * @param surname String
     * @param address String
     * @param telNum String
     * @param mail String
     * @param PESEL String
     * @param warehouseIndex String
     */
    public Worker (int index, String name, String surname, String address,
                   String telNum, String mail, String PESEL, int warehouseIndex) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telNum = telNum;
        this.mail = mail;
        this.PESEL = PESEL;
        this.warehouseIndex = warehouseIndex;
    }

    /**
     * Creates new Worker object using index, name, surname, address, telNum, mail, PESEL and warehouseIndex.
     * Preferably used when creating new object from application (index and warehouseIndex are Strings)
     * @param index String
     * @param name String
     * @param surname String
     * @param address String
     * @param telNum String
     * @param mail String
     * @param PESEL String
     * @param warehouseIndex String
     */
    public Worker (String index, String name, String surname, String address,
                   String telNum, String mail, String PESEL, String warehouseIndex) {
        this.index = Integer.parseInt(index);
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telNum = telNum;
        this.mail = mail;
        this.PESEL = PESEL;
        this.warehouseIndex = Integer.parseInt(warehouseIndex);
    }

    /**
     * Overridden function that return Worker's PESEL.
     * @return String: Worker's PESEL
     */
    @Override public String toString() {
        return this.name + " " + this.surname + " " + this.PESEL;
    }



    public  int getIndex() {
        return this.index;
    }

    public String getIndexString() {
        return String.valueOf(index);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getMail() {
        return mail;
    }

    public String getPESEL() {
        return PESEL;
    }

    public int getWarehouseIndex() {
        return this.warehouseIndex;
    }

    public String getWarehouseIndexString() {
        return String.valueOf(warehouseIndex);
    }



    public void setIndex(int index) {
        this.index = index;
    }

    public void setIndex(String index) {
        this.index = Integer.parseInt(index);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setWarehouseIndex(int warehouseIndex) {
        this.warehouseIndex = warehouseIndex;
    }

    public void setWarehouseIndex(String warehouseIndex) {
        this.warehouseIndex = Integer.parseInt(warehouseIndex);
    }
}

