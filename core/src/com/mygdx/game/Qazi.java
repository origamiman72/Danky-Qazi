package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.xml.internal.stream.Entity;

/**
 * Created by ahuja on 2/18/2017.
 */
public class Qazi extends entity{

//    Texture texture;
//    long height;
//    long width;

    Sound triboonal = Gdx.audio.newSound(Gdx.files.internal("triboonal.mp3"));
    Sound gameover = Gdx.audio.newSound(Gdx.files.internal("gameover.mp3"));

//    int x;
//    int y;
//    int v;

    public Qazi(/*int width, int height, int x, int y, int v, int typeID, Texture texture, */SpriteBatch batch){
        super((int)Math.round(122/1.5), (int)Math.round(249/2.5), 50, 400, 0, 0, 0, new Texture("pixelqazi.png"), batch);
        /*width=Math.round(122/1.5);
        height=Math.round(249/2.5);
        x=50;
        y=400;
        v=0;
        texture= new Texture("pixelqazi.jpg");
        */
    }
    public void update(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if(y<=700) {
                yvel = 16;
                triboonal.play(1.0f);
            }
        } else {
            yvel--;
        }
            y += yvel;
        if(y<=0){
            gameover.play(1.0f);
        }
    }

    @Override
    public void render() {
    }
}
