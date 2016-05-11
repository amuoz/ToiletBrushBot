package com.encumberedmonkeys.plunger.game.items;

public class Papel extends Item {

	public Papel() {
		this.nombre = "papel";
		this.examinar = "Un rollo de papel sagrado, como el que usa ZEUS para cagar.";
		this.usarActivo = "¡OOhhh si, culito limpito!\n\n¡LO LOGRASTE! HAS FINALIZADO LA VERSIÓN DE PRUEBA DE LA SUPER ESCOBILLA.\n\nGracias por jugar.";
		this.usarInactivo = "¿Por qué? Mi culete ya está limpio.";
		this.activo = false;
		this.coger = true;
		this.loTengo = false;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pickup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void talk() {
		// TODO Auto-generated method stub

	}

}
