package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerWindow implements Initializable{
	public ControllerWindow() {
		
	} 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void easy (ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Facil.fxml"));
			Scene scene = new Scene(root); 
			Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	public void medium (ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Intermedio.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void hard (ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Dificil.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
