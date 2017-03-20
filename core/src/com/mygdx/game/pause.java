package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by ahuja on 3/11/2017.
 */
public class pause {

    boolean gamePause;

    public pause(){
        gamePause=false;
    }

    public void update(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.P) && !gamePause) {
            gamePause=true;
        }else if (Gdx.input.isKeyJustPressed(Input.Keys.P) && gamePause) {
            gamePause=false;
        }
    }

}
