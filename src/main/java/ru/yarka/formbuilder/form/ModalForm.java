package ru.yarka.formbuilder.form;

import cn.nukkit.Player;
import cn.nukkit.form.response.FormResponseModal;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindowModal;
import ru.yarka.formbuilder.exception.NullFormHandlerException;

import java.util.function.BiConsumer;

public class ModalForm extends FormWindowModal {

    private BiConsumer<Player, FormResponseModal> handler;

    public ModalForm(BiConsumer<Player, FormResponseModal> handler, String title, String content, String trueButtonText, String falseButtonText) {
        super(title, content, trueButtonText, falseButtonText);
        this.handler = handler;
    }

    public void handle(Player player, FormResponseModal response) throws NullFormHandlerException {
        if(handler == null) throw new NullFormHandlerException("The form response handler not found");

        handler.accept(player, response);
    }
}
