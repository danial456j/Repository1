package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EkrutStockReportsController {
	@FXML
	private Button backbutton;
	@FXML
	private Button viewOrdersMonthlyReport;
	@FXML
	private Button ViewCustomersWithDifferentLevelsOfActivity;

	
	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/application/EkrutReportsMainPageForm.fxml"));
				
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/EkrutReportsMainPageForm.css").toExternalForm());
		primaryStage.setTitle("Searching for Ekrut Subscriber Tool");
		primaryStage.setScene(scene);
		primaryStage.show();	 	   
	}
	
	public void backBtn(ActionEvent event) throws Exception {
		/* The page before Show reports.*/
		
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		MainPageReportsController reportsFrame = new MainPageReportsController();
		reportsFrame.start(primaryStage);
		
		//Main m = new Main();
		//m.changeScene("MainPageReports.fxml");
	}
	/*
	public void viewStockMonthlyReportBtn(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
		MainPageReportsController stockReportsController = new MainPageReportsController();
		stockReportsController.start(primaryStage);
	}
	
	public void viewOrdersMonthlyReportBtn(ActionEvent event) throws Exception {
		System.out.println("viewOrdersMonthlyReportBtn");
		System.exit(0);
	}
	*/
}
