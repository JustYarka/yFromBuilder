package ru.yarka.formbuilder.form;

import cn.nukkit.Player;
import cn.nukkit.form.response.FormResponseModal;
import cn.nukkit.form.window.FormWindowModal;
import java.util.function.BiConsumer;

public class ModalForm extends FormWindowModal {

    private BiConsumer<Player, FormResponseModal> handler;
    private BiConsumer<Player, FormResponseModal> exitHandler;

    public ModalForm(BiConsumer<Player, FormResponseModal> handler, BiConsumer<Player, FormResponseModal> exitHandler, String title, String content, String trueButtonText, String falseButtonText) {
        super(title, content, trueButtonText, falseButtonText);
        this.handler = handler;
        this.exitHandler = exitHandler;
    }

    public void handle(Player player, FormResponseModal response) {
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
