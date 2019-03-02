package DatabaseApp.viewExtended;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public abstract class EditController {

    private Stage dialogStage;

    private boolean acceptClicked;

    @FXML public void initialize() {

    }

    @FXML public void handleAccept() {
        if(isInputValid()) {
            fillEditObject();

            this.acceptClicked = true;
            dialogStage.close();
        }
    }

    @FXML public void handleCancel() {
        this.dialogStage.close();
    }

    private boolean isInputValid() {
        String content = "";
        content = fillContent(content);

        if(content.length() == 0) {
            return checkSQL();
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

    abstract void fillEditObject();

    abstract String fillContent(String content);

    abstract boolean checkSQL();

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isAcceptClicked() {
        return this.acceptClicked;
    }
}
