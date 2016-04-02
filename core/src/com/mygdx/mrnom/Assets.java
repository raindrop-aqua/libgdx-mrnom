package com.mygdx.mrnom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Assets
 */
public class Assets {

    public static AtlasRegion background;
    public static AtlasRegion logo;

    public static AtlasRegion label_gameover;
    public static AtlasRegion label_help;
    public static AtlasRegion label_highscore;
    public static AtlasRegion label_play;
    public static AtlasRegion label_quit;
    public static AtlasRegion label_ready;
    public static AtlasRegion label_resume;

    public static AtlasRegion button_cancel;
    public static AtlasRegion button_left;
    public static AtlasRegion button_pause;
    public static AtlasRegion button_right;
    public static AtlasRegion button_sound;
    public static AtlasRegion button_sound_off;

    public static AtlasRegion help1;
    public static AtlasRegion help2;
    public static AtlasRegion help3;

    public static AtlasRegion number_0;
    public static AtlasRegion number_1;
    public static AtlasRegion number_2;
    public static AtlasRegion number_3;
    public static AtlasRegion number_4;
    public static AtlasRegion number_5;
    public static AtlasRegion number_6;
    public static AtlasRegion number_7;
    public static AtlasRegion number_8;
    public static AtlasRegion number_9;
    public static AtlasRegion number_p;
    public static List<AtlasRegion> numbers;

    public static AtlasRegion nom_body;
    public static AtlasRegion nom_down;
    public static AtlasRegion nom_left;
    public static AtlasRegion nom_right;
    public static AtlasRegion nom_up;

    public static AtlasRegion stain1;
    public static AtlasRegion stain2;
    public static AtlasRegion stain3;


    public static void load() {
        FileHandle fh = Gdx.files.internal("pack.atlas");
        TextureAtlas atlas = new TextureAtlas(fh);

        background = atlas.findRegion("background");
        logo = atlas.findRegion("logo");

        label_gameover = atlas.findRegion("label_gameover");
        label_help = atlas.findRegion("label_help");
        label_highscore = atlas.findRegion("label_highscore");
        label_play = atlas.findRegion("label_play");
        label_quit = atlas.findRegion("label_quit");
        label_ready = atlas.findRegion("label_ready");
        label_resume = atlas.findRegion("label_resume");

        button_cancel = atlas.findRegion("button_cancel");
        button_left = atlas.findRegion("button_left");
        button_pause = atlas.findRegion("button_pause");
        button_right = atlas.findRegion("button_right");
        button_sound = atlas.findRegion("button_sound");
        button_sound_off = atlas.findRegion("button_sound_off");

        help1 = atlas.findRegion("help1");
        help2 = atlas.findRegion("help2");
        help3 = atlas.findRegion("help3");

        number_0 = atlas.findRegion("number", 0);
        number_1 = atlas.findRegion("number", 1);
        number_2 = atlas.findRegion("number", 2);
        number_3 = atlas.findRegion("number", 3);
        number_4 = atlas.findRegion("number", 4);
        number_5 = atlas.findRegion("number", 5);
        number_6 = atlas.findRegion("number", 6);
        number_7 = atlas.findRegion("number", 7);
        number_8 = atlas.findRegion("number", 8);
        number_9 = atlas.findRegion("number", 9);
        number_p = atlas.findRegion("number_p");
        numbers = new ArrayList<AtlasRegion>(
                Arrays.asList(new AtlasRegion[]{
                        number_0,
                        number_1,
                        number_2,
                        number_3,
                        number_4,
                        number_5,
                        number_6,
                        number_7,
                        number_8,
                        number_9,
                        number_p,
                })
        );

        nom_body = atlas.findRegion("nom_body");
        nom_down = atlas.findRegion("nom_down");
        nom_left = atlas.findRegion("nom_left");
        nom_right = atlas.findRegion("nom_right");
        nom_up = atlas.findRegion("nom_up");

        stain1 = atlas.findRegion("stain1");
        stain2 = atlas.findRegion("stain2");
        stain3 = atlas.findRegion("stain3");
    }
}
