package DatabaseApp.models;

public class Supplier {

    private int index;

    private String name;

    private String address;

    private String telNum;

    private String mail;

    /**
     * Creates new Supplier object using index, name, address and telephone number.
     * @param index int
     * @param name String
     * @param address String
     * @param telNum String
     */
    public Supplier(int index, String name, String address, String telNum) {
        this.index = index;
        this.name = name;
        this.address = address;
        this.telNum = telNum;
    }

    /**
     * Creates new Supplier object using index, name, address, telephone number and email address.
     * @param index int
     * @param name String
     * @param address String
     * @param telNum String
     * @param mail String
     */
    public Supplier(int index, String name, String address, String telNum, String mail) {
        this.index = index;
        this.name = name;
        this.address = address;
        this.telNum = telNum;
        this.mail = mail;
    }

    /**
     * Overridden function that return Supplier's index.
     * @return String: Supplier's index
     */
    @Override public String toString() {
        return String.valueOf(this.index);
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    public int getIndex() {
        return index;
    }

    public String getIndexString() {
        return String.valueOf(this.index);
    }

    public String getName() {
        return name;
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
}
