package serverGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Client;
import logic.Subscriber;
import Server.EchoServer;
import Server.ServerUI;
import clientGUI.SubscriberInfoFormController;

public class ServerPortFrameController  implements Initializable {
	private SubscriberInfoFormController sfc;	
	
	
	String temp="";
	
	@FXML
	private TableView<Client> tableView;
	@FXML
	private TableColumn<Client,String> columnIP;
	@FXML
	private TableColumn<Client,String> columnHost;
	@FXML
	private TableColumn<Client,String> columnStatus;
	
	@FXML
	private Button btnExit = null;
	@FXML
	private Button btnStart= null;
	@FXML
	private Button btnRefreshTable = null;
	@FXML
	private Label lbllist;
	@FXML
	private TextField portxt;
	
	ObservableList<Client> list;
	
	private String getport() {
		return portxt.getText();			
	}
	
	public void StartBtn(ActionEvent event) throws Exception {
		String p;
		
		p=getport();
		if(p.trim().isEmpty()) {
			System.out.println("You must enter a port number");
					
		}
		else
		{
			getRefreshTable();
			ServerUI.runServer(p);
		}
	}

	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/serverGUI/ServerPort.fxml"));				
		Scene scene = new Scene(root);
		Image EkrutIcon = new Image("logo.png");
		scene.getStylesheets().add(getClass().getResource("/serverGUI/ServerPort.css").toExternalForm());
		primaryStage.getIcons().add(EkrutIcon);
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public void getRefreshTableBtn(ActionEvent event) throws Exception {
		getRefreshTable();
		System.out.println(EchoServer.clients);
	}
	
	public void getRefreshTable() {
		tableView.getItems().clear();
		LoadColumns();
		list = FXCollections.observableArrayList(EchoServer.clients);
		tableView.setItems(list);
	}
	
	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("exit Subscribers Tool");
		System.exit(0);			
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LoadColumns();
		
	}
	
	public void LoadColumns() {
		columnIP.setCellValueFactory(new PropertyValueFactory<>("IP"));
		columnHost.setCellValueFactory(new PropertyValueFactory<>("Host"));
		columnStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
	}

}