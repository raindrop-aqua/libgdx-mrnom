package com.mygdx.mrnom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {

    public static TextureAtlas.AtlasRegion background;
    public static TextureAtlas.AtlasRegion logo;

    public static TextureAtlas.AtlasRegion label_gameover;
    public static TextureAtlas.AtlasRegion label_help;
    public static TextureAtlas.AtlasRegion label_highscore;
    public static TextureAtlas.AtlasRegion label_play;
    public static TextureAtlas.AtlasRegion label_quit;
    public static TextureAtlas.AtlasRegion label_ready;
    public static TextureAtlas.AtlasRegion label_resume;

    public static TextureAtlas.AtlasRegion button_cancel;
    public static TextureAtlas.AtlasRegion button_left;
    public static TextureAtlas.AtlasRegion button_pause;
    public static TextureAtlas.AtlasRegion button_right;
    public static TextureAtlas.AtlasRegion button_sound;
    public static TextureAtlas.AtlasRegion button_sound_off;

    public static TextureAtlas.AtlasRegion help1;
    public static TextureAtlas.AtlasRegion help2;
    public static TextureAtlas.AtlasRegion help3;

    public static TextureAtlas.AtlasRegion number_0;
    public static TextureAtlas.AtlasRegion number_1;
    public static TextureAtlas.AtlasRegion number_2;
    public static TextureAtlas.AtlasRegion number_3;
    public static TextureAtlas.AtlasRegion number_4;
    public static TextureAtlas.AtlasRegion number_5;
    public static TextureAtlas.AtlasRegion number_6;
    public static TextureAtlas.AtlasRegion number_7;
    public static TextureAtlas.AtlasRegion number_8;
    public static TextureAtlas.AtlasRegion number_9;
    public static TextureAtlas.AtlasRegion number_p;

    public static TextureAtlas.AtlasRegion nom_body;
    public static TextureAtlas.AtlasRegion nom_down;
    public static TextureAtlas.AtlasRegion nom_left;
    public static TextureAtlas.AtlasRegion nom_right;
    public static TextureAtlas.AtlasRegion nom_up;

    public static TextureAtlas.AtlasRegion stain1;
    public static TextureAtlas.AtlasRegion stain2;
    public static TextureAtlas.AtlasRegion stain3;

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

        number_0 = atlas.findRegion("number_0");
        number_1 = atlas.findRegion("number_1");
        number_2 = atlas.findRegion("number_2");
        number_3 = atlas.findRegion("number_3");
        number_4 = atlas.findRegion("number_4");
        number_5 = atlas.findRegion("number_5");
        number_6 = atlas.findRegion("number_6");
        number_7 = atlas.findRegion("number_7");
        number_8 = atlas.findRegion("number_8");
        number_p = atlas.findRegion("number_p");

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
