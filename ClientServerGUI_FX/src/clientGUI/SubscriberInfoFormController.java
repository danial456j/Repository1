package clientGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Server.EchoServer;
import client.ChatClient;
import client.ClientController;
import client.ClientUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Subscriber;

public class SubscriberInfoFormController implements Initializable {
	private Subscriber s;

	@FXML
	private Label lblID;
	@FXML
	private Label lblFirstName;
	@FXML
	private Label lblLastName;
	@FXML
	private Label phoneNumber;
	@FXML
	private Label emailAddress;
	@FXML
	private Label creditCardNumber;
	@FXML
	private Label subscriberNumber;

	@FXML
	private TextField txtID;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtPhoneNumber;
	@FXML
	private TextField txtemailAddress;
	@FXML
	private TextField txtcreditCardNumber;
	@FXML
	private TextField txtsubscriberNumber;

	@FXML
	private Button btnExit = null;


	ObservableList<String> list;

	public void loadSubscriber(Subscriber s1) {
		this.s = s1;
		System.out.println(s);
		this.txtID.setText(s.getId());
		this.txtFirstName.setText(s.getFirstName());
		this.txtLastName.setText(s.getLastName());
		this.txtPhoneNumber.setText(s.getPhoneNumber());
		this.txtemailAddress.setText(s.getEmailAddress());
		this.txtcreditCardNumber.setText(s.getCreditCardNumber());
		this.txtsubscriberNumber.setText(s.getSubscriberNumber());
	}
	
	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("exit Searching for Ekrut Subscriber Tool");	
		System.exit(0);
	}
	
	
	public void getSaveBtn(ActionEvent event) throws Exception {
		ArrayList<String> updateSubscriberInof = new ArrayList<>();
		updateSubscriberInof.add("Update");
		updateSubscriberInof.add(s.getId());
		updateSubscriberInof.add(txtcreditCardNumber.getText());
		updateSubscriberInof.add(txtsubscriberNumber.getText());
		ClientUI.chat.accept(updateSubscriberInof);
		
	
		if(ChatClient.s1.getId().equals("Error"))
		{
			System.out.println("Subscriber Info was not Updated");
			
		}
		else {
			System.out.println("Subscriber Info was Updated");
		}
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
