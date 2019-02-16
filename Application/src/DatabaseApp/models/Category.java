package DatabaseApp.models;

/**
 * TODO comments
 */
public class Category {

    private int index;

    private String name;

    /**
     * Creates Category object using index and name.
     * @param index int
     * @param name String
     */
    public Category(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * Creates Category object using index and name.
     * @param index String
     * @param name String
     */
    public Category(String index, String name) {
        this.index = Integer.parseInt(index);
        this.name = name;
    }

    /**
     * Returns name which is a unique category's trait
     * @return String
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



    public int getIndex() {
        return index;
    }

    public String getIndexString() {
        return String.valueOf(this.index);
    }

    public String getName() {
        return name;
    }
}
