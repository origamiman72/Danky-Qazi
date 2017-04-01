package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by ahuja on 3/12/2017.
 */
public class startScreen {
    boolean startGame;
    int y;
    int x;
    int yvel;
    Texture texture;
    boolean showStart=true;

    public startScreen(){
        startGame= false;
        showStart=true;
        x=0;
        y=0;
        texture= new Texture("start screen.png");
        yvel=0;
    }
    public void update(){
        if (startGame!=true) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                startGame=true;
                showStart=true;
            }
        }
        if (startGame==true){
            yvel++;
            y-=yvel;
        }
    }
}
