package com.pixelthieves.pokemontd.graphics.tutorial.task;

import com.badlogic.gdx.math.Vector2;
import com.pixelthieves.pokemontd.App;
import com.pixelthieves.pokemontd.graphics.tutorial.Notice;
import com.pixelthieves.pokemontd.graphics.tutorial.Tutorial;
import com.pixelthieves.pokemontd.graphics.ui.Ui;
import com.pixelthieves.pokemontd.manager.TowerManager;


/**
 * Created by Tomas on 12/2/13.
 */
public class PlaceShop extends NoticeTask {

    public PlaceShop(Tutorial tutorial) {
        super(tutorial);
    }

    @Override
    protected Notice buildNotice() {
        Ui ui = tutorial.getUi();
        return new Notice(ui, App.getTowerRectangleByBlock(6, 17), Notice.Orientation.TOP_LEFT,
                "Place the shop somewhere on the map", Notice.Placement.RELATIVE);
    }

    @Override
    public boolean checkConditions(App entity) {
        TowerManager towerManager = entity.getTowerManager();
        return towerManager.getSelectedTowerType() != null && entity.getTowerManager().getShop() == null;
    }

}
