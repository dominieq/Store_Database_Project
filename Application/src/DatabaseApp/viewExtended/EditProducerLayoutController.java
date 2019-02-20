package DatabaseApp.viewExtended;

import DatabaseApp.models.Producer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditProducerLayoutController extends EditController {

    @FXML private TextField indexField;

    @FXML private TextField nameField;

    @FXML private TextField addressField;

    @FXML private TextField telNumField;

    @FXML private TextField mailField;

    @FXML private TextField webPageField;

    private Producer producer;

    @Override String fillContent(String content) {

        if(indexField.getText() == null || indexField.getText().length() == 0) {
            content += "No valid producer's index\n";
        }

        if(nameField.getText() == null || nameField.getText().length() == 0) {
            content += "No valid producer's name\n";
        }

        return content;

    }

    @Override boolean checkSQL() {

        // TODO SQL FUNCTION

        return true;
    }

    @Override void fillEditObject() {

        this.producer.setIndex(this.indexField.getText());
        this.producer.setName(this.nameField.getText());
        this.producer.setAddress(this.addressField.getText());
        this.producer.setTelNum(this.telNumField.getText());
        this.producer.setMail(this.mailField.getText());
        this.producer.setWebPage(this.webPageField.getText());

    }

    public void setProducer(Producer producer) {

        this.producer = producer;

        this.indexField.setText(this.producer.getIndexString());
        this.nameField.setText(this.producer.getName());
        this.addressField.setText(this.producer.getAddress());
        this.telNumField.setText(this.producer.getTelNum());
        this.mailField.setText(this.producer.getMail());
        this.webPageField.setText(this.producer.getWebPage());

    }
}
