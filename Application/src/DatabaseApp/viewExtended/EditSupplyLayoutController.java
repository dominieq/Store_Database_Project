package DatabaseApp.viewExtended;

import DatabaseApp.exceptions.WrongDateError;
import DatabaseApp.models.Supplier;
import DatabaseApp.models.Supply;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EditSupplyLayoutController extends EditController {

    @FXML private TextField invoiceNumberField;

    @FXML private TextField startDateField;

    @FXML private TextField endDateField;

    @FXML private ChoiceBox<Supplier> supplierChoiceBox;

    private Supply supply;

    @Override String fillContent(String content) {
        if(invoiceNumberField.getText() == null || invoiceNumberField.getText().length() == 0) {
            content += "No valid supply's invoice number\n";
        }

        try {
            this.supply.setStartDate(this.startDateField.getText());
        } catch (WrongDateError wrongDateError) {
            content += "Wrong supply's start date format\n";
        }

        try {
            this.supply.setEndDate(this.endDateField.getText());
        } catch (WrongDateError wrongDateError) {
            content += "Wrong supply's end date format\n";
        }

        if(supplierChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No supplier selected\n";
        }

        return content;
    }

    @Override void fillEditObject() {

        this.supply.setInvoicNumber(this.invoiceNumberField.getText());
        this.supply.setSupplier(this.supplierChoiceBox.getValue());

    }

    public void setSupply(Supply supply, ObservableList<Supplier> suppliers) {

        this.supply = supply;

        this.invoiceNumberField.setText(this.supply.getInvoiceNumberString());
        this.startDateField.setText(this.supply.getStartDateString());
        this.endDateField.setText(this.supply.getEndDateString());
        this.supplierChoiceBox.setItems(suppliers);

    }
}
