package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/**
 * Created by ahuja on 2/18/2017.
 */
public class book extends entity{
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


    public book(/*int width, int height, int x, int y, int v, int typeID, Texture texture, */SpriteBatch batch) {
        super((int)Math.round(1000/10), (int)Math.round(829/10), 1280, (int)Math.round(Math.random() * 400 + 100), 10, 0, type.BOOK, new Texture("chembook.png"), batch);
        /*width = Math.round(1000/10);
        height = Math.round(829/10);
        x=1280;
        y = Math.round(Math.random() * 400 + 100);
        v = 10;
        texture = new Texture("chembook.jpg");
        */
    }

    public void update() {
        x -= xvel;
        if(x<=-143){
            x=1280;
            y = (int)(Math.round(Math.random() * 600 + 100));
        }
    }
    @Override
    public void handleCollision(entity e){
    }

    @Override
    public void render() {

    }
}