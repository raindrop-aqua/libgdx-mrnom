package com.mygdx.mrnom;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mrnom.screens.MainMenu;

/**
 * Mr.Nom game class and entry point.
 */
public class MrNom extends Game {

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Settings.load();
        Assets.load();
        setScreen(new MainMenu(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void pause() {
        Gdx.app.log("game", "pause");
        Settings.save();
    }
}
