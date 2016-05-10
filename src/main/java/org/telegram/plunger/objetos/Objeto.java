package org.telegram.plunger.objetos;

public abstract class Objeto {

	protected String nombre; // identificador único del objeto
	protected String examinar; // descripción mostrada al examinar el objeto
	protected String usarActivo; // descripción mostrada al usar el objeto
	protected String usarInactivo; // descripción mostrada al usar el objeto
	protected boolean coger; // indica si un objeto se puede coger o no
	protected boolean activo; // indica si un objeto está activo en escena
	protected boolean loTengo; // indica si un objeto está en el inventario

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isCoger() {
		return coger;
	}

	public void setCoger(boolean coger) {
		this.coger = coger;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getExaminar() {
		return examinar;
	}

	public void setExaminar(String examinar) {
		this.examinar = examinar;
	}

	public String usar() {
		if (activo) {
			setActivo(false);
			return usarActivo;
		}
		return usarInactivo;
	}

	public void coger() {
		loTengo = true;
		coger = false;
	}

	public boolean isLoTengo() {
		return loTengo;
	}

	public void setLoTengo(boolean loTengo) {
		this.loTengo = loTengo;
	}

}
