package DatabaseApp.models;

public class Merchandise {

    private int idMerchandise;

    private String nameMerchandise;

    private float priceRetailMerchandise;

    private float priceMarketMerchandise;

    private Producer producerMerchandise;

    private Category categoryMerchandise;

    /**
     * Creates Merchandise object. Sets idMerchandise, nameMerchandise,
     * producerMerchandise and categoryMerchandise
     * @param id int
     * @param name String
     * @param producer Producer
     * @param category Category
     */
    public Merchandise(int id, String name, Producer producer, Category category) {
        this.idMerchandise = id;
        this.nameMerchandise = name;
        this.producerMerchandise = producer;
        this.categoryMerchandise = category;
    }

    /**
     * Creates Merchandise object. Sets idMerchandise, nameMerchandise, priceRetailMerchandise,
     * priceMarketMerchandise, producerMerchandise and categoryMerchandise
     * @param id int
     * @param name String
     * @param priceRetail float
     * @param priceProducer float
     * @param producer Producer
     * @param category Category
     */
    public Merchandise(int id, String name, float priceRetail, float priceProducer,
                       Producer producer, Category category) {
        this.idMerchandise = id;
        this.nameMerchandise = name;
        this.priceRetailMerchandise = priceRetail;
        this.priceMarketMerchandise = priceProducer;
        this.producerMerchandise = producer;
        this.categoryMerchandise = category;
    }

    /**
     * Returns name which is a unique merchandise's trait.
     * @return String: name
     */
    @Override public String toString() {
        return this.nameMerchandise;
    }

    /**
     * Return merchandise's id
     * @return int
     */
    public int getIdMerchandise() {
        return idMerchandise;
    }

    /**
     * Sets merchandise's  id
     * @param idMerchandise int
     */
    public void setIdMerchandise(int idMerchandise) {
        this.idMerchandise = idMerchandise;
    }

    /**
     * Return merchandise's name
     * @return String
     */
    public String getNameMerchandise() {
        return nameMerchandise;
    }

    /**
     * Sets merchandise's name
     * @param nameMerchandise String
     */
    public void setNameMerchandise(String nameMerchandise) {
        this.nameMerchandise = nameMerchandise;
    }

    /**
     * Return merchandise's retail price
     * @return float
     */
    public float getPriceRetailMerchandise() {
        return priceRetailMerchandise;
    }

    /**
     * Sets merchandise's retail price
     * @param priceRetailMerchandise float
     */
    public void setPriceRetailMerchandise(float priceRetailMerchandise) {
        this.priceRetailMerchandise = priceRetailMerchandise;
    }

    /**
     * Return merchandise's market price
     * @return float
     */
    public float getPriceMarketMerchandise() {
        return priceMarketMerchandise;
    }

    /**
     * Sets merchandise's market price
     * @param priceMarketMerchandise float
     */
    public void setPriceMarketMerchandise(float priceMarketMerchandise) {
        this.priceMarketMerchandise = priceMarketMerchandise;
    }

    /**
     * Return merchandise's producer
     * @return Producer
     */
    public Producer getProducerMerchandise() {
        return producerMerchandise;
    }

    /**
     * Sets merchandise's producer
     * @param producerMerchandise Producer
     */
    public void setProducerMerchandise(Producer producerMerchandise) {
        this.producerMerchandise = producerMerchandise;
    }

    /**
     * Return merchandise's category
     * @return Category
     */
    public Category getCategoryMerchandise() {
        return categoryMerchandise;
    }

    /**
     * Sets merchandise's category
     * @param categoryMerchandise Category
     */
    public void setCategoryMerchandise(Category categoryMerchandise) {
        this.categoryMerchandise = categoryMerchandise;
    }
}
