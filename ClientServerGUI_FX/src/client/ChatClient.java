// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import client.*;
import common.ChatIF;
import logic.Client;
import logic.Subscriber;

import java.io.*;
import java.util.ArrayList;

import Server.EchoServer;
import Server.ServerUI;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 
  public static Subscriber  s1 = new Subscriber(null,null,null,null,null,null,null);
  public static boolean awaitResponse = false;

  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
	 
  public ChatClient(String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    openConnection();
    
    
  }

  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
	  System.out.println("--> handleMessageFromServer");
	  
	  if(msg instanceof ArrayList) {
	      ArrayList<String> info = (ArrayList<String>)msg;
	      
		  awaitResponse = false;
		  s1.setFirstName(info.get(0));
		  s1.setLastName(info.get(1));
		  s1.setId(info.get(2));
		  s1.setPhoneNumber(info.get(3));
		  s1.setEmailAddress(info.get(4));
		  s1.setCreditCardNumber(info.get(5));
		  s1.setSubscriberNumber(info.get(6));
	  }
	  
	  if(msg instanceof String) {
		  awaitResponse = false;
	  }
	 
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param str The message from the UI.    
   */
  
  public void handleMessageFromClientUI(ArrayList<String> str)  
  {
    try
    {
    	
    	if (str.get(0).equals("newClient")) {
    		str.add(this.getHost());
    	}
    	openConnection();//in order to send more than one message
       	awaitResponse = true;
    	sendToServer(str);
		// wait for response
		while (awaitResponse) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
    catch(IOException e)
    {
    	e.printStackTrace();
      clientUI.display("Could not send message to server: Terminating client."+ e);
      quit();
    }
  }

  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      for(int i=0; i<EchoServer.clients.size(); i++) {
       	 if(this.getHost().equals(EchoServer.clients.get(i).getHost() )) {
       		 EchoServer.clients.get(i).setStatus("Disconnected");
       	 }
      }
      closeConnection();
      
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class
