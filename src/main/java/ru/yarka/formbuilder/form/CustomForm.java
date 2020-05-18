package ru.yarka.formbuilder.form;

import cn.nukkit.Player;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.window.FormWindowCustom;
import java.util.List;
import java.util.function.BiConsumer;

public class CustomForm extends FormWindowCustom {

    private BiConsumer<Player, FormResponseCustom> handler;
    private BiConsumer<Player, FormResponseCustom> exitHandler;

    public CustomForm(BiConsumer<Player, FormResponseCustom> handler, BiConsumer<Player, FormResponseCustom> exitHandler, String title, List<Element> contents) {
        super(title, contents);
        this.handler = handler;
        this.exitHandler = exitHandler;
    }

    public void handle(Player player, FormResponseCustom response) {
        if(response == null) {
            if(exitHandler != null) {
                exitHandler.accept(player, response);
            }
        } else {
            if(handler != null) {
                handler.accept(player, response);
            }
        }
    }
}
