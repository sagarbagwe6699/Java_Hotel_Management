package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class NewRoomController implements Initializable{
	
	@FXML
    private JFXTextField rn;

    @FXML
    private JFXComboBox<String> cb;

    @FXML
    private JFXComboBox<String> cb1;

    @FXML
    private JFXTextField p;

    @FXML
    private ImageView back;
    
    @FXML
    private Label message;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cb.getItems().addAll("A/C","Non-A/C");
		cb.getSelectionModel().select(0);
		cb1.getItems().addAll("Single","Double");
		cb1.getSelectionModel().select(0);
	}
	public void showMC() throws IOException {
		AnchorPane ms=new AnchorPane();
		ms=FXMLLoader.load(getClass().getResource("Manage.fxml"));
		Scene s= new Scene(ms,900,600);
		MainScreenController.ManageRooms.setScene(s);
	}
	public void add() throws ClassNotFoundException, SQLException {
		roomData db=new roomData();
		if(db.isExisit(rn.getText())) {
			db.addRoom(rn.getText(), cb.getValue(), cb1.getValue(), p.getText());
			message.setText("Room added sucessfully");
		}
		else {
			message.setText("Room could not be added");
		}
		db.con.close();
	}
}
