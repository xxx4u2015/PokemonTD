package com.pixelthieves.pokemontd.graphics.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.pixelthieves.pokemontd.entity.tower.TowerType;
import com.pixelthieves.pokemontd.manager.TowerManager;

/**
 * Created by Seda on 10/8/13.
 */
abstract class TowerIcon extends Icon {

    protected TowerType towerType;
    private TowerManager towerManager;

    TowerIcon(Gui ui, Rectangle rectangle) {
        super(ui, rectangle);
    }

    @Override
    public void render() {
        if (towerType != null && towerManager != null) {
            this.setColor(towerManager.canAfford(towerType) ? Color.WHITE: Color.DARK_GRAY);
            this.render(towerType.getTexture(), "", false);
        }
    }

    public void setTowerManager(TowerManager towerManager) {
        this.towerManager = towerManager;
    }
}