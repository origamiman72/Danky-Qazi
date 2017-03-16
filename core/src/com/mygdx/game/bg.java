package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Marla Scrub on 3/5/2017.
 */

public class bg {

    Texture texture;
    int width;
    int height;
    long x;
    long y;
    int xvel;

    public bg() {
        texture = new Texture ("background.jpg");
        width = 1280;
        height = 720;
        x = 0;
        y = 0;
        xvel = 1;
    }

    public void update() {

        //Moves background left across screen
//        posx -= velx;
//
//        if (posx<=CPipe.Lbound) {
//            posx = CPipe.Rbound;
//        }

        x -= Math.round(xvel/1.5);
        if(x<=-1280){
            x=1280;
        }
    }
}