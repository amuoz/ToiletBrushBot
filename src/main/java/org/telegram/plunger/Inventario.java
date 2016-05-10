package org.telegram.plunger;

import java.util.List;

import org.telegram.plunger.objetos.Objeto;

/**
 * Inventario del jugador. Está formado por una lista de Objetos con los que se
 * puede interactuar.
 * 
 * @author MUOZ
 *
 */
public class Inventario {

	private List<Objeto> objetos;

	public List<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}

}
