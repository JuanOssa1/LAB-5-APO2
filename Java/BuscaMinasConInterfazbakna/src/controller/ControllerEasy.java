
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import model.Buscaminas;

public class ControllerEasy implements Initializable {
	@FXML
	private Button button;
	private Buscaminas buscaminas;
	@FXML
	private BorderPane border;
	@FXML
	private GridPane grid;
	@FXML
	private GridPane gridM;
	@FXML
	private GridPane gridD;
	public ControllerEasy() {
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
	
	public void clickCarga() {
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) { 
				Button btn = new Button();
				final int ix = i;
				final int jx = j;
				btn.setOnAction(e ->{
					buscaminas.abrirCasilla(ix, jx);
					btn.setText(buscaminas.darCasillas()[ix][jx].mostrarValorCasilla());
				});
				btn.setMaxWidth(Long.MAX_VALUE);
				btn.setMaxHeight(Long.MAX_VALUE);
				grid.add(btn, j, i);
			}
		}	
	}
	public void resolMineSweper() {
		buscaminas.resolver();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) { 
				Button btn = new Button();
				btn.setText(buscaminas.darCasillas()[i][j].mostrarValorCasilla());
				btn.setMaxWidth(Long.MAX_VALUE);
				btn.setMaxHeight(Long.MAX_VALUE);
				grid.add(btn, j, i);
			}
		}	
	}
}
