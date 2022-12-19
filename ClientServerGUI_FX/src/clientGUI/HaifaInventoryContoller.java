package clientGUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.Item;


public class HaifaInventoryContoller {
	@FXML 
	private Button backBtn=null;
	@FXML
	private Button updateBtn;

	@FXML
	private TableView<Item> itemsTable;

//	@FXML
//	private TableColumn<Item, ImageView> image_table;

	@FXML
	private TableColumn<Item, Integer> ID_table;

	@FXML
	private TableColumn<Item, Integer> amount_table;

	
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





	