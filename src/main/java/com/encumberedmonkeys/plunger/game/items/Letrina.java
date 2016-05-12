package com.encumberedmonkeys.plunger.game.items;

public class Letrina extends Item {

	public Letrina() {
		this.nombre = gameResources.getString("letrina.name");
		this.examinar = gameResources.getString("letrina.examine");
		this.usarActivo = gameResources.getString("letrina.activeUse");
		this.usarInactivo = gameResources.getString("letrina.inactiveUse");

		this.activo = true;
		this.coger = false;
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
