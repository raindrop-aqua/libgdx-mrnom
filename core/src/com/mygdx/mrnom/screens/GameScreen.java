package com.mygdx.mrnom.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.mrnom.Assets;
import com.mygdx.mrnom.MrNom;
import com.mygdx.mrnom.Settings;
import com.mygdx.mrnom.actors.Snake;
import com.mygdx.mrnom.actors.SnakePart;
import com.mygdx.mrnom.actors.Stain;
import com.mygdx.mrnom.actors.World;

/**
 * GameScreen screen
 */
public class GameScreen extends ScreenAdapter {

    private final Stage stage;
    private Group padUI;
    private Group pauseUI;
    private Group gameOverUI;

    private boolean state = false;

    private final World world = new World();

    public GameScreen(final MrNom game) {
        final OrthographicCamera camera = new OrthographicCamera(320, 480);
        camera.setToOrtho(false, 320, 480);
        stage = new Stage(new FitViewport(320, 480, camera));
        Gdx.input.setInputProcessor(stage);

        final Image background = new Image(Assets.background);
        background.setPosition(0, 0);
        stage.addActor(background);

        setupPauseUI(stage, game);
        setupWorldUI(stage);
        setupPadUI(stage);
        setupReadyUI(stage);
        setupGameOverUI(stage, game);
        padUI.setTouchable(Touchable.disabled);
    }

    private void setupWorldUI(final Stage stage) {
        final Group worldUI = factoryWorldUI(stage);

        Snake snake = world.snake;
        SnakePart snakeHead = snake.parts.get(0);

        for (int i = 1; i < snake.parts.size(); i++) {
            SnakePart snakeBody = snake.parts.get(i);

            Image body = new Image(Assets.nom_body);
            body.setPosition(320 - snakeBody.x * 32 - 32, 480 - snakeBody.y * 32 - 32);
            worldUI.addActor(body);
        }

        final Image stain;
        if (world.stain.type == Stain.TYPE_1) {
            stain = new Image(Assets.stain1);
        } else if (world.stain.type == Stain.TYPE_2) {
            stain = new Image(Assets.stain2);
        } else {
            stain = new Image(Assets.stain3);
        }
        stain.setPosition(320 - world.stain.x * 32 - 32, 480 - world.stain.y * 32 - 32);
        worldUI.addActor(stain);

        final Image head;
        if (snake.direction == Snake.UP) {
            head = new Image(Assets.nom_up);
        } else if (snake.direction == Snake.RIGHT) {
            head = new Image(Assets.nom_right);
        } else if (snake.direction == Snake.LEFT) {
            head = new Image(Assets.nom_left);
        } else {
            head = new Image(Assets.nom_down);
        }
        head.setPosition(320 - snakeHead.x * 32 - 21 - 16, 480 - snakeHead.y * 32 - 21 - 16);
        worldUI.addActor(head);

        drawScore(worldUI, ("" + world.score), 120, 432);
    }

    private Group factoryWorldUI(final Stage stage) {
        for (int i = 0; i < stage.getActors().size; i++) {
            if ("world".equals(stage.getActors().get(i).getName())) {
                Group g = (Group) stage.getActors().get(i);
                g.clearChildren();
                g.setZIndex(1);
                return g;
            }
        }
        Group worldUI = new Group();
        worldUI.setName("world");
        worldUI.setZIndex(1);
        worldUI.setTransform(false);
        stage.addActor(worldUI);
        return worldUI;
    }

    private void drawScore(final Group stage, final String line, int x, int y) {
        Group g = new Group();
        g.setName("score");

        for (char c : line.toCharArray()) {
            Image image;
            int srcWidth = 0;
            if (c == ' ') {
                x += 20;
                continue;
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

    private void setupPadUI(final Stage stage) {
        padUI = new Group();
        padUI.setTransform(false);

        final Image button_left = new Image(Assets.button_left);
        button_left.setPosition(0, 0);
        button_left.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("GameScreen", "touch left");
                world.snake.turnLeft();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        padUI.addActor(button_left);

        final Image button_right = new Image(Assets.button_right);
        button_right.setPosition(256, 0);
        button_right.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("GameScreen", "touch right");
                world.snake.turnRight();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        padUI.addActor(button_right);

        final Image button_pause = new Image(Assets.button_pause);
        button_pause.setPosition(0, 416);
        button_pause.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                state = false;
                padUI.setTouchable(Touchable.disabled);
                pauseUI.setVisible(true);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        padUI.addActor(button_pause);

        stage.addActor(padUI);
    }

    private void setupPauseUI(final Stage stage, final MrNom game) {
        pauseUI = new Group();
        pauseUI.setZIndex(1000);
        pauseUI.setTransform(false);
        pauseUI.setVisible(false);

        final Image resume = new Image(Assets.label_resume);
        resume.setPosition(64, 300);
        resume.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                state = true;
                padUI.setTouchable(Touchable.enabled);
                pauseUI.setVisible(false);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        pauseUI.addActor(resume);

        final Image quit = new Image(Assets.label_quit);
        quit.setPosition(64, 200);
        quit.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainMenuScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        pauseUI.addActor(quit);
        stage.addActor(pauseUI);
    }

    private void setupReadyUI(final Stage stage) {
        final Group group = new Group();
        group.setTransform(false);
        group.setWidth(stage.getWidth());
        group.setHeight(stage.getHeight());
        group.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                padUI.setTouchable(Touchable.enabled);
                group.setVisible(false);
                state = true;
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        final Image ready = new Image(Assets.label_ready);
        ready.setPosition(64, 250);

        group.addActor(ready);
        stage.addActor(group);
    }

    private void setupGameOverUI(final Stage stage, final MrNom game) {
        gameOverUI = new Group();
        gameOverUI.setTransform(false);
        gameOverUI.setWidth(stage.getWidth());
        gameOverUI.setHeight(stage.getHeight());
        gameOverUI.setVisible(false);
        gameOverUI.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Settings.addScore(world.score);
                Settings.save();
                game.setScreen(new MainMenuScreen(game));
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        final Image gameover = new Image(Assets.label_gameover);
        gameover.setPosition(64, 250);
        gameOverUI.addActor(gameover);

        stage.addActor(gameOverUI);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (state) {
            world.update(delta);
        }
        if (world.isGameOver) {
            state = false;
            gameOverUI.setVisible(true);
        }
        setupWorldUI(stage);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
}
