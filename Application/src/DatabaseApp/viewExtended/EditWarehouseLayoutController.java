package DatabaseApp.viewExtended;

import DatabaseApp.models.Warehouse;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditWarehouseLayoutController extends EditController {

    @FXML private TextField indexField;

    @FXML private TextField addressField;

    private Warehouse warehouse;

    @Override String fillContent(String content) {

        if(indexField.getText() == null || indexField.getText().length() == 0) {
            content += "No valid index\n";
        }

        if(addressField.getText() == null || addressField.getText().length() == 0) {
            content += "No valid address";
        }

        return content;

    }

    @Override void fillEditObject() {

        warehouse.setIndex(indexField.getText());
        warehouse.setAddress(addressField.getText());

    }

    public void setWarehouse(Warehouse warehouse) {

        this.warehouse = warehouse;

        this.indexField.setText(warehouse.getIndexString());
        this.addressField.setText(warehouse.getAddress());

    }
}
