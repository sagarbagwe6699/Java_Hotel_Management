package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ManageController {
	public void showNR() throws IOException {
		AnchorPane nr=FXMLLoader.load(getClass().getResource("NewRoom.fxml"));
		MainScreenController mc=new MainScreenController();
		Scene s=new Scene(nr,900,600);
		mc.ManageRooms.setScene(s);
		mc.ManageRooms.show();
	}
	public void showUR() throws IOException {
		AnchorPane ur=FXMLLoader.load(getClass().getResource("UpdateRoom.fxml"));
		MainScreenController mc=new MainScreenController();
		Scene s=new Scene(ur,900,600);
		mc.ManageRooms.setScene(s);
		mc.ManageRooms.show();
	}
	public void showDR() throws IOException {
		AnchorPane dr=FXMLLoader.load(getClass().getResource("Delete.fxml"));
		MainScreenController mc=new MainScreenController();
		Scene s=new Scene(dr,900,600);
		mc.ManageRooms.setScene(s);
		mc.ManageRooms.show();
	}
}
