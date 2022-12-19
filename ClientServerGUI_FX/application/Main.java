package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Stage stg;
	@Override
	public void start(Stage primaryStage) {
		try {
			stg=primaryStage;
			primaryStage.setResizable(false);
			Parent root=FXMLLoader.load(getClass().getResource("MainPageReports.fxml"));
			Scene scene = new Scene(root,683,393);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException {
		Parent pane=FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        stg.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
