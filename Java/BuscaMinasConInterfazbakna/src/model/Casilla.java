/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package model;

import model.isNotMineException;

public class Casilla {
	
	
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	public static final int MINA = 100;
	public static final int LIBRE = 50;
	// -----------------------------------------------------------------
    // Atributos y relaciones
    // -----------------------------------------------------------------
	private int tipo;
	private boolean seleccionada;
	private int valor;
	 // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
	public Casilla(int tipo) {
		this.tipo = tipo;
		seleccionada = false;
		valor = -1;
	}
	

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------
    
	/**
	 * Metodo modificar del atributo valor
	 * @param valor - nuevo valor
	 */
	public void modificarValor(int valor){
		this.valor = valor;
	}
	
	/**
	 * Retorna true si una casilla es de tipo Mina, false en caso contrario
	 * @return
	 */
	public boolean esMina(){
		if(tipo == 100){
			tipo = MINA;
		}
		else{
			try {
				throw new isNotMineException("Error"); 
			}
			catch(isNotMineException e) {
				//e.printStackTrace();
			}
			
		}
		return tipo == MINA;
	}
	
	/**
	 * Genera un String que representa el valor que se debe mostrar de la casilla
	 * @return El String con la representaci�n actual de la casilla
	 */
	public String mostrarValorCasilla(){
		String valor = "";
		
		if(!seleccionada){
			valor = "-";
		}else if(esMina()) {
			valor = "*";
		}else {
			valor = this.valor+"";
		}
		
		return valor;
	}
	
	/**
	 * Marca la casilla como que ya fue selecciona
	 */
	public void destapar(){
		seleccionada = true;
	}
	
	/**
	 * Metodo dar del atributo seleccionda
	 * @return el atributo
	 */
	public boolean darSeleccionada(){
		return seleccionada;
	}
	
	/**
	 *  Metodo dar del atributo valor
	 * @return el valor
	 */
	public int darValor(){
		return valor;
	}
	
	
}
