package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by ahuja on 2/18/2017.
 */
public class Qazi extends entity{

    public boolean qaziAlive=true;
    Sound triboonal = Gdx.audio.newSound(Gdx.files.internal("triboonal.mp3"));
    Sound gameover = Gdx.audio.newSound(Gdx.files.internal("gameover.mp3"));
    boolean gameStart = false;

    public Qazi(SpriteBatch batch){
        super(
                (int)Math.round(122/1.5),
                (int)Math.round(249/2.5),
                50,
                400,
                0,
                0,
                type.QAZI,
                new Texture("pixelqazi.png"),
                batch
        );
    }

    public void update(){

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (gameStart){
                if(y<=700) {
                    yvel = 16;
                    triboonal.play(1.0f);
                }
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
    public void handleCollision(entity e){
        type q=e.typeID;
        System.out.println(q);
        boolean a = q==type.PEPE;
        if(a){
            System.out.println(a);
            qaziAlive=false;
        }
    }

    @Override
    public void render() {batch.draw(texture, x, y, width, height);}
}
