package application;


import javax.swing.JComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.stage.Stage;

public class MainPageReportsController {
	ObservableList<String> year = FXCollections.observableArrayList("2020", "2021", "2022");
	ObservableList<String> month = FXCollections.observableArrayList("January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October", "November", "December");
	
	ObservableList<String> machineLocation = FXCollections.observableArrayList("Karmiel", "Haifa", "TelAviv");

	ObservableList<String> type = FXCollections.observableArrayList("stock report", "orders report", "histogram report");

	@FXML
	private Button showReport;
	@FXML
	private Button back;
	@FXML
	private ComboBox<String> yearBox;
	@FXML
	private ComboBox<String> monthBox;
	@FXML
	private ComboBox<String> machineLocationBox;
	@FXML
	private ComboBox<String> typeBox;
	@FXML
	private Label wrongInfo;

	@FXML
	private void initialize() {
		yearBox.setItems(year);
		monthBox.setItems(month);
		machineLocationBox.setItems(machineLocation);
		typeBox.setItems(type);
		
	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/MainPageReports.fxml"));

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setTitle("Searching for Ekrut Subscriber Tool");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void showReportBtn(ActionEvent event) throws Exception {
		//Main m=new Main();
		
		if(isInputValid()) {
			
			switch(typeBox.getValue()) {
			case("stock report"):
				Main m=new Main();

				wrongInfo.setText("");/* Success so we dont want to show anything for the user.*/
				m.changeScene("StockReports.fxml");
			    System.out.println("viewOrdersMonthlyReportBtn");
				break;
			case("orders report"):
				Main m1=new Main();

				wrongInfo.setText("");/* Success so we dont want to show anything for the user.*/
				m1.changeScene("OrdersReports.fxml");
			    System.out.println("viewOrdersMonthlyReportBtn");
			    System.exit(0);
				break;
			case("histogram report"):
				Main m2=new Main();

				wrongInfo.setText("");/* Success so we dont want to show anything for the user.*/
				m2.changeScene("HistogramReports.fxml");
			    System.out.println("viewOrdersMonthlyReportBtn");
			    System.exit(0);
				break;
			
			}
		}
		else
			return;
	}

	
	/**
	 * Checking if the user selected all the comboBox so the controller will display the reports on the tableView.
	 * @return true or false, based on the user input.
	 */
	private boolean isInputValid() {
		if (yearBox.getValue() == null || monthBox.getValue() == null
				|| machineLocationBox.getValue() == null || typeBox.getValue() == null){
			wrongInfo.setText("Please fill all fields.");
			wrongInfo.setVisible(true);
			return false;
		} else {
			wrongInfo.setVisible(false);
			return true;
		}
	}
	
	public void backBtn(ActionEvent event) throws Exception {
		/* The page before Show reports.*/
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		EkrutStockReportsController reportsFrame = new EkrutStockReportsController();
		reportsFrame.start(primaryStage);
	}
}
