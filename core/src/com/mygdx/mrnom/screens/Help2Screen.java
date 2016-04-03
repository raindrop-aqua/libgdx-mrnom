package com.mygdx.mrnom.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.mrnom.Assets;
import com.mygdx.mrnom.MrNom;

/**
 * Help screen - page 2
 */
public class Help2Screen extends ScreenAdapter {

    private final Stage stage;

    public Help2Screen(final MrNom game) {
        final OrthographicCamera camera = new OrthographicCamera(320, 480);
        camera.setToOrtho(false, 320, 480);
        stage = new Stage(new FitViewport(320, 480, camera));
        Gdx.input.setInputProcessor(stage);

        final Image background = new Image(Assets.background);
        background.setPosition(0, 0);
        stage.addActor(background);

        final Image help = new Image(Assets.help2);
        help.setPosition(64, 124);
        stage.addActor(help);

        final Image button_right = new Image(Assets.button_right);
        button_right.setPosition(256, 0);
        button_right.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new Help3Screen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(button_right);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        if (stage.getViewport() != null) {
            stage.getViewport().update(width, height);
        }
    }
}
