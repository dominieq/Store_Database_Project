package DatabaseApp.viewExtended;

import DatabaseApp.exceptions.WrongDateError;
import DatabaseApp.models.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class EditOrderLayoutController extends EditController {

    @FXML private TextField numberField;

    @FXML private TextField startDateField;

    @FXML private TextField endDateField;

    @FXML private ChoiceBox<Courier> courierChoiceBox;

    @FXML private ChoiceBox<Recipient> recipientChoiceBox;

    private Order order;

    @Override String fillContent(String content) {

        if(this.numberField.getText() == null || this.numberField.getText().length() == 0) {
            content += "No valid order's amount\n";
        }

        if(this.startDateField.getText() == null || this.startDateField.getText().length() == 0) {
            content += "No valid order's start date\n";
        }

        try {
            this.order.setStartDate(this.startDateField.getText());
        } catch (WrongDateError wrongDateError) {
            content += "Wrong start date format\n";
        }

        try {
            this.order.setEndDate(this.endDateField.getText());
        } catch (WrongDateError wrongDateError) {
            content += "Wrong end dare format\n";
        }

        if(this.courierChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No selected courier\n";
        }

        if(this.recipientChoiceBox.getSelectionModel().getSelectedItem() == null) {
            content += "No selected recipient\n";
        }

        return content;

    }

    @Override void fillEditObject() {

       this.order.setInvoiceNumber(this.numberField.getText());
       this.order.setCourier(this.courierChoiceBox.getValue());
       this.order.setRecipient(this.recipientChoiceBox.getValue());

    }

    public void setOrder(Order order, ObservableList<Courier> couriers,
                            ObservableList<Recipient> recipients) {

        this.order =  order;

        this.numberField.setText(order.getInvoiceString());
        this.startDateField.setText(order.getStartDateString());
        this.endDateField.setText(order.getEndDateString());
        this.courierChoiceBox.setItems(couriers);
        this.courierChoiceBox.getSelectionModel().select(order.getCourier());
        this.recipientChoiceBox.setItems(recipients);
        this.recipientChoiceBox.getSelectionModel().select(order.getRecipient());

    }
}
