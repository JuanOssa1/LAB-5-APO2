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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Buscaminas;
import model.UnAvaiableCluesException;

public class ControllerEasy implements Initializable {
	private Buscaminas buscaminas;
	@FXML
	private Label lb1;
	@FXML
	private Label lb2;
	@FXML
	private Label lb3;
	@FXML
	private Label lb4;
	@FXML
	private Label lb5;
	@FXML
	private Label lb6;
	@FXML
	private Label lb7;
	@FXML
	private Button button;
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
					if(buscaminas.darCasillas()[ix][jx].esMina()) {
						resolMineSweper();
						lb2.setText("LOSER");
						lb3.setText("LOSER");
					}
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
	
	public void giveHint() throws UnAvaiableCluesException {
		//buscaminas.dar;
		Button btn = new Button();
		btn.setText(buscaminas.darPista());
		btn.setMaxWidth(Long.MAX_VALUE);
		btn.setMaxHeight(Long.MAX_VALUE);
		grid.add(btn, 1, 1);
	} 
	public void defineWinner() {
		buscaminas.gano();
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
					if(buscaminas.darCasillas()[ix][jx].esMina()) {
						resolMineSweperM();
						lb4.setText("LOSER");
						lb5.setText("LOSER");
					}
					 
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
					if(buscaminas.darCasillas()[ix][jx].esMina()) {
						resolMineSweperD();
						lb6.setText("LOSER");
						lb7.setText("LOSER");
					}
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
