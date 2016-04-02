package com.mygdx.mrnom.screen;

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
import com.mygdx.mrnom.Settings;

public class HighScores extends ScreenAdapter {

    private final Stage stage;

    public HighScores(final MrNom game) {
        final OrthographicCamera camera = new OrthographicCamera(320, 480);
        camera.setToOrtho(false, 320, 480);
        stage = new Stage(new FitViewport(320, 480, camera));
        Gdx.input.setInputProcessor(stage);

        final Image background = new Image(Assets.background);
        background.setPosition(0, 0);
        stage.addActor(background);

        final Image highscore = new Image(Assets.label_highscore);
        highscore.setPosition(64, 412);
        stage.addActor(highscore);

        final Image button_left = new Image(Assets.button_left);
        button_left.setPosition(0, 0);
        button_left.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenu(game));
            }
        });
        stage.addActor(button_left);

        int y = 330;
        for (int i = 0; i < Settings.highscores.length; i++) {
            String line = "" + (i + 1) + ". " + Settings.highscores[i];
            drawText(stage, line, 96, y);
            y -= 50;
        }
    }

    private void drawText(Stage stage, String line, int x, int y) {
        for (char c : line.toCharArray()) {
            Image image;
            int srcWidth = 0;
            if (c == ' ') {
                x += 20;
                continue;
            } else if (c == '.') {
                image = new Image(Assets.numbers.get(10));
                srcWidth += image.getWidth();
            } else {
                int index = Integer.parseInt("" + c);
                image = new Image(Assets.numbers.get(index));
                srcWidth += image.getWidth();
            }
            image.setPosition(x, y);
            stage.addActor(image);
            x += srcWidth;
        }
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
