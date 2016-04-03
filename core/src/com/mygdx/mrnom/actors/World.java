package com.mygdx.mrnom.actors;

import java.util.Random;

/**
 * World
 */
public class World {

    /** Worldの幅 */
    static final int WORLD_WIDTH = 10;
    /** Worldの高さ */
    static final int WORLD_HEIGHT = 13;
    /** Stainを食べた時のスコアの加算値 */
    static final int SCORE_INCREMENT = 10;
    /** 時間間隔 初期値 */
    static final float TICK_INITIAL = 0.5f;
    /** 時間間隔 減算値 */
    static final float TICK_DECREMENT = 0.05f;

    public Snake snake;
    public Stain stain;
    public boolean isGameOver = false;
    public int score = 0;

    boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    Random random = new Random(System.currentTimeMillis());
    float tickTime = 0;
    static float tick = TICK_INITIAL;

    public World() {
        snake = new Snake();
        placeStain();
    }

    private void placeStain() {
    }

    public void update(float deltaTime) {
        if (isGameOver) {
            return;
        }

        tickTime += deltaTime;

        while (tickTime > tick) {
            tickTime -= tick;
            snake.advance();;
            if (snake.checkBitten()) {
                isGameOver = true;
                return;
            }




        }


    }
}
