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
    private BiConsumer<Player, FormResponseSimple> exitHandler;

    public SimpleForm(BiConsumer<Player, FormResponseSimple> handler, BiConsumer<Player, FormResponseSimple> exitHandler, String title, String content, List<ElementButton> buttons) {
        super(title, content, buttons);
        this.handler = handler;
        this.exitHandler = exitHandler;
    }

    public void handle(Player player, FormResponseSimple response) throws NullFormHandlerException {
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
