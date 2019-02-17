package DatabaseApp.viewExtended;

import DatabaseApp.models.Merchandise;
import DatabaseApp.models.Stock;
import DatabaseApp.models.Warehouse;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EditStockLayoutController extends EditController {

    @FXML private TextField amountField;

    @FXML private ChoiceBox<Merchandise> merchandiseChoiceBox;

    @FXML private ChoiceBox<Warehouse> warehouseChoiceBox;

    private Stock stock;

    @Override String fillContent(String content) {

        if(this.amountField.getText() == null || this.amountField.getText().length() == 0) {
            content += "No valid stock's amount\n";
        }

        if(this.merchandiseChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No selected merchandise\n";
        }

        if(this.warehouseChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No selected warehouse\n";
        }

        return content;

    }
    @Override void fillEditObject() {

       this.stock.setAmount(this.amountField.getText());
       this.stock.setMerchandise(this.merchandiseChoiceBox.getValue());
       this.stock.setWarehouse(this.warehouseChoiceBox.getValue());

    }

    public void setStock(Stock stock, ObservableList<Merchandise> merchandises,
                            ObservableList<Warehouse> warehouses) {

        this.stock =  stock;

        this.amountField.setText(stock.getAmountString());
        this.merchandiseChoiceBox.setItems(merchandises);
        this.merchandiseChoiceBox.getSelectionModel().select(stock.getMerchandise());
        this.warehouseChoiceBox.setItems(warehouses);
        this.warehouseChoiceBox.getSelectionModel().select(stock.getWarehouse());

    }
}
