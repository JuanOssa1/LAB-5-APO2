package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		
	}
	
	public void clickCarga() {
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE);
		update();
	}
	
	public void update() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) { 
				Button btn = new Button(buscaminas.darCasillas()[i][j].mostrarValorCasilla());
				final int ix = i;
				final int jx = j;
				btn.setOnAction(e ->{
					buscaminas.abrirCasilla(ix, jx);
					btn.setText(buscaminas.darCasillas()[ix][jx].mostrarValorCasilla()); 
					if(buscaminas.darCasillas()[ix][jx].esMina()) {
						resolMineSweper();
						looser();
					} else if(buscaminas.gano() == true) {
						Alert alert = new Alert(AlertType.INFORMATION, "GANASTE BRO");
						alert.setHeaderText("TENEMOS UN GANADOR!!");
						alert.show();
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
	
	public void giveHint() {
		try {
			buscaminas.darPista();
			update();
		} catch (UnAvaiableCluesException e) {
			Alert alert =new Alert(AlertType.ERROR, "No hay mas pistas para dar"); 
			alert.setHeaderText("ERROR!");
			alert.show();
		} 
	}
	
	
	
	
	
	
	
	
	
	
	
	public void clickCargaM() {
		buscaminas = new Buscaminas(Buscaminas.INTERMEDIO);
		updateM();
		
	}
	public void updateM() {
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
						Alert alert = new Alert(AlertType.INFORMATION, "BUEN INTENTO MAS SUERTE PARA LA PROXIMA");
						alert.setHeaderText("PERDISTE");
						alert.show();
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
	public void giveHintM() {
		try {
			System.out.println(buscaminas.darPista());
			updateM();
		} catch (UnAvaiableCluesException e) {
			Alert alert =new Alert(AlertType.ERROR, "No hay mas pistas para dar"); 
			alert.setHeaderText("ERROR!");
			alert.show();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void clickCargaD() {
		buscaminas = new Buscaminas(3);
		updateD();	
	}
	public void updateD() {
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
						Alert alert = new Alert(AlertType.INFORMATION, "BUEN INTENTO MAS SUERTE PARA LA PROXIMA");
						alert.setHeaderText("PERDISTE");
						alert.show();
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
	public void giveHintD() {
		try {
			System.out.println(buscaminas.darPista());
			updateD();
		} catch (UnAvaiableCluesException e) {
			Alert alert =new Alert(AlertType.ERROR, "No hay mas pistas para dar"); 
			alert.setHeaderText("ERROR!");
			alert.show();
		}
		
	}
	
	
	
	//Codigo general
	public void winner() {
		Alert alert = new Alert(AlertType.INFORMATION, "GANASTE BRO");
		alert.setHeaderText("TENEMOS UN GANADOR!!");
		alert.show();
	}
	public void looser() {
		Alert alert = new Alert(AlertType.INFORMATION, "BUEN INTENTO MAS SUERTE PARA LA PROXIMA");
		alert.setHeaderText("PERDISTE");
		alert.show();
	}
	public void noMoreHints() {
		Alert alert =new Alert(AlertType.ERROR, "No hay mas pistas para dar"); 
		alert.setHeaderText("ERROR!");
		alert.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
