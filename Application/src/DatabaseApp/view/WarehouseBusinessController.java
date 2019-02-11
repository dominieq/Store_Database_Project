package DatabaseApp.view;

import DatabaseApp.DatabaseApp;
import DatabaseApp.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class WarehouseBusinessController {

    private DatabaseApp app;

    /**
     * Fields that refer to Tab STOCK:
     *     Stock attributes:
     */
    @FXML private ChoiceBox<Stock> stockBox;
    @FXML private ChoiceBox<String> stockTraitsBox;
    @FXML private Label stockLabel;
    @FXML private Label stockAmountLabel;
    @FXML private Label stockWarehouseLabel;
    @FXML private Label stockMerchandiseLabel;
    @FXML private TextField stockSearchField;
    /**
     *     PackDelivery attributes:
     */
    @FXML private ChoiceBox<PackDelivery> packDeliveryBox;
    @FXML private ChoiceBox<String> packDeliveryTraitsBox;
    @FXML private Label packDeliveryNumberLabel;
    @FXML private Label packDeliveryAmountLabel;
    @FXML private Label packDeliveryMerchLabel;
    @FXML private Label packDeliveryWarehouseLabel;
    @FXML private TextField packDeliverySearchField;
    /**
     *     Order attributes:
     */
    @FXML private ChoiceBox<PackOrder> packOrderBox;
    @FXML private ChoiceBox<String> packOrderTraitsBox;
    @FXML private Label packOrderNumberLabel;
    @FXML private Label packOrderAmountLabel;
    @FXML private Label packOrderMerchLabel;
    @FXML private Label packOrderWarehouseLabel;
    @FXML private TextField packOrderSearchField;

    /**
     * Fields that refer to Tab MERCHANDISE:
     *     Merchandise attributes:
     */
    @FXML private ChoiceBox<Merchandise> merchBox;
    @FXML private ChoiceBox<String> merchTraitsBox;
    @FXML private Label merchLabel;
    @FXML private Label merchNameLabel;
    @FXML private Label merchRetailLabel;
    @FXML private Label merchMarketLabel;
    @FXML private Label merchProducerLabel;
    @FXML private Label merchCategoryLabel;
    @FXML private TextField merchSearchField;
    @FXML private ChoiceBox<Category> merchCategoryBox;
    @FXML private ChoiceBox<Producer> merchProducerBox;
    @FXML private ChoiceBox<String> merchCategoryTraitsBox;
    @FXML private ChoiceBox<String> merchProducerTraitsBox;
    @FXML private TextField merchCategorySearchField;
    @FXML private TextField merchProducerSearchField;
    /**
     *     Producer attributes:
     */
    @FXML private ChoiceBox<Producer> producerBox;
    @FXML private ChoiceBox<String> producerTraitsBox;
    @FXML private Label producerLabel;
    @FXML private Label producerNameLabel;
    @FXML private Label prodcuerAddressLabel;
    @FXML private Label producerEmailLabel;
    @FXML private Label prodcuerTelNumLabel;
    @FXML private Label producerWebLabel;
    @FXML private TextField producerSearchField;
    /**
     *     Category attributes:
     */
    @FXML private ChoiceBox<Category> categoryBox;
    @FXML private ChoiceBox<String> categoryTraitsBox;
    @FXML private Label categoryLabel;
    @FXML private Label categoryNameLabel;
    @FXML private TextField categorySearchField;

    /**
     * Fields that refer to Tab SUPPLIERS & SUPPLIES:
     *     Supplier attributes:
     */
    @FXML private ChoiceBox<Supplier> supplierBox;
    @FXML private ChoiceBox<String> supplierTraitsBox;
    @FXML private Label supplierLabel;
    @FXML private Label supplierNameLabel;
    @FXML private Label supplierAddressLabel;
    @FXML private Label supplierTelNumLabel;
    @FXML private Label supplierEmailLabel;
    @FXML private TextField supplierSearchField;
    /**
     *     Supply attributes:
     */
    @FXML private ChoiceBox<Supply> supplyBox;
    @FXML private ChoiceBox<String> supplyTraitsBox;
    @FXML private Label supplyLabel;
    @FXML private Label supplyStartLabel;
    @FXML private Label supplyEndLabel;
    @FXML private Label supplySupplierLabel;
    @FXML private TextField supplySearchField;

    /**
     * Fields that refer to Tab ORDERS:
     *     Order attributes:
     */
    @FXML private ChoiceBox<Order> orderBox;
    @FXML private ChoiceBox<String> orderTraitsBox;
    @FXML private Label orderLabel;
    @FXML private Label orderStartLabel;
    @FXML private Label orderEndLabel;
    @FXML private Label orderRecipientLabel;
    @FXML private Label orderCourierLabel;
    @FXML private Label orderRecipientRightLabel;
    @FXML private Label orderRecipientNameLabel;
    @FXML private Label orderRecipientSurnameLabel;
    @FXML private Label orderRecipientAddressLabel;
    @FXML private Label orderRecipientTelNumLabel;
    @FXML private Label orderCourierRightLabel;
    @FXML private Label orderCourierTelNumLabel;
    @FXML private TextField orderSearchField;
    /**
     *     Recipient attributes:
     */
    @FXML private ChoiceBox<Recipient> recipientBox;
    @FXML private ChoiceBox<String> recipientTraitsBox;
    @FXML private Label recipientLabel;
    @FXML private Label recipientNameLabel;
    @FXML private Label recipientSurnameLabel;
    @FXML private Label recipientAddressLabel;
    @FXML private Label recipientTelNumLabel;
    @FXML private TextField recipientSearchField;
    /**
     *     Courier attributes:
     */
    @FXML private ChoiceBox<Courier> courierBox;
    @FXML private ChoiceBox<String> courierTraitsBox;
    @FXML private Label courierLabel;
    @FXML private Label courierTelNumLabel;
    @FXML private TextField courierSearchField;


    public WarehouseBusinessController() {}

    @FXML private void initialize() {}

    /**
     * Sets WarehouseBusinessController's app
     * @param app DatabaseApp
     */
    public void setApp(DatabaseApp app) {
        this.app = app;
    }
}
