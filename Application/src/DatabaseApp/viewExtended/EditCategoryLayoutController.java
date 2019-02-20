package DatabaseApp.viewExtended;

import DatabaseApp.models.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditCategoryLayoutController extends EditController {

    @FXML private TextField indexField;

    @FXML private TextField nameField;

    private Category category;

    @Override String fillContent(String content) {

        if(indexField.getText() == null || indexField.getText().length() == 0) {
            content += "No valid category's index\n";
        }

        if(nameField.getText() == null || nameField.getText().length() == 0) {
            content += "No valid category's name";
        }

        return content;
    }

    @Override boolean checkSQL() {

        // TODO SQL FUNCTION

        return true;
    }

    @Override void fillEditObject() {

        this.category.setIndex(indexField.getText());
        this.category.setName(nameField.getText());

    }

    public void setCategory(Category category) {

        this.category = category;

        this.indexField.setText(this.category.getIndexString());
        this.nameField.setText(this.category.getName());

    }
}
