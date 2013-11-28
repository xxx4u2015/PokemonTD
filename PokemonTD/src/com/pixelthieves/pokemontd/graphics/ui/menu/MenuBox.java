package com.pixelthieves.pokemontd.graphics.ui.menu;

import com.badlogic.gdx.math.Rectangle;
import com.pixelthieves.pokemontd.graphics.ui.Button;

/**
 * Created by Seda on 11/19/13.
 */
class MenuBox extends CommonMenu {

    private final Button startGame;
    private final DifficultyTab difficulty;

    MenuBox(final Menu menu, Rectangle rectangle, int count) {
        super(menu, rectangle, false, false,count);
        this.difficulty  = new DifficultyTab(menu, this, rectangle);
        startGame = new MenuButton(menu, rects.get(0)) {
            @Override
            public void process(float x, float y) {
                menu.switchCard(difficulty);
            }
        };
        register(startGame);
        this.setCloseTabWhenNotClicked(false);
    }

    @Override
    public void render() {
        super.render();
        startGame.render("PLAY GAME");
    }
}
