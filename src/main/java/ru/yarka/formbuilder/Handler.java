package ru.yarka.formbuilder;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.response.FormResponseModal;
import cn.nukkit.form.response.FormResponseSimple;
import ru.yarka.formbuilder.exception.NullFormHandlerException;
import ru.yarka.formbuilder.form.CustomForm;
import ru.yarka.formbuilder.form.ModalForm;
import ru.yarka.formbuilder.form.SimpleForm;

public class Handler implements Listener {

    @EventHandler
    public void handleFormResponse(PlayerFormRespondedEvent event) throws NullFormHandlerException {
        if(event.getWindow() instanceof SimpleForm) {
            SimpleForm form = (SimpleForm) event.getWindow();
            form.handle(event.getPlayer(), (FormResponseSimple) event.getResponse());
        } else if(event.getWindow() instanceof ModalForm) {
            ModalForm form = (ModalForm) event.getWindow();
            form.handle(event.getPlayer(), (FormResponseModal) event.getResponse());
        } else if(event.getWindow() instanceof CustomForm) {
            CustomForm form = (CustomForm) event.getWindow();
            form.handle(event.getPlayer(), (FormResponseCustom) event.getResponse());
        }
    }
}
