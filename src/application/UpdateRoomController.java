package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class UpdateRoomController implements Initializable{
	@FXML
    private JFXTextField rn;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXButton update;

    @FXML
    private ImageView back;

    @FXML
    private JFXButton search;

	@FXML
	private JFXComboBox<String> cb;
	
	@FXML
	private JFXComboBox<String> cb1;
	
	@FXML
    private Label US;

    @FXML
    private Label INVRN;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cb.getItems().addAll("A/C","Non-A/C");
		//cb.getSelectionModel().select(0);
		cb1.getItems().addAll("Single","Double");
		//cb1.getSelectionModel().select(0);
	}
	public void showMC() throws IOException {
		AnchorPane ms=new AnchorPane();
		ms=FXMLLoader.load(getClass().getResource("Manage.fxml"));
		Scene s= new Scene(ms,900,600);
		MainScreenController.ManageRooms.setScene(s);
	}
	public void search(ActionEvent e) throws ClassNotFoundException, SQLException {
		roomData db=new roomData();
		if(db.isExisit(rn.getText())) {
			INVRN.setText("Invalid room number");
		}
		ResultSet r=db.search(rn.getText());
		while(r.next()) {
			cb.setValue(r.getString("roomType"));
			cb1.setValue(r.getString("bedType"));
			price.setText(r.getString("price"));
		}
		db.con.close();
	}
	public void update(ActionEvent e) throws ClassNotFoundException, SQLException {
		roomData db=new roomData();
		System.out.println(!db.isAva(rn.getText()));
		if(!db.isAva(rn.getText())) {
			INVRN.setText("Invalid room number");
		}
		int c=db.update(rn.getText(), cb.getValue(), cb1.getValue(), price.getText());
		if(c==1) {
			US.setText("Update sucessful");
		}
		db.con.close();
	}
}
