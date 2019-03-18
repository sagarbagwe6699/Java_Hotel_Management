package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	AnchorPane root=new AnchorPane();
	static Stage primaryStage=new Stage();
	@Override
	public void start(Stage primaryStage) {
		try {
			root=FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root,900,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			this.primaryStage=primaryStage;
			this.primaryStage.setTitle("PS");
			this.primaryStage.setResizable(false);
			this.primaryStage.show();
		} catch(Exception e) {
			System.out.println(e);
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
