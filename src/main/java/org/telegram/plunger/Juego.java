package org.telegram.plunger;

import org.telegram.plunger.objetos.Letrina;
import org.telegram.plunger.objetos.Objeto;
import org.telegram.plunger.objetos.Papel;

public class Juego {

	private Inventario inventario;

	public Objeto letrina;
	public Objeto papel;

	public Juego() {
		inventario = new Inventario();

		letrina = new Letrina();
		papel = new Papel();
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	/**
	 * Devuelve el objeto con el nombre pasado como parámetro. Si no existe se
	 * devuelve nulo.
	 * 
	 * @param nombre
	 *            Nombre del objeto.
	 * @return Objeto encontrado o null.
	 */
	public Objeto buscarPorNombre(String nombre) {
		if (nombre.equals("letrina"))
			return letrina;
		else if (nombre.toLowerCase().startsWith("papel"))
			return papel;
		return null;
	}

}
