// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package Server;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

import jdbc.DBController;
import logic.Client;
import logic.Subscriber;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */

public class EchoServer extends AbstractServer {
	// Class variables *************************************************
	public static ArrayList<Client> clients=new ArrayList<>();
	

	/**
	 * The default port to listen on.
	 */
	// final public static int DEFAULT_PORT = 5555;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 * 
	 */
	// public static Subscriber [] subscribers=new Subscriber[4];
	private DBController myDB;

	public EchoServer(int port) {
		super(port);
		myDB = new DBController();
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 * @param
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		ArrayList<String> msgFromClient = new ArrayList<>();
		msgFromClient = (ArrayList<String>) msg;
		System.out.println("Message received: " + msgFromClient.toString() + " from " + client);
		if (msgFromClient.get(0).equals("Search"))
			myDB.showSubscriberInfo(this, msgFromClient.get(1));
		if (msgFromClient.get(0).equals("Update"))
			myDB.parsingTheData(this, msg);
		if(msgFromClient.get(0).equals("newClient")){
			String[] temp = client.toString().split(" ");
			clients.add(new Client(temp[1],msgFromClient.get(1)));	
			System.out.println(temp[1] + "  " + msgFromClient.get(1));
			try {
				client.sendToClient((Object)"Connected");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				

	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());

	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}
}
//End of EchoServer class
