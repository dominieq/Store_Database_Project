package DatabaseApp.viewExtended;

import DatabaseApp.models.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EditPackOrderLayoutController extends EditController {

    @FXML private TextField amountField;

    @FXML private ChoiceBox<Stock> stockChoiceBox;

    @FXML private ChoiceBox<Order> orderChoiceBox;

    private PackOrder packOrder;

    @Override String fillContent(String content) {

        if(this.amountField.getText() == null || this.amountField.getText().length() == 0) {
            content += "No valid amount in package of orders\n";
        }

        if(this.stockChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No selected stock\n";
        }

        if(this.orderChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No selected order\n";
        }

        return content;

    }

    @Override boolean checkSQL() {

        // TODO SQL FUNCTION

        return true;
    }

    @Override void fillEditObject() {

       this.packOrder.setAmount(this.amountField.getText());
       this.packOrder.setStock(this.stockChoiceBox.getValue());
       this.packOrder.setOrder(this.orderChoiceBox.getValue());
       this.packOrder.createID();

    }

    public void setPackOrder(PackOrder packOrder, ObservableList<Stock> stocks,
                            ObservableList<Order> orders) {

        this.packOrder =  packOrder;

        this.amountField.setText(packOrder.getAmountString());
        this.stockChoiceBox.setItems(stocks);
        this.stockChoiceBox.getSelectionModel().select(packOrder.getStock());
        this.orderChoiceBox.setItems(orders);
        this.orderChoiceBox.getSelectionModel().select(packOrder.getOrder());

    }
}
