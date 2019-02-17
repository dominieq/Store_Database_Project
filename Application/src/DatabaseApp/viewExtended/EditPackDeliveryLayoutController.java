package DatabaseApp.viewExtended;

import DatabaseApp.models.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EditPackDeliveryLayoutController extends EditController {

    @FXML private TextField amountField;

    @FXML private ChoiceBox<Stock> stockChoiceBox;

    @FXML private ChoiceBox<Supply> supplyChoiceBox;

    private PackDelivery packDelivery;

    @Override String fillContent(String content) {

        if(this.amountField.getText() == null || this.amountField.getText().length() == 0) {
            content += "No valid amount in package of supplies\n";
        }

        if(this.stockChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No selected stock\n";
        }

        if(this.supplyChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No selected supply\n";
        }

        return content;

    }

    @Override void fillEditObject() {

       this.packDelivery.setAmount(this.amountField.getText());
       this.packDelivery.setStock(this.stockChoiceBox.getValue());
       this.packDelivery.setSupply(this.supplyChoiceBox.getValue());

    }

    public void setPackDelivery(PackDelivery packDelivery, ObservableList<Stock> stocks,
                            ObservableList<Supply> supplies) {

        this.packDelivery =  packDelivery;

        this.amountField.setText(packDelivery.getAmountString());
        this.stockChoiceBox.setItems(stocks);
        this.stockChoiceBox.getSelectionModel().select(packDelivery.getStock());
        this.supplyChoiceBox.setItems(supplies);
        this.supplyChoiceBox.getSelectionModel().select(packDelivery.getSupply());

    }
}
