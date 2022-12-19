package clientGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Server.EchoServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.Item;

public class CreateNewOrderController implements Initializable{
	@FXML
	private TableView<Item> catalogTable;
//	@FXML
//	private TableView<Item> cartTable;
	@FXML
	private TableColumn<Item,ImageView> imageColumnCatalog;
	@FXML
	private TableColumn<Item,String> idColumnCatalog;
	@FXML
	private TableColumn<Item,String> amountColumnCatalog;
//	@FXML
//	private TableColumn<Item,ImageView> imageColumnCart;
//	@FXML
//	private TableColumn<Item,String> idColumnCart;
	@FXML
	private Button update;
//	@FXML
//	private Button remove;
//	@FXML
//	private Button completeOrder;
//	@FXML
//	private TextArea total;
	
	ArrayList<Item> itemsInCatalog = new ArrayList<>();
	ObservableList<Item> listCatalog;
//	ArrayList<Item> itemsInCart = new ArrayList<>();
//	ObservableList<Item> listCart;
	
	
//	public void start(Stage primaryStage) throws Exception {	
//		Parent root = FXMLLoader.load(getClass().getResource("/clientGUI/CreateNewOrder.fxml"));				
//		Scene scene = new Scene(root);
//		primaryStage.setTitle("Client");
//		primaryStage.setScene(scene);
//		primaryStage.show();		
//	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("print newOrder 1");
		imageColumnCatalog.setStyle("-fx-alignment: BASELINE_CENTER");
		idColumnCatalog.setStyle("-fx-alignment: BASELINE_CENTER");
		amountColumnCatalog.setStyle("-fx-alignment: BASELINE_CENTER");
//		imageColumnCart.setStyle("-fx-alignment: BASELINE_CENTER");
//		idColumnCart.setStyle("-fx-alignment: BASELINE_CENTER");
//		System.out.println("print newOrder 1");
//		System.out.println("print newOrder error 1");
//		itemsInCatalog.add(new Item("12","5", "takis.jpg"));
//		System.out.println("print newOrder error");
//		itemsInCatalog.add(new Item("20","2", "maltesers.jpg"));
		catalogTable.getItems().clear();
//		cartTable.getItems().clear();
		LoadColumns();
//		System.out.println("print newOrder 1");
		listCatalog = FXCollections.observableArrayList(itemsInCatalog);
		catalogTable.setItems(listCatalog);
		
	}
	
	public void LoadColumns() {
		System.out.println("print newOrder 2");
		imageColumnCatalog.setCellValueFactory(new PropertyValueFactory<Item,ImageView>("image"));
		idColumnCatalog.setCellValueFactory(new PropertyValueFactory<Item,String>("id"));
		amountColumnCatalog.setCellValueFactory(new PropertyValueFactory<Item,String>("amount"));
//		imageColumnCart.setCellValueFactory(new PropertyValueFactory<Item,ImageView>("image"));
//		idColumnCart.setCellValueFactory(new PropertyValueFactory<Item,String>("id"));
	}
	
	public void updateBtn(ActionEvent event) throws Exception {
		try {
			System.out.println("print newOrder 3");
			int selectedID = catalogTable.getSelectionModel().getSelectedIndex();
			Item addedItem = catalogTable.getItems().get(selectedID);
			catalogTable.getItems().clear();
//			cartTable.getItems().clear();
			LoadColumns();
			listCatalog = FXCollections.observableArrayList(itemsInCatalog);
			catalogTable.setItems(listCatalog);
			ImageView image = new ImageView(addedItem.getImageName());
			image.setFitHeight(60);
			image.setFitWidth(60);
			addedItem.setImage(image);
//			itemsInCart.add(addedItem);
//			listCart = FXCollections.observableArrayList(itemsInCart);
//			cartTable.setItems(listCart);
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	}
	
//	public void removeBtn(ActionEvent event) throws Exception {
//		try {
//			System.out.println("print newOrder 4");
//			int selectedID = cartTable.getSelectionModel().getSelectedIndex();
//			Item removedItem = cartTable.getItems().get(selectedID);
//			cartTable.getItems().clear();
//			LoadColumns();
//			itemsInCart.remove(removedItem);
//			listCart = FXCollections.observableArrayList(itemsInCart);
//			cartTable.setItems(listCart);
//			
//			listCatalog = FXCollections.observableArrayList(itemsInCatalog);
//			catalogTable.setItems(listCatalog);
//		}
//		catch(IndexOutOfBoundsException e) {
//			
//		}
//	}
	
//	public void completeOrderBtn(ActionEvent event) throws Exception {
//		System.out.println("complete button");
//	}
}
