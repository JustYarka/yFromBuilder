package ru.yarka.formbuilder.form.builder;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.response.FormResponseSimple;
import ru.yarka.formbuilder.form.SimpleForm;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class SimpleFormBuilder {

    private String title = "";
    private String text = "";
    private List<ElementButton> buttons = new ArrayList<>();
    private BiConsumer<Player, FormResponseSimple> handler = null;

    private SimpleFormBuilder() {
    }

    private SimpleFormBuilder(String title) {
        this.title = title;
    }

    public SimpleFormBuilder addText(String text) {
        this.text = text;
        return this;
    }

    public SimpleFormBuilder addButtons(List<ElementButton> buttons) {
        this.buttons = buttons;
        return this;
    }

    public SimpleFormBuilder addButton(ElementButton button) {
        buttons.add(button);
        return this;
    }

    public static SimpleFormBuilder create(String title) {
        return new SimpleFormBuilder(title);
    }

    public SimpleForm build() {
        return new SimpleForm(handler, title, text, buttons);
    }

    public SimpleFormBuilder addHandler(BiConsumer<Player, FormResponseSimple> handler) {
        this.handler = handler;
        return this;
    }
}
