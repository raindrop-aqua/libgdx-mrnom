package com.mygdx.mrnom.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.mrnom.Assets;
import com.mygdx.mrnom.MrNom;
import com.mygdx.mrnom.Settings;

/**
 * Main menu screen
 */
public class MainMenuScreen extends ScreenAdapter {

    private final Stage stage;

    public MainMenuScreen(final MrNom game) {
        final OrthographicCamera camera = new OrthographicCamera(320, 480);
        camera.setToOrtho(false, 320, 480);
        stage = new Stage(new FitViewport(320, 480, camera));
        Gdx.input.setInputProcessor(stage);

        final Image background = new Image(Assets.background);
        background.setPosition(0, 0);
        stage.addActor(background);

        final Image logo = new Image(Assets.logo);
        logo.setPosition(32, 300);
        stage.addActor(logo);

        final Image play = new Image(Assets.label_play);
        play.setPosition(64, 212);
        play.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(play);

        final Image highscore = new Image(Assets.label_highscore);
        highscore.setPosition(64, 164);
        highscore.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new HighScoresScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(highscore);

        final Image help = new Image(Assets.label_help);
        help.setPosition(64, 116);
        help.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new Help1Screen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(help);

        final Image button_sound = new Image(Assets.button_sound);
        buttonSoundDraw(button_sound);
        button_sound.setPosition(0, 0);
        button_sound.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Settings.soundEnabled = !Settings.soundEnabled;
                buttonSoundDraw(button_sound);
                super.touchUp(event, x, y, pointer, button);
            }
        });
        stage.addActor(button_sound);
    }

    private static void buttonSoundDraw(final Image button_sound) {
        if (Settings.soundEnabled) {
            button_sound.setDrawable(new SpriteDrawable(new Sprite(Assets.button_sound)));
        } else {
            button_sound.setDrawable(new SpriteDrawable(new Sprite(Assets.button_sound_off)));
        }
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
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
