package DatabaseApp.classes;

/**
 * TODO comments
 */
public class Category {

    private int idCategory;

    private String nameCategory;

    /**
     * Creates Category object. Sets idCategory and nameCategory.
     * @param idCategory int
     * @param nameCategory String
     */
    public Category(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    /**
     * Returns name which is a unique category's trait
     * @return String
     */
    @Override public String toString() {
        return this.nameCategory;
    }

    /**
     * Return category's ID
     * @return String
     */
    public int getIdCategory() {
        return idCategory;
    }

    /**
     * Sets category's ID
     * @param idCategory String
     */
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    /**
     * Returns category's name
     * @return String
     */
    public String getNameCategory() {
        return nameCategory;
    }

    /**
     * Sets category's name
     * @param nameCategory String
     */
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
