package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CheckOutController {
	@FXML
    private JFXTextField rn;

    @FXML
    private JFXButton CObutton;

    @FXML
    private Label totalprice;

    @FXML
    private Label ndays;

    @FXML
    private Label cost;
    
    @FXML
    private Label taxes1;

    @FXML
    private Label CO;
    
    @FXML
    private Label INV;
    roomData db=new roomData();
    int price;
    int tprice;
    double taxes;
    int days;
	public void CheckOut() throws ClassNotFoundException, SQLException {
		//System.out.println(rn.getText());
		int roomNumber= Integer.parseInt(rn.getText());
		System.out.println("Availability="+db.isAva(Integer.toString(roomNumber)));
		
		if(!db.isAva(Integer.toString(roomNumber))&&!db.isExisit(Integer.toString(roomNumber))) {
			days=db.getDays(Integer.toString(roomNumber));
			System.out.println("days="+days);
			ndays.setText(Integer.toString(days));
			db.setAva(true, Integer.toString(roomNumber));
			ResultSet res=db.getPrice(Integer.toString(roomNumber));
			while(res.next()) {
				price=res.getInt("price");
			}
			tprice=price*days;
			taxes=((double)tprice)*12/100;
			cost.setText(Integer.toString(price));
			totalprice.setText(String.valueOf(taxes+tprice));
			taxes1.setText(String.valueOf(taxes));
			CO.setText("Checkout Successful");
			INV.setText("");
			db.con.close();
		}
		else {
			INV.setText("Invalid room number");
			CO.setText("");
		}
	}
}
