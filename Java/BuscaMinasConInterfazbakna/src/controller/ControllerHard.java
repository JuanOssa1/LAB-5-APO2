package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Buscaminas;

public class ControllerHard implements Initializable{
	private Buscaminas buscaminas;
	@FXML
	private GridPane gridD;
	public ControllerHard() {
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
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
	public void clickCargaD() {
		buscaminas = new Buscaminas(3);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 30; j++) { 
				Button btn = new Button();
				
				final int ix = i;
				final int jx = j;
				
				btn.setOnAction(e ->{
					buscaminas.abrirCasilla(ix, jx);
					System.out.println(ix+","+jx);
					btn.setText(buscaminas.darCasillas()[ix][jx].mostrarValorCasilla());
				});
				
				btn.setMaxWidth(Long.MAX_VALUE);
				btn.setMaxHeight(Long.MAX_VALUE);
				gridD.add(btn, j, i);
			}
		}	
	}
	public void resolMineSweperD() {
		buscaminas.resolver();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 30; j++) { 
				Button btn = new Button();
				btn.setText(buscaminas.darCasillas()[i][j].mostrarValorCasilla());
				btn.setMaxWidth(Long.MAX_VALUE);
				btn.setMaxHeight(Long.MAX_VALUE);
				gridD.add(btn, j, i);
			}
		}	
	}

}
