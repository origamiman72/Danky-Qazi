package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.xml.internal.stream.Entity;

import java.util.Random;

/**
 * Created by ahuja on 2/18/2017.
 */
public class pipebt extends entity {
//    Texture texture;

//    long height;
//    long width;
//
//
//    int x;
//
//    long y;
//
//    int v;


    public pipebt(/*int width, int height, int x, int y, int v, int typeID, Texture texture, */SpriteBatch batch) {
        super((int)Math.round(143/1.2), (int)Math.round(512/1.2), 1280, (int)(0-Math.round(Math.random() * 290 + 100)), 5, 0, 0, new Texture("dankpipe.png"), batch);
        /*width = Math.round(143/1.2);
        height = Math.round(512/1.2);
        x=1280;
        y = 0-Math.round(Math.random() * 320 + 110);
        v = 5;
        texture = new Texture("dankpipe.jpg");
        */
    }

    public void update() {
        x -= xvel;
        if(x<=-143){
            x=1280;
            y = (int)(0-Math.round(Math.random() * 290 + 100));
        }
    }

    @Override
    public void render() {

    }
}