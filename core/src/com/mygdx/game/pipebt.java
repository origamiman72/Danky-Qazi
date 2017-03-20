package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by ahuja on 2/18/2017.
 */
public class pipebt extends entity {

    public pipebt(SpriteBatch batch) {
        super(
                (int)Math.round(143/1.2),
                (int)Math.round(512/1.2),
                1280,
                (int)(0-Math.round(Math.random() * 290 + 100)),
                5,
                0,
                type.PEPE,
                new Texture("dankpipe.png"),
                batch
        );
    }

    public void update() {
        x -= xvel;
        if(x<=-143){
            x=1280;
            y = (int)(0-Math.round(Math.random() * 290 + 100));
        }
    }

    @Override
    public void handleCollision(entity e){}
    @Override
    public void render() {batch.draw(texture, x, y, width, height);}
}