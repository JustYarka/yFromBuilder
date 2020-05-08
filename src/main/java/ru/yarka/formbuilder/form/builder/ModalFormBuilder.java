package ru.yarka.formbuilder.form.builder;

import cn.nukkit.Player;
import cn.nukkit.form.response.FormResponseModal;
import ru.yarka.formbuilder.form.ModalForm;
import java.util.function.BiConsumer;

public class ModalFormBuilder {

    private String title = "";
    private String text = "";
    private String trueButton = "";
    private String falseButton = "";
    private BiConsumer<Player, FormResponseModal> handler = null;

    private ModalFormBuilder() {
    }

    private ModalFormBuilder(String title) {
        this.title = title;
    }

    public static ModalFormBuilder create(String title) {
        return new ModalFormBuilder(title);
    }

    public ModalFormBuilder addText(String text) {
        this.text = text;
        return this;
    }

    public ModalFormBuilder addTrueButton(String text) {
        this.trueButton = text;
        return this;
    }

    public ModalFormBuilder addFalseButton(String text) {
        this.falseButton = text;
        return this;
    }

    public ModalFormBuilder addHandler(BiConsumer<Player, FormResponseModal> handler) {
        this.handler = handler;
        return this;
    }

    public ModalForm build() {
        return new ModalForm(handler, title, text, trueButton, falseButton);
    }
}
