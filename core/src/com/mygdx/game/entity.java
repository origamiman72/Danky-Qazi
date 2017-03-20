package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by peter on 2/19/17.
 */
public abstract class entity {

    //FIELDS
    public Texture texture;    //Texture

    public SpriteBatch batch;  //Draw Textures

    public int width;
    public int height;

    public int x;
    public int y;
    public int xvel;
    public int yvel;

    public final type typeID;

    //STATIC FIELDS
    public static ArrayList<entity> entities = new ArrayList<entity>();

    //CONSTRUCTOR
    public entity(int width, int height, int x, int y, int xvel, int yvel, type typeID, Texture texture, SpriteBatch batch){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.xvel = xvel;
        this.yvel = yvel;
        this.typeID = typeID;
        this.batch = batch;
        this.texture = texture;
    }

    //METHODS
    public boolean isCollide(entity e){
        if(x < e.x + e.width &&
                x + width > e.x &&
                y < e.y + e.height &&
                height + y > e.y)
        {
            return true;
        } else{
            return false;
        }
    }
    public abstract void handleCollision(entity e);

    //ABSTRACT METHODS
    //Varies depending on the subclass*
    public abstract void render();

}