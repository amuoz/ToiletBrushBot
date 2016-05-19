package com.encumberedmonkeys.plunger.game.entities;

import com.encumberedmonkeys.plunger.game.Game;
import com.encumberedmonkeys.plunger.services.LocationService;
import com.encumberedmonkeys.plunger.updateshandlers.ToiletBrushHandler;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public abstract class Entity {
    protected Game game;

    public abstract String getName();
    public abstract void examine();
    public abstract void pick();
    public abstract void use();
    public abstract void use(Entity entity);
    public abstract void talk();
    public abstract void talk(Integer dialog);

    // Generic messages
    protected String getPickMsg() {
        return LocationService.getInstance().getString("item.pickMsg");
    }
    protected String getImpossibleMsg() {
        return LocationService.getInstance().getString("item.impossibleMsg");
    }
    protected String getNoPickInventoryMsg() {
        return LocationService.getInstance().getString("item.noPickInventoryMsg");
    }
    protected String getNoMsg() {
        return LocationService.getInstance().getString("item.noMsg");
    }
    // Utils
    protected String getMsg(String msg) {
        return LocationService.getInstance().getString(msg);
    }
    protected void sendMessageToUser(String text) {
        ToiletBrushHandler.getInstance().sendMessageToUser(text);
    }
    protected void sendPhotoToUser(String photoId) {
        ToiletBrushHandler.getInstance().sendPhotoToUser(photoId);
    }
    protected void sendKeyboardMessageToUser(String text, List<KeyboardRow> replies) {
        ToiletBrushHandler.getInstance().sendKeyboardMessageToUser(text, replies);
    }
    protected void sendInlineKeyboardMessageToUser(String text, List<List<InlineKeyboardButton>> replies) {
        ToiletBrushHandler.getInstance().sendInlineKeyboardMessageToUser(text, replies);
    }
    protected void editMessageTextToUser(String text, List<List<InlineKeyboardButton>> replies) {
        ToiletBrushHandler.getInstance().editMessageTextToUser(text, replies);
    }
    protected void editMessageReplyMarkupToUser(List<List<InlineKeyboardButton>> replies) {
        ToiletBrushHandler.getInstance().editMessageReplyMarkupToUser(replies);
    }
}
