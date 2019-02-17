package DatabaseApp.viewExtended;

import DatabaseApp.models.Category;
import DatabaseApp.models.Merchandise;
import DatabaseApp.models.Producer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EditMerchandiseLayoutController extends EditController {

    @FXML private TextField indexField;

    @FXML private TextField nameField;

    @FXML private TextField priceRetail;

    @FXML private TextField priceMarket;

    @FXML private ChoiceBox<Producer> producerChoiceBox;

    @FXML private ChoiceBox<Category> categoryChoiceBox;

    private Merchandise merchandise;

    @Override String fillContent(String content) {

        if(indexField.getText() == null || indexField.getText().length() == 0) {
            content += "No valid merchandise index\n";
        }

        if(nameField.getText() == null || nameField.getText().length() == 0) {
            content += "No valid merchandise name\n";
        }

        try {
            Float.parseFloat(priceRetail.getText());
        } catch (NumberFormatException exception) {
            content += "No valid retail price (must be rational number)\n";
        }

        try {
            Float.parseFloat(priceMarket.getText());
        }catch (NumberFormatException exception) {
            content += "No valid market price (must be rational number)\n";
        }

        if(producerChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No valid producer\n";
        }

        if(categoryChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No valid category\n";
        }
        return content;

    }
    @Override void fillEditObject() {

        this.merchandise.setIndex(indexField.getText());
        this.merchandise.setName(nameField.getText());
        this.merchandise.setPriceRetail(this.priceRetail.getText());
        this.merchandise.setPriceMarket(this.priceMarket.getText());
        this.merchandise.setProducer(this.producerChoiceBox.getValue());
        this.merchandise.setCategory(this.categoryChoiceBox.getValue());

    }

    public void setMerchandise(Merchandise merchandise, ObservableList<Producer> producers,
                            ObservableList<Category> categories) {

        this.merchandise = merchandise;

        this.indexField.setText(merchandise.getIndexString());
        this.nameField.setText(merchandise.getName());
        this.priceRetail.setText(merchandise.getPriceRetailString());
        this.priceMarket.setText(merchandise.getPriceMarketString());
        this.producerChoiceBox.setItems(producers);
        this.categoryChoiceBox.setItems(categories);

        this.producerChoiceBox.getSelectionModel().select(merchandise.getProducer());
        this.categoryChoiceBox.getSelectionModel().select(merchandise.getCategory());

    }
}
