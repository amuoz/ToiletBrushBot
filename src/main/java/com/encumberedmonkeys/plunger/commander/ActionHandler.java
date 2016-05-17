package com.encumberedmonkeys.plunger.commander;

import com.encumberedmonkeys.plunger.commander.actions.Action;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActionHandler {

    private static final ActionHandler ACTION_HANDLER = new ActionHandler();

    public static ActionHandler getInstance() {
        return ACTION_HANDLER;
    }

    private ActionHandler() {
    }

    public void handle(Action action) {
        action.execute();
    }
}
