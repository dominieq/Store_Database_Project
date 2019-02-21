package DatabaseApp.models;

public class Courier {

    private int index;

    private String telNum;

    /**
     * Creates new Courier object using index and telephone number.
     * @param index int
     * @param telNum String
     */
    public Courier(int index, String telNum) {
        this.index = index;
        this.telNum = telNum;
    }

    /**
     * Overridden function that return Courier's PESEL.
     * @return String: Courier's PESEL
     */
    @Override public String toString() {
        return this.telNum;
    }



    public void setIndex(int index) {
        this.index = index;
    }

    public void setIndex(String index) {
        this.index = Integer.parseInt(index);
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

    public String getTelNum() {
        return telNum;
    }
}
