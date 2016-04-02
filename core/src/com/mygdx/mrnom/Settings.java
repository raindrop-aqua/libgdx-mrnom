package com.mygdx.mrnom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Game settings
 */
public class Settings {

    private static final String PREF_NAME = Settings.class.getPackage().getName() + ".xml";

    private static final String KEY_SOUND_ENABLED = "soundEnabled";
    private static final String KEY_HIGH_SCORE = "highScore";

    /** sound enable */
    public static boolean soundEnabled = true;
    /** high scores */
    public static Integer[] highscores = new Integer[]{100, 80, 50, 30, 10};


    public static void load() {
        try {
            Preferences prefs = Gdx.app.getPreferences(PREF_NAME);
            soundEnabled = prefs.getBoolean(KEY_SOUND_ENABLED, soundEnabled);
            for (int i = 0; i < highscores.length; i++) {
                highscores[i] = prefs.getInteger(KEY_HIGH_SCORE + (i + 1), highscores[i]);
            }
        } catch (Throwable e) {
            // Nothing.
        }
    }

    public static void save() {
        Preferences prefs = Gdx.app.getPreferences(PREF_NAME);
        prefs.putBoolean(KEY_SOUND_ENABLED, soundEnabled);
        for (int i = 0; i < highscores.length; i++) {
            prefs.putInteger(KEY_HIGH_SCORE + (i + 1), highscores[i]);
        }
        prefs.flush();
    }

    public static void addScore(int score) {
        List<Integer> list = Arrays.asList(highscores);
        list.add(score);
        Collections.sort(list);
        highscores = list.subList(0, 4).toArray(new Integer[]{});
    }
}
