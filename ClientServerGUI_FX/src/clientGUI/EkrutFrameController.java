package clientGUI;

import java.io.IOException;
import java.util.ArrayList;

import Server.EchoServer;
import client.ChatClient;
import client.ClientController;
import client.ClientUI;
import common.ChatIF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Subscriber;


public  class EkrutFrameController   {
	private SubscriberInfoFormController sfc;	
	private static int itemIndex = 3;
	
	@FXML
	private Button btnExit = null;
	
	@FXML
	private Button btnSend = null;
	
	@FXML
	private TextField idtxt;
	
	private String getID() {
		return idtxt.getText();
	}
	
	public void Send(ActionEvent event) throws Exception {
		String id;
		FXMLLoader loader = new FXMLLoader();
		
		id=getID();
		if(id.trim().isEmpty())
		{

			System.out.println("You must enter an id number");
		}
		else
		{
			ArrayList<String> searchForID = new ArrayList<>();
			searchForID.add("Search");
			searchForID.add(id);
			ClientUI.chat.accept(searchForID);
			
		
			if(ChatClient.s1.getId().equals("Error"))
			{
				System.out.println("Subscriber ID Not Found");
				
			}
			else {
				System.out.println("Subscriber ID Found");
				((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
				Stage primaryStage = new Stage();
				Pane root = loader.load(getClass().getResource("/clientGUI/SubscriberInfoForm.fxml").openStream());
				SubscriberInfoFormController subscriberInfoFormController = loader.getController();	
				subscriberInfoFormController.loadSubscriber(ChatClient.s1);
				Scene scene = new Scene(root);			
				scene.getStylesheets().add(getClass().getResource("/clientGUI/SubscriberInfoForm.css").toExternalForm());
				primaryStage.setTitle("Subscriber Info Tool");
	
				primaryStage.setScene(scene);		
				primaryStage.show();
			}
		}
	}

	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/clientGUI/EkrutFrame.fxml"));
				
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/clientGUI/EkrutFrame.css").toExternalForm());
		primaryStage.setTitle("Searching for Ekrut Subscriber Tool");
		primaryStage.setScene(scene);
		primaryStage.show();	 	   
	}
	
	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("exit Searching for Ekrut Subscriber Tool");	
		System.exit(0);
	}
	
	public void loadStudent(Subscriber s1) {
		this.sfc.loadSubscriber(s1);
	}	
	
	public  void display(String message) {
		System.out.println("message");
		
	}
	
}
