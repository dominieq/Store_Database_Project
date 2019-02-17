package DatabaseApp.viewExtended;

import DatabaseApp.models.Supplier;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditSupplierLayoutController extends EditController {

    @FXML private TextField indexField;

    @FXML private TextField nameField;

    @FXML private TextField addressField;

    @FXML private TextField telNumField;

    @FXML private TextField mailField;

    private Supplier supplier;

    @Override String fillContent(String content) {

        if(indexField.getText() == null || indexField.getText().length() == 0) {
            content += "No valid supplier's index\n";
        }

        if(nameField.getText() == null || nameField.getText().length() == 0) {
            content += "No valid supplier's name\n";
        }

        if(addressField.getText() == null || addressField.getText().length() == 0) {
            content += "No valid supplier's address\n";
        }

        if(telNumField.getText() == null || telNumField.getText().length() == 0) {
            content += "No valid supplier's telephone number\n";
        }

        return content;
    }

    @Override void fillEditObject() {

        this.supplier.setIndex(this.indexField.getText());
        this.supplier.setName(this.nameField.getText());
        this.supplier.setAddress(this.addressField.getText());
        this.supplier.setTelNum(this.telNumField.getText());
        this.supplier.setMail(this.mailField.getText());

    }

    public void setSupplier(Supplier supplier) {

        this.supplier = supplier;

        this.indexField.setText(this.supplier.getIndexString());
        this.nameField.setText(this.supplier.getName());
        this.addressField.setText(this.supplier.getAddress());
        this.telNumField.setText(this.supplier.getTelNum());
        this.mailField.setText(this.supplier.getMail());

    }
}
