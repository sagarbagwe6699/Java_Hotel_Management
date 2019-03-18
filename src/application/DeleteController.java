package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class DeleteController {
	@FXML
    private JFXTextField rn;

    @FXML
    private JFXTextField rt;

    @FXML
    private JFXTextField bt;

    @FXML
    private JFXTextField p;

    @FXML
    private JFXButton del;

    @FXML
    private ImageView search;

    @FXML
    private Label DELELBL;
    
    @FXML
    private Label INV;

    @FXML
    private ImageView back;
    
    public void search() throws ClassNotFoundException, SQLException {
    	roomData db=new roomData();
    	if(db.isExisit(rn.getText())) {
			INV.setText("Invalid room number");
		}
    	ResultSet res=db.search(rn.getText());
    	while(res.next()) {
    		rt.setText(res.getString("roomType"));
    		bt.setText(res.getString("bedType"));
    		p.setText(res.getString("price"));
    	}
    	db.con.close();
    }
    public void delete() throws ClassNotFoundException, SQLException {
    	roomData db=new roomData();
    	int c=db.delete(rn.getText());
    	if(c==1) {
    		DELELBL.setText("Room Deleted");
    	}
    	db.con.close();
    }
    public void showMC() throws IOException {
		AnchorPane ms=new AnchorPane();
		ms=FXMLLoader.load(getClass().getResource("Manage.fxml"));
		Scene s= new Scene(ms,900,600);
		MainScreenController.ManageRooms.setScene(s);
	}
    
}
