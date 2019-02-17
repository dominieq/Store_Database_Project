package DatabaseApp.viewExtended;

import DatabaseApp.models.Courier;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditCourierLayoutController extends EditController {

    @FXML private TextField indexField;

    @FXML private TextField telNumField;

    private Courier courier;

    @Override String fillContent(String content) {

        if(indexField.getText() == null || indexField.getText().length() == 0) {
            content += "No valid index\n";
        }

        if(telNumField.getText() == null || telNumField.getText().length() == 0) {
            content += "No valid telephone number\n";
        }

        return content;
    }
    @Override void fillEditObject() {

        this.courier.setIndex(indexField.getText());
        this.courier.setTelNum(telNumField.getText());

    }

    public void setCourier(Courier courier) {

        this.courier = courier;

        this.indexField.setText(this.courier.getIndexString());
        this.telNumField.setText(this.courier.getTelNum());

    }
}
