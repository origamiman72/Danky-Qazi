package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.sun.xml.internal.stream.Entity;

/**
 * Created by ahuja on 2/18/2017.
 */
public class Qazi extends entity{

//    Texture texture;
//
//    long height;
//    long width;

    public boolean qaziAlive=true;
    Sound triboonal = Gdx.audio.newSound(Gdx.files.internal("triboonal.mp3"));
    Sound gameover = Gdx.audio.newSound(Gdx.files.internal("gameover.mp3"));
    boolean gameStart = false;
    int score =0;

//    int x;
//
//    int y;
//
//    int v;

    public Qazi(/*int width, int height, int x, int y, int v, int typeID, Texture texture, */SpriteBatch batch){
        super((int)Math.round(122/1.5), (int)Math.round(249/2.5), 50, 400, 0, 16, type.QAZI, new Texture("pixelqaziu.png"), batch);
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
            if (gameStart){
                if(y>=20) {
                    yvel = -16;
                    if(!Settings.sfxmuted) {
                        triboonal.play(1.0f);
                    }
                }
            }
        } else {
            yvel++;
        }
            y += yvel;
        if(y>(720-height)){
            if(!Settings.sfxmuted) {
                gameover.play(1.0f);
            }
        }


    }
    @Override
    public void handleCollision(entity e){
        type q=e.typeID;
        System.out.println(q);
        boolean a = q==type.PEPE;
        if(a){
            System.out.println(a);
            qaziAlive=false;
            if(!Settings.sfxmuted) {
                gameover.play(1.0f);
            }
        }
        if(!a){
            score+=2;
        }
    }

    @Override
    public void render() {

    }
}
