package client;
import javafx.application.Application;

import javafx.stage.Stage;
import logic.Subscriber;

import java.util.ArrayList;
import java.util.Vector;
//import gui.SubscriberInfoFormController;
import client.ClientController;
//import gui.EkrutFrameController;
import clientGUI.EkrutFrameController;
import clientGUI.InventoryRefillingController;

public class ClientUI extends Application {
	public static ClientController chat; //only one instance

	public static void main( String args[] ) throws Exception
	   { 
		    launch(args);  
	   } // end main
	 
	@Override
	public void start(Stage primaryStage) throws Exception {
		 chat= new ClientController("localhost",5555);
		 ArrayList<String> newClient = new ArrayList<>();
		 newClient.add("newClient");
		 ClientUI.chat.accept(newClient);
		// TODO Auto-generated method stub
		 
//		EkrutFrameController aFrame = new EkrutFrameController(); // create EkrutFrame
//		 
//		aFrame.start(primaryStage);
		InventoryRefillingController InventoryFrame = new InventoryRefillingController(); // create EkrutFrame
		InventoryFrame.start(primaryStage);
	}
	
	
}
