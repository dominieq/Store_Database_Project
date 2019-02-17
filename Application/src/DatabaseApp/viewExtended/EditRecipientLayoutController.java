package DatabaseApp.viewExtended;

import DatabaseApp.models.Recipient;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditRecipientLayoutController extends EditController {

    @FXML private TextField indexField;

    @FXML private TextField nameField;

    @FXML private TextField surnameField;

    @FXML private TextField addressField;

    @FXML private TextField telNumField;

    private Recipient recipient;

    @Override String fillContent(String content) {

        if(indexField.getText() == null || indexField.getText().length() == 0) {
            content += "No valid recipient's index\n";
        }

        if(nameField.getText() == null || nameField.getText().length() == 0) {
            content += "No valid recipient's name\n";
        }

        if(addressField.getText() == null || addressField.getText().length() == 0) {
            content += "No valid recipient's address\n";
        }

        if(telNumField.getText() == null || telNumField.getText().length() == 0) {
            content += "No valid recipient's telephone number\n";
        }

        return content;

    }
    @Override void fillEditObject() {

        this.recipient.setIndex(this.indexField.getText());
        this.recipient.setName(this.nameField.getText());
        this.recipient.setSurname(this.surnameField.getText());
        this.recipient.setAddress(this.addressField.getText());
        this.recipient.setTelNum(this.telNumField.getText());

    }

    public void setRecipient(Recipient recipient) {

        this.recipient = recipient;

        this.indexField.setText(this.recipient.getIndexString());
        this.nameField.setText(this.recipient.getName());
        this.addressField.setText(this.recipient.getAddress());
        this.telNumField.setText(this.recipient.getTelNum());
        this.surnameField.setText(this.recipient.getSurname());

    }
}
