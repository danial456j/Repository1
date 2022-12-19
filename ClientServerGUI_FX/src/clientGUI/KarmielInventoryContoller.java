package clientGUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class KarmielInventoryContoller {
	@FXML 
	private Button backBtn=null;
	
	public void back(ActionEvent event) throws Exception {
		Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("InventoryRefilling.fxml"));
            Scene scene = new Scene(root);
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}