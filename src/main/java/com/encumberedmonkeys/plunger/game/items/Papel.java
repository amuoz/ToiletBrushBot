package com.encumberedmonkeys.plunger.game.items;

public class Papel extends Item {

	public Papel() {
		this.nombre = gameResources.getString("papel.name");
		this.examinar = gameResources.getString("papel.examine");
		this.usarActivo = gameResources.getString("papel.activeUse");
		this.usarInactivo = gameResources.getString("papel.inactiveUse");
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
