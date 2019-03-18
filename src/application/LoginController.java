package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.Event;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements EventHandler{
	@FXML
	private TextField usrtxt;
	@FXML
	private TextField passtxt;
	@FXML
	private Label error;
	
	@FXML
	public void Login() {
		if(usrtxt.getText().equals("")||passtxt.getText().equals("")) {
			error.setText("User or password cannot be empty");
		}
		database db=new database();
		try {
			if(db.verify(usrtxt.getText(), passtxt.getText())) {
				//System.out.println(db.verify("admin", "admin"));
				error.setText("");
				Main.primaryStage.hide();
				Main.primaryStage.setResizable(false);
				AnchorPane mainScreen=new AnchorPane();
				mainScreen=FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
				Scene s=new Scene(mainScreen,900,600);
				Main.primaryStage.setScene(s);
				Main.primaryStage.setTitle("MS");
				Main.primaryStage.show();
				db.con.close();
			}
			else {
				error.setText("User or password incorrect");
			}
		}catch(Exception e) {
			System.out.println(e);
			e.getMessage();
		}
	}
	AnchorPane mainScreen=new AnchorPane();
	Scene s;
	Stage FP;
	public void Fpass() {
		Button btn;
		try {
			mainScreen=FXMLLoader.load(getClass().getResource("ForgotPass.fxml"));
			btn=new Button("Back");
			mainScreen.getChildren().add(btn);
			btn.setOnAction(this);
			s=new Scene(mainScreen,640,480);
			FP=new Stage();
			FP.initStyle(StageStyle.UNDECORATED);
			FP.setResizable(false);
			FP.setScene(s);
			FP.setTitle("FP");
			FP.show();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	@Override
	public void handle(Event event) {
		AnchorPane root=new AnchorPane();
		try {
			root=FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root,900,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.primaryStage.setScene(scene);
			//Main.primaryStage=primaryStage;
			Main.primaryStage.setTitle("PS");
			Main.primaryStage.setResizable(false);
			FP.hide();
			Main.primaryStage.show();
		} catch(Exception e) {
			System.out.println(e);
			e.getMessage();
			e.printStackTrace();
		}
	}
}
