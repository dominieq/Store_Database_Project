package DatabaseApp.models;

/**
 * TODO comments
 */
public class Producer {

    private int index;

    private String name;

    private String address;

    private String mail;

    private String telNum;

    private String webPage;

    /**
     * Creates Producer object. Sets index and name
     * @param index  String
     * @param name String
     */
    public Producer(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * Creates Producer object using index, name, address, mail, telNum and webPage.
     * @param index int
     * @param name String
     * @param address String
     * @param mail String
     * @param telNum String
     * @param webPage String
     */
    public Producer(int index, String name, String address, String mail, String telNum, String webPage) {
        this.index = index;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.telNum = telNum;
        this.webPage = webPage;
    }

    /**
     * Creates Producer object using index, name, address, mail, telNum and webPage
     * @param index String
     * @param name String
     * @param address String
     * @param mail String
     * @param telNum String
     * @param webPage String
     */
    public Producer(String index, String name, String address, String mail, String telNum, String webPage) {
        this.index = Integer.parseInt(index);
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.telNum = telNum;
        this.webPage = webPage;
    }

    /**
     * Returns producer's name which is a unique trait.
     * @return String: name
     */
    @Override public String toString() {
        return this.name;
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

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
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

    public String getMail() {
        return mail;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getWebPage() {
        return webPage;
    }
}
