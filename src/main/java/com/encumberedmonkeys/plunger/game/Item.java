package com.encumberedmonkeys.plunger.game;

import lombok.Data;

@Data
public abstract class Item {
    protected String nombre; // identificador único del objeto
    protected String examinar; // descripción mostrada al examinar el objeto
    protected String usarActivo; // descripción mostrada al usar el objeto
    protected String usarInactivo; // descripción mostrada al usar el objeto
    protected boolean coger; // indica si un objeto se puede coger o no
    protected boolean activo; // indica si un objeto está activo en escena
}
