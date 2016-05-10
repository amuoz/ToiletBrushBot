package org.telegram.plunger.objetos;

public class Papel extends Objeto {

	public Papel() {
		this.nombre = "papel";
		this.examinar = "Un rollo de papel sagrado, como el que usa ZEUS para cagar.";
		this.usarActivo = "¡OOhhh si, culito limpito!\n\n¡LO LOGRASTE! HAS FINALIZADO LA VERSIÓN DE PRUEBA DE LA SUPER ESCOBILLA.\n\nGracias por jugar.";
		this.usarInactivo = "¿Por qué? Mi culete ya está limpio.";
		this.activo = false;
		this.coger = true;
		this.loTengo = false;
	}

}
