package DatabaseApp.classes;

/**
 * TODO comments
 */
public class Producer {

    private int idProducer;

    private String nameProducer;

    private String addressProducer;

    private String mailProducer;

    private String telNumProducer;

    private String webPageProducer;

    /**
     * Creates Producer object. Sets idProducer and nameProducer
     * @param idProducer  String
     * @param nameProducer String
     */
    public Producer(int idProducer, String nameProducer) {
        this.idProducer = idProducer;
        this.nameProducer = nameProducer;
    }

    /**
     * Creates Producer object. Sets idProducer, nameProducer, addressProducer,
     * mailProducer, telNumProducer and webPageProducer.
     * @param idProducer int
     * @param nameProducer String
     * @param addressProducer String
     * @param mailProducer String
     * @param telNumProducer String
     * @param webPageProducer String
     */
    public Producer(int idProducer, String nameProducer, String addressProducer,
                    String mailProducer, String telNumProducer, String webPageProducer) {
        this.idProducer = idProducer;
        this.nameProducer = nameProducer;
        this.addressProducer = addressProducer;
        this.mailProducer = mailProducer;
        this.telNumProducer = telNumProducer;
        this.webPageProducer = webPageProducer;
    }

    /**
     * Returns producer's name which a unique trait.
     * @return String: nameProducer
     */
    @Override public String toString() {
        return this.nameProducer;
    }

    /**
     * Returns producer's ID
     * @return int
     */
    public int getIdProducer() {
        return idProducer;
    }

    /**
     * Sets producer's ID
     * @param idProducer int
     */
    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }

    /**
     * Returns producer's name
     * @return String
     */
    public String getNameProducer() {
        return nameProducer;
    }

    /**
     * Sets producer's name
     * @param nameProducer String
     */
    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    /**
     * Returns producer's address
     * @return String
     */
    public String getAddressProducer() {
        return addressProducer;
    }

    /**
     * Sets producer's address
     * @param addressProducer String
     */
    public void setAddressProducer(String addressProducer) {
        this.addressProducer = addressProducer;
    }

    /**
     * Returns producer's email address
     * @return String
     */
    public String getMailProducer() {
        return mailProducer;
    }

    /**
     * Sets producer's email address
     * @param mailProducer String
     */
    public void setMailProducer(String mailProducer) {
        this.mailProducer = mailProducer;
    }

    /**
     * Returns producer's telephone number
     * @return String
     */
    public String getTelNumProducer() {
        return telNumProducer;
    }

    /**
     * Sets producer's telephone number
     * @param telNumProducer String
     */
    public void setTelNumProducer(String telNumProducer) {
        this.telNumProducer = telNumProducer;
    }

    /**
     * Returns producer's web page address
     * @return String
     */
    public String getWebPageProducer() {
        return webPageProducer;
    }

    /**
     * Sets producer's web page address
     * @param webPageProducer String
     */
    public void setWebPageProducer(String webPageProducer) {
        this.webPageProducer = webPageProducer;
    }
}
