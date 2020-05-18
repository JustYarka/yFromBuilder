package ru.yarka.formbuilder.form.builder;

import cn.nukkit.Player;
import cn.nukkit.form.element.*;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.response.FormResponseModal;
import ru.yarka.formbuilder.form.CustomForm;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class CustomFormBuilder {

    private String title = "";
    private BiConsumer<Player, FormResponseCustom> handler = null;
    private BiConsumer<Player, FormResponseCustom> exitHandler = null;
    private List<Element> elements = new ArrayList<>();

    private CustomFormBuilder() {
    }

    private CustomFormBuilder(String title) {
        this.title = title;
    }

    public static CustomFormBuilder create(String title) {
        return new CustomFormBuilder(title);
    }

    public CustomFormBuilder setHandler(BiConsumer<Player, FormResponseCustom> handler) {
        this.handler = handler;
        return this;
    }

    public CustomFormBuilder setCloseHandler(BiConsumer<Player, FormResponseCustom> closeHandler) {
        this.exitHandler = closeHandler;
        return this;
    }

    public CustomForm build() {
        return new CustomForm(handler, exitHandler, title, elements);
    }

    public CustomFormBuilder addSlider(ElementSlider element) {
        elements.add(element);
        return this;
    }

    public CustomFormBuilder addStepSlider(ElementStepSlider element) {
        elements.add(element);
        return this;
    }

    public CustomFormBuilder addInput(ElementInput element) {
        elements.add(element);
        return this;
    }

    public CustomFormBuilder addDropdown(ElementDropdown element) {
        elements.add(element);
        return this;
    }

    public CustomFormBuilder addToggle(ElementToggle element) {
        elements.add(element);
        return this;
    }

    public CustomFormBuilder addLabel(ElementLabel element) {
        elements.add(element);
        return this;
    }
}
