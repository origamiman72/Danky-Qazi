package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by ahuja on 3/12/2017.
 */
public class musicbg {

    Sound bgmusic;
    //public static boolean soundEnabled=true;

    public musicbg(){
        bgmusic = Gdx.audio.newSound(Gdx.files.internal("bgmusic.mp3"));
    }
    public void play(){
            bgmusic.loop(0.5f);
    }
}
