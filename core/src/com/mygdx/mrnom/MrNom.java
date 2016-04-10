package com.mygdx.mrnom;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.mrnom.screens.MainMenuScreen;

/**
 * Mr.Nom game class and entry point.
 */
public class MrNom extends Game {

    @Override
    public void create() {
        Settings.load();
        Assets.load();
        setScreen(new MainMenuScreen(this));
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
