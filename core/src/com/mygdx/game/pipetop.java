package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/**
 * Created by ahuja on 2/18/2017.
 */
public class pipetop extends entity {
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


    public pipetop(/*int width, int height, int x, int y, int v, int typeID, Texture texture, */SpriteBatch batch) {
        super((int)Math.round(143/1.2), (int)Math.round(512/1.2), 1280, 0, 5, 0, type.PEPE, new Texture("dankpipetop.png"), batch);
        /*width = Math.round(143/1.2);
        height = Math.round(512/1.2);
        x=1280;
        y =0;
        v = 5;
        texture = new Texture("dankpipetop.jpg");
        */
    }

    public void update() {
        x -= xvel;
        if(x<=-143){
            x=1280;
        }
    }

    @Override
    public void handleCollision(entity e){

    }

    @Override
    public void render() {

    }
}