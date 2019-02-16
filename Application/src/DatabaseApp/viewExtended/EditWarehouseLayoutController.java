package DatabaseApp.viewExtended;

import DatabaseApp.models.Warehouse;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditWarehouseLayoutController {

    @FXML private TextField indexField;

    @FXML private TextField addressField;

    private Stage dialogStage;

    private Warehouse warehouse;

    private boolean acceptClicked;

    @FXML public void initialize() {

    }

    @FXML private void handleAccept() {
        if(isInputValid()) {
            warehouse.setIndex(indexField.getText());
            warehouse.setAddress(addressField.getText());

            this.acceptClicked = true;
            dialogStage.close();
        }
    }

    @FXML private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String content = "";
        if(indexField.getText() == null || indexField.getText().length() == 0) {
            content += "No valid index\n";
        }
        if(addressField.getText() == null || addressField.getText().length() == 0) {
            content += "No valid address";
        }
        if(content.length() == 0) {
            return true;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields:");
            alert.setContentText(content);
            alert.showAndWait();
            return false;
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setWorker(Warehouse warehouse) {
        this.warehouse = warehouse;

        this.indexField.setText(warehouse.getIndexString());
        this.addressField.setText(warehouse.getAddress());

    }

    public boolean isAcceptClicked() {
        return this.acceptClicked;
    }
}
