package DatabaseApp.models;

public class Merchandise {

    private int index;

    private String name;

    private float priceRetail;

    private float priceMarket;

    private Producer producer;

    private Category category;

    /**
     * Creates Merchandise object. Sets index, name,
     * producer and category
     * @param index int
     * @param name String
     * @param producer Producer
     * @param category Category
     */
    public Merchandise(int index, String name, Producer producer, Category category) {
        this.index = index;
        this.name = name;
        this.producer = producer;
        this.category = category;
    }

    /**
     * Creates Merchandise object using index, name, priceRetail, priceMarket, producer and category
     * @param index int
     * @param name String
     * @param priceRetail float
     * @param priceMarket float
     * @param producer Producer
     * @param category Category
     */
    public Merchandise(int index, String name, float priceRetail, float priceMarket,
                       Producer producer, Category category) {
        this.index = index;
        this.name = name;
        this.priceRetail = priceRetail;
        this.priceMarket = priceMarket;
        this.producer = producer;
        this.category = category;
    }

    /**
     * Creates Merchandise object using index, name, priceRetail, priceMarket, producer and category
     * @param index String
     * @param name String
     * @param priceRetail String
     * @param priceMarket String
     * @param producer Producer
     * @param category Category
     */
    public Merchandise(String index, String name, String priceRetail, String priceMarket,
                       Producer producer, Category category) {
        this.index = Integer.parseInt(index);
        this.name = name;
        this.priceRetail = Float.parseFloat(priceRetail);
        this.priceMarket = Float.parseFloat(priceMarket);
        this.producer = producer;
        this.category = category;
    }

    /**
     * Returns name which is a unique merchandise's trait.
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

    public void setPriceRetail(float priceRetail) {
        this.priceRetail = priceRetail;
    }

    public void setPriceRetail(String priceRetail) {
        this.priceRetail = Float.parseFloat(priceRetail);
    }

    public void setPriceMarket(float priceMarket) {
        this.priceMarket = priceMarket;
    }

    public void setPriceMarket(String priceMarket) {
        this.priceMarket = Float.parseFloat(priceMarket);
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public float getPriceRetail() {
        return priceRetail;
    }

    public String getPriceRetailString() {
        return String.valueOf(this.priceRetail);
    }

    public float getPriceMarket() {
        return priceMarket;
    }

    public String getPriceMarketString() {
        return String.valueOf(this.priceMarket);
    }

    public Producer getProducer() {
        return producer;
    }

    public Category getCategory() {
        return category;
    }
}
