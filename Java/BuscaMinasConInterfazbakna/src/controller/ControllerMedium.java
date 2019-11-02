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

public class ControllerMedium implements Initializable{
	private Buscaminas buscaminas;
	@FXML
	private GridPane gridM;
	public ControllerMedium() {
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
	public void clickCargaM() {
		buscaminas = new Buscaminas(Buscaminas.INTERMEDIO);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) { 
				Button btn = new Button();
				
				final int ix = i;
				final int jx = j;
				
				btn.setOnAction(e ->{
					buscaminas.abrirCasilla(ix, jx);
					btn.setText(buscaminas.darCasillas()[ix][jx].mostrarValorCasilla());
				});
				
				btn.setMaxWidth(Long.MAX_VALUE);
				btn.setMaxHeight(Long.MAX_VALUE);
				gridM.add(btn, i, j);
			}	
		}	
	}
	public void resolMineSweperM() {
		buscaminas.resolver();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) { 
				Button btn = new Button();
				btn.setText(buscaminas.darCasillas()[i][j].mostrarValorCasilla());
				btn.setMaxWidth(Long.MAX_VALUE);
				btn.setMaxHeight(Long.MAX_VALUE);
				gridM.add(btn, j, i);
			}
		}	
	}

}
