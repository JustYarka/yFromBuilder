package ru.yarka.formbuilder.form;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindowSimple;
import ru.yarka.formbuilder.exception.NullFormHandlerException;
import java.util.List;
import java.util.function.BiConsumer;

public class SimpleForm extends FormWindowSimple {

    private BiConsumer<Player, FormResponseSimple> handler;

    public SimpleForm(BiConsumer<Player, FormResponseSimple> handler, String title, String content, List<ElementButton> buttons) {
        super(title, content, buttons);
        this.handler = handler;
    }

    public void handle(Player player, FormResponseSimple response) throws NullFormHandlerException {
        if(handler == null) return;

        handler.accept(player, response);
    }
}
