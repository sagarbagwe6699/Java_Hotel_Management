package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.sqlite.core.DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainScreenController implements Initializable{
	static Stage ManageRooms=new Stage();
	
	@FXML
	private Button showAvailable;
	
	@FXML
	private Button checkIn;
	
	@FXML
    private TableView<Room> rtable;

    @FXML
    private TableColumn<Room,Integer> rn;

    @FXML
    private TableColumn<Room, String> rt;

    @FXML
    private TableColumn<Room, String> bt;

    @FXML
    private TableColumn<Room, Integer> p;
    @FXML
    private Circle showAvailable3;
    
    public void showAva() throws ClassNotFoundException, SQLException {
    	roomData rdata=new roomData();
    	rtable.setItems(getRoom(rdata));
    	rdata.con.close();
    	//System.out.println(rdata.addfname(101,"Sagar"));
    }

	ObservableList<Room> getRoom(roomData obj) throws SQLException, ClassNotFoundException{
		ResultSet res=obj.showAvailable();
		ObservableList<Room> room=FXCollections.observableArrayList();
		while(res.next()) {
			room.add(new Room(res.getInt("roomNumber"), res.getString("roomType"), res.getString("bedType"),res.getInt("price") ));
		}
		return room;
}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		roomData rdata=new roomData();
		rn.setCellValueFactory(new PropertyValueFactory<>("rn"));
    	rt.setCellValueFactory(new PropertyValueFactory<>("rt"));
    	bt.setCellValueFactory(new PropertyValueFactory<>("bt"));
    	p.setCellValueFactory(new PropertyValueFactory<>("p"));
	}
	
	public void showCI() {
		try {
			AnchorPane mainScreen=new AnchorPane();
			mainScreen=FXMLLoader.load(getClass().getResource("CheckIn.fxml"));
			Scene s=new Scene(mainScreen,800,600);
			Stage CI=new Stage();
			CI.setResizable(false);
			CI.initStyle(StageStyle.UTILITY);
			CI.setScene(s);
			CI.setTitle("CI");
			CI.show();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void showCO() {
		try {
			AnchorPane mainScreen=new AnchorPane();
			mainScreen=FXMLLoader.load(getClass().getResource("CheckOut.fxml"));
			Scene s=new Scene(mainScreen,380,480);
			Stage CI=new Stage();
			CI.setResizable(false);
			CI.initStyle(StageStyle.UTILITY);
			CI.setScene(s);
			CI.setTitle("CO");
			CI.show();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void showM() {
		try {
			AnchorPane mainScreen=new AnchorPane();
			mainScreen=FXMLLoader.load(getClass().getResource("Manage.fxml"));
			Scene s=new Scene(mainScreen,900,600);
			Stage M=new Stage();
			ManageRooms=M;
			M.setResizable(false);
			M.initStyle(StageStyle.DECORATED);
			M.setScene(s);
			M.setTitle("MR");
			M.show();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	

}

