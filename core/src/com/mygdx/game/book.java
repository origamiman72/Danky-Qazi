package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by ahuja on 2/18/2017.
 */
public class book extends entity{

    public book(SpriteBatch batch) {
        super(
                (int)Math.round(1000/10),
                (int)Math.round(829/10),
                1280,
                (int)Math.round(Math.random() * 400 + 100),
                10,
                0,
                type.BOOK,
                new Texture("chembook.png"),
                batch
        );
    }

    public void update() {
        x -= xvel;
        if(x<=-143){
            x=1280;
            y = (int)(Math.round(Math.random() * 600 + 100));
        }
    }
    @Override
    public void handleCollision(entity e){}
    @Override
    public void render() {batch.draw(texture, x, y, width, height);}
}