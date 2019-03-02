package DatabaseApp.models;

public class Recipient {

    private int index;

    private String name;

    private String surname;

    private String address;

    private String telNum;

    /**
     * Creates new Recipient object using index, name, surname, address and telephone number.
     * @param index int
     * @param name String
     * @param surname String
     * @param address String
     * @param telNum String
     */
    public Recipient(int index, String name, String surname, String address, String telNum) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telNum = telNum;
    }

    /**
     * Overridden function that return Recipient's PESEL.
     * @return String: Recipient's PESEL
     */
    @Override public String toString() {
        return this.name + " " + this.surname + " (" + this.index + ")";
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



    public int getIndex() {
        return index;
    }

    public String getIndexString() {
        return String.valueOf(this.index);
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
}
