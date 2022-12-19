package clientGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InventoryRefillingController implements Initializable{
	@FXML
	private Button submitBtn=null;
	
	@FXML
	private Label msgDisplay;
	
	@FXML
	private ChoiceBox<String> machineLocation;
	
	private String[] location = {"choose location","Karmiel","Haifa","Tel-Aviv"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		machineLocation.setValue("choose location");
		machineLocation.getItems().addAll(location);
	}
	
	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/clientGUI/InventoryRefilling.fxml"));
				
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("/clientGUI/InventoryRefilling.css").toExternalForm());
		primaryStage.setTitle("Inventory");
		primaryStage.setScene(scene);
		primaryStage.show();	 	   
	}
	public void submit(ActionEvent event) throws Exception {
		Parent root;
        try {
        	String selectedOption = machineLocation.getValue();
            if (selectedOption.equals("Haifa")) {
//            	root = FXMLLoader.load(getClass().getResource("HaifaInventory.fxml"));
            	root = FXMLLoader.load(getClass().getResource("CreateNewOrder.fxml"));
                Scene scene = new Scene(root);
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } 
            else if (selectedOption.equals("Karmiel")) {
            	root = FXMLLoader.load(getClass().getResource("KarmielInventory.fxml"));
                Scene scene = new Scene(root);
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } 
            else if (selectedOption.equals("choose location")) {
            	msgDisplay.setText("You must choose a machine location");
            }
            else if (selectedOption.equals("Tel-Aviv")) {
            	root = FXMLLoader.load(getClass().getResource("TelAvivInventory.fxml"));
                Scene scene = new Scene(root);
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } 
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
