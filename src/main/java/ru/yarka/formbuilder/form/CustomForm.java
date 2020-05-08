package ru.yarka.formbuilder.form;

import cn.nukkit.Player;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.window.FormWindowCustom;
import ru.yarka.formbuilder.exception.NullFormHandlerException;

import java.util.List;
import java.util.function.BiConsumer;

public class CustomForm extends FormWindowCustom {

    private BiConsumer<Player, FormResponseCustom> handler;

    public CustomForm(BiConsumer<Player, FormResponseCustom> handler, String title, List<Element> contents) {
        super(title, contents);
        this.handler = handler;
    }

    public void handle(Player player, FormResponseCustom response) throws NullFormHandlerException {
        if(handler == null) throw new NullFormHandlerException("The form response handler not found");

        handler.accept(player, response);
    }
}
