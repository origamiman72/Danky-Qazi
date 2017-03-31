package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.badlogic.gdx.utils.viewport.ExtendViewport;
//import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.File;

/**
 * Created by peter on 3/25/17.
 */
public class HUD {

    Stage stage;
    Viewport viewport;

    Label score;
    int scorenumber=0;

    public HUD(SpriteBatch batch){

        BitmapFont pixelFont = new BitmapFont(
                Gdx.files.internal("font"+ File.separator+"pixelOperatorHB.fnt"),
                false
        );

        viewport = new ScreenViewport(new OrthographicCamera());
        stage = new Stage(viewport, batch);

        //Display Table (score)
        Table displayTable = new Table();
        displayTable.top();
        displayTable.setFillParent(true);

        //Labels take in: STRING, LabelStyle(Font,Color)
        score = new Label("Score: "+scorenumber, new Label.LabelStyle(pixelFont, Color.WHITE));

        score.setFontScale(2F);

        displayTable.add(score);

        stage.addActor(displayTable);

    }

    public void updateScore (String s){
        score.setText(s);
    }

}