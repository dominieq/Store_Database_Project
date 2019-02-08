package DatabaseApp.classes;

/**
 * TODO comments
 */
public class Worker {

    private String idWorker;

    private String nameWorker;

    private String surnameWorker;

    private String addressWorker;

    private String telNumWorker;

    private String mailWorker;

    private String PESELWorker;
    private String idWarehouse;

    public String getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(String idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    /**
     * Creates Worker object. Sets idWorker, nameWorker, surnameWorker, addressWorker and PESELWorker
     * @param idWorker String
     * @param nameWorker String
     * @param surnameWorker String
     * @param addressWorker String
     * @param PESELWorker String
     */
    public Worker (String idWorker, String nameWorker, String surnameWorker,
                   String addressWorker, String PESELWorker) {
        this.idWorker = idWorker;
        this.nameWorker = nameWorker;
        this.surnameWorker = surnameWorker;
        this.addressWorker = addressWorker;
        this.PESELWorker = PESELWorker;
    }

    /**
     * Creates Worker object. Sets idWorker, nameWorker, surnameWorker, addressWorker, telNumWorker,
     * mailWorker and PESELWorker
     * @param idWorker String
     * @param nameWorker String
     * @param surnameWorker String
     * @param addressWorker String
     * @param telNumWorker String
     * @param mailWorker String
     * @param PESELWorker String
     */
    public Worker (String idWorker, String nameWorker, String surnameWorker, String addressWorker,
                   String telNumWorker, String mailWorker, String PESELWorker, String idMagazynu) {
        this.idWorker = idWorker;
        this.nameWorker = nameWorker;
        this.surnameWorker = surnameWorker;
        this.addressWorker = addressWorker;
        this.telNumWorker = telNumWorker;
        this.mailWorker = mailWorker;
        this.PESELWorker = PESELWorker;
        this.idWarehouse=idMagazynu;
    }

    /**
     * Returns PESEL which is a unique worker's trait.
     * @return String
     */
    @Override public String toString() {
        return this.PESELWorker;
    }

    /**
     * Returns worker's id
     * @return String
     */
    public String getIdWorker() {
        return idWorker;
    }

    /**
     * Sets worker's id
     * @param idWorker String
     */
    public void setIdWorker(String idWorker) {
        this.idWorker = idWorker;
    }

    /**
     * Returns worker's name
     * @return String
     */
    public String getNameWorker() {
        return nameWorker;
    }

    /**
     * Sets worker's name
     * @param nameWorker String
     */
    public void setNameWorker(String nameWorker) {
        this.nameWorker = nameWorker;
    }

    /**
     * Returns worker's surname
     * @return String
     */
    public String getSurnameWorker() {
        return surnameWorker;
    }

    /**
     * Sets worker's surname
     * @param surnameWorker String
     */
    public void setSurnameWorker(String surnameWorker) {
        this.surnameWorker = surnameWorker;
    }

    /**
     * Returns worker's address
     * @return String
     */
    public String getAddressWorker() {
        return addressWorker;
    }

    /**
     * Sets worker's address
     * @param addressWorker String
     */
    public void setAddressWorker(String addressWorker) {
        this.addressWorker = addressWorker;
    }

    /**
     * Returns worker's telephone number
     * @return String
     */
    public String getTelNumWorker() {
        return telNumWorker;
    }

    /**
     * Sets worker's telephone number
     * @param telNumWorker String
     */
    public void setTelNumWorker(String telNumWorker) {
        this.telNumWorker = telNumWorker;
    }

    /**
     * Returns worker's email address
     * @return String
     */
    public String getMailWorker() {
        return mailWorker;
    }

    /**
     * Sets worker's email address
     * @param mailWorker String
     */
    public void setMailWorker(String mailWorker) {
        this.mailWorker = mailWorker;
    }

    /**
     * Returns worker's PESEL
     * @return String
     */
    public String getPESELWorker() {
        return PESELWorker;
    }

    /**
     * Sets worker's PESEL
     * @param PESELWorker String
     */
    public void setPESELWorker(String PESELWorker) {
        this.PESELWorker = PESELWorker;
    }
}
