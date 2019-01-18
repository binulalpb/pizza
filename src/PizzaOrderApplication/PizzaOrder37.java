package PizzaOrderApplication;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*;




public class PizzaOrder37 extends Application{


    public static void main(String[] args)
    {
        launch(args);
    }
    Stage stage;
    //Customer name, phone and address fields
    TextField txtName;
    TextField txtPhone;
    TextField txtAddress;

    // Size radio buttons
    RadioButton rdoSmall;
    RadioButton rdoMedium;
    RadioButton rdoLarge;
    // Crust style radio buttons
    RadioButton rdoThin;
    RadioButton rdoThick;

    //Toppings radio buttons

    CheckBox chkPepperoni;
    CheckBox chkSausage;
    CheckBox chkLinguica;
    CheckBox chkOLives;
    CheckBox chkMushrooms;
    CheckBox chkTomatoes;
    CheckBox chkAnchovies;

    @Override public void start(Stage primaryStage)
    {
        stage= primaryStage;

        // Create the top pane

        Text textHeading = new Text("Order your pizza");
        textHeading.setFont(new Font(20));
        HBox paneTop =new HBox(textHeading);
        paneTop.setPadding(new Insets(20,10,20,10));

        // create the customs pane

        // Create the name label and text field

        Label lblName = new Label("Name");
        lblName.setPrefWidth(100);
        txtName = new TextField();
        txtName.setPrefColumnCount(20);
        txtName.setPromptText("Enter the customer here");
        txtName.setMaxWidth(Double.MAX_VALUE);
        HBox paneName = new HBox(lblName, txtName);

        //Create the phone number label and text field

        Label lblPhone = new Label ("Phone Number");
        lblPhone.setPrefWidth(100);
        txtPhone = new TextField();
        txtPhone.setPrefColumnCount(20);
        txtPhone.setPromptText("Enter the customer Phone number here ");
        HBox panePhone = new HBox(lblPhone, txtPhone);

        //Cretae the field for address and text field

        Label lblAddress = new Label ("Address:");
        lblAddress.setPrefWidth(100);
        txtAddress.setPrefColumnCount(20);
        txtAddress.setPromptText("Enter the customer address:");
        HBox paneAddress  = new HBox(lblAddress, txtAddress);

        // create the customer pane

        VBox paneCustomer=new VBox(10, paneName, paneAddress);

        // Create the order
        //Create the size pane

        Label lblSize = new Label ("Size");
        rdoSmall = new RadioButton ("Small");
        rdoMedium = new RadioButton ("Medium ");
        rdoLarge = new RadioButton("Large ");
        rdoMedium.setSelected(true);
        ToggleGroup groupSize = new ToggleGroup();
        rdoSmall.setToggleGroup(groupSize);
        rdoMedium.setToggleGroup(groupSize);
        rdoLarge.setToggleGroup(groupSize);

        VBox paneSize = new VBox(lblSize,rdoSmall,rdoMedium, rdoLarge);
        paneSize.setSpacing(10);

        // create the crsust pane

        Label lblCrust = new Label ("Crust");
        rdoThin = new RadioButton("Thin");
        rdoThick = new RadioButton("thick");
        rdoThin.setSelected(true);
        ToggleGroup groupCrust=new ToggleGroup();

        rdoThin.setToggleGroup(groupCrust);
        rdoThick.setToggleGroup(groupCrust);

        VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
        paneCrust.setSpacing(10);

        // Cretae the topping pane

        Label lblToppings = new Label (" toppings");
        chkPepperoni =new CheckBox("Pepproni");
        chkSausage =new CheckBox("Sauasage");
        chkLinguica =new CheckBox("Linguica");
        chkOLives =new CheckBox("Olives");
        chkMushrooms =new CheckBox("Mushrooms");

        chkTomatoes =new CheckBox("Tomotaoes");
        chkAnchovies =new CheckBox("Anchovies");

        FlowPane paneToppings = new FlowPane(Orientation.VERTICAL,chkPepperoni,chkSausage,chkLinguica,chkOLives,chkMushrooms,
                chkTomatoes, chkAnchovies);
        paneToppings.setPadding(new Insets(10,0,10,0));
        paneToppings.setHgap(20);
        paneToppings.setVgap(10);
        paneToppings.setPrefWrapLength(100);
        VBox paneTopping = new VBox(lblToppings,paneToppings);

        //add the size, crust and toopings pane to the order pane
        HBox paneOrder =new HBox(50, paneSize, paneCrust, paneTopping);


        //Cretae the center pane
        VBox paneCenter = new VBox(20, paneCustomer, paneOrder);
        paneCenter.setPadding(new Insets(0,10,0,10));

        //Create the Bottom pane
        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(80);
        btnOK.setOnAction(e -> btnOK_Click());
        Button btnCancel = new Button ("Cancel");
        btnCancel.setPrefWidth(80);
        btnCancel.setOnAction(e -> btnCancel_Click());

        Region spacer = new Region();
        HBox paneBottom = new HBox (10, spacer, btnOK, btnCancel);
        paneBottom.setHgrow(spacer, Priority.ALWAYS);
        paneBottom.setPadding(new Insets(20,10,20,10));

       // Finish the scene
        BorderPane paneMain = new BorderPane();
        paneMain.setTop(paneTop);
        paneMain.setCenter(paneCenter);
        paneMain.setBottom(paneBottom);
        // Create the scene and the stage

        Scene scene = new Scene (paneMain);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.show();
    }

    private void btnOK_Click() {

    }

    public String buildToppings() {
        return buildToppings();
    }

    public String buildToppings(CheckBox chk, String msg)
    {
        //Helper method for displaying the list of toppings
        if (chk.isSelected())
        {
            if (!msg.equals(""))
            {
                msg+=",";
            }
            msg+= chk.getText();
        }
        return msg;
    }
    public void btnCancel_Click()
    {
        stage.close();
    }

    private class Label1 extends Label {
        public Label1(String name) {
        }
    }

}






