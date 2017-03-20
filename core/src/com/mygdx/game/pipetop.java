package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by ahuja on 2/18/2017.
 */
public class pipetop extends entity {

    public pipetop(SpriteBatch batch) {
        super(
                (int)Math.round(143/1.2),
                (int)Math.round(512/1.2),
                1280,
                0,
                5,
                0,
                type.PEPE,
                new Texture("dankpipetop.png"),
                batch
        );
    }

    public void update() {
        x -= xvel;
        if(x<=-143){
            x=1280;
        }
    }

    @Override
    public void handleCollision(entity e){}
    @Override
    public void render() {batch.draw(texture, x, y, width, height);}
}