package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CheckInController {
	@FXML
    private JFXTextField fname;

    @FXML
    private JFXTextField lname;

    @FXML
    private JFXTextArea add;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField city;

    @FXML
    private JFXTextField addhar;

    @FXML
    private JFXTextField rn;

    @FXML
    private JFXTextField days;

    @FXML
    private Label bill;

    @FXML
    private JFXButton cal;
    @FXML
	private Label error;
    @FXML
	private Label bs;


	public void save() throws ClassNotFoundException, SQLException {
		roomData db=new roomData();
		/*int price=1;
		ResultSet res=db.getPrice(rn.getText());
		while(res.next()) {
			System.out.println(res.getInt("price"));
			price=res.getInt("price");
		}*/
		if(fname.getText().equals("")||lname.getText().equals("")||
				city.getText().equals("")||add.getText().equals("")||
				addhar.getText().equals("")||phone.getText().equals("")||
				rn.getText().equals("")||days.getText().equals("")) {
			error.setText("Please enter valid data in all fields");
		}
		else {
		db.addfname(Integer.parseInt(rn.getText()), fname.getText());
		db.addlname(Integer.parseInt(rn.getText()), lname.getText());
		db.addcity(Integer.parseInt(rn.getText()), city.getText());
		db.addadd(Integer.parseInt(rn.getText()), add.getText());
		db.addaddhar(Integer.parseInt(rn.getText()), addhar.getText());
		db.addphone(Integer.parseInt(rn.getText()), phone.getText());
		//bill.setText("Rs."+Integer.toString(Integer.parseInt(days.getText())*price));
		db.setAva(false, rn.getText());
		db.setDays(rn.getText(),Integer.parseInt(days.getText()));
		System.out.println("Done");
		error.setText("");
		bs.setText("Booking Sucessful");
		db.con.close();
		}
	}
}
