package com.mygdx.mrnom.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.mrnom.Assets;
import com.mygdx.mrnom.MrNom;
import com.mygdx.mrnom.actors.World;

/**
 * Game screen
 */
public class Game extends ScreenAdapter {

    private final Stage stage;
    private final World world;

    public Game(final MrNom game) {
        final OrthographicCamera camera = new OrthographicCamera(320, 480);
        camera.setToOrtho(false, 320, 480);
        stage = new Stage(new FitViewport(320, 480, camera));
        Gdx.input.setInputProcessor(stage);
    }

    private void updateRunning(float delta) {
        world.update(delta);

        final Image logo = new Image(Assets.logo);
        logo.setPosition(32, 300);
        logo.setVisible(false);
        stage.addActor(logo);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        updateRunning(delta);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
}
