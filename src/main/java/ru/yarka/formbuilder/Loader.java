package ru.yarka.formbuilder;

import cn.nukkit.plugin.PluginBase;

public class Loader extends PluginBase {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Handler(), this);
    }
}
