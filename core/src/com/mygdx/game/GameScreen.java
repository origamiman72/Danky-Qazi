package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.event.MouseEvent;

/**
 * Created by peter on 2/18/17.
 */

//test123

public class GameScreen implements Screen {

    //FIELDS
    private MyGdxGame game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private final int LEVEL_WIDTH;
    private final int LEVEL_HEIGHT;

    private int pipeSpace;


    private BitmapFont scorecounter;
    private SpriteBatch batch;
    private String scoretext;

    Settings setting;

    Qazi danky;
    boolean gameEnd = false;
    startScreen start;
    pause Pause;
    musicbg bgm;
    book[] books = new book[Constant.booknumber];
    book booko;
    pipebt[] pipebts = new pipebt[Constant.pipenumber];
    pipetop[] pipetops = new pipetop[Constant.pipenumber];
    bg bg1;
    bg bg2;
    private int minValue;

    private Texture img;
    private Texture img1;
    private Texture pause;
    int xpos;
    int ypos;
    HUD hud;

    //CONSTRUCTOR
    public GameScreen(MyGdxGame game) {

        scoretext= "Score: 0";
        batch = new SpriteBatch();
        scorecounter= new BitmapFont();
        this.game = game;
        //Background
        img1 = new Texture("background2.jpg");
        bgm = new musicbg();
        start= new startScreen();
        bg1 = new bg();
        bg2 = new bg();
        bg2.x= 1280;
        danky= new Qazi(game.batch);
        booko= new book(game.batch);
        Pause = new pause();
        hud = new HUD(game.batch);
        setting = new Settings();


        for (int i = 0; i <= (Constant.pipenumber - 1); i++) {
            pipebts[i] = new pipebt(game.batch);
            entity.entities.add(pipebts[i]);
        }

        for (int j = 0; j <= (Constant.booknumber - 1); j++) {
            books[j] = new book(game.batch);
            entity.entities.add(books[j]);
        }

        for (int i = 0; i <= (Constant.booknumber - 1); i++) {
            books[i].x = (700 * i) + 1280;
        }

        for (int i = 0; i <= (Constant.pipenumber - 1); i++) {
            pipetops[i] = new pipetop(game.batch);
            entity.entities.add(pipetops[i]);
        }

        pipeSpace=((1280+(pipebts[1].width*(Constant.pipenumber+1)))-(pipebts[1].width*Constant.pipenumber))/Constant.pipenumber;

        for (int i = 0; i <= (Constant.pipenumber - 1); i++) {

            //pipebts[i].x = pipebts[i].x + 700;
            pipebts[i].x = ((pipeSpace * (i)) + 1280);
            pipetops[i].y = pipebts[i].y + 700;
            pipetops[i].x = pipebts[i].x;
        }


        LEVEL_WIDTH = MyGdxGame.V_WIDTH;
        LEVEL_HEIGHT = MyGdxGame.V_HEIGHT;
        gameCam = new OrthographicCamera();
        gamePort = new ExtendViewport(LEVEL_WIDTH, LEVEL_HEIGHT, gameCam);

        img = new Texture("gameover.png");
        xpos = 390;
        ypos = 310;

        pause = new Texture("pause.png");
        bgm.play();
    }

    //METHODS
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);

        //Clears Screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.enableBlending();


        //game.batch.setProjectionMatrix(gameCam.combined);
        game.batch.begin();
        game.batch.draw(bg1.texture, bg1.x, bg1.y, bg1.width, bg1.height);
        game.batch.draw(img1, bg2.x, bg2.y, bg2.width, bg2.height);
        game.batch.draw(danky.texture, danky.x, danky.y, danky.width, danky.height);
        for (int i = 0; i <= (Constant.booknumber - 1); i++) {
            game.batch.draw(books[i].texture, books[i].x, books[i].y, books[i].width, books[i].height);
        }
        for (int i = 0; i <= (Constant.pipenumber - 1); i++) {
            game.batch.draw(pipebts[i].texture, pipebts[i].x, pipebts[i].y, pipebts[i].width, pipebts[i].height);
            game.batch.draw(pipetops[i].texture, pipetops[i].x, pipetops[i].y, pipetops[i].width, pipetops[i].height);
        }

        if (Pause.gamePause){
            game.batch.draw(pause, 0, 0);
        }
        if(start.showStart) {
            game.batch.draw(start.texture, start.x, start.y);
        }
        if (gameEnd) {
            game.batch.draw(img, xpos, ypos);
        }
        //game.batch.draw(setting.);
//        batch.begin();
//        scorecounter.draw(batch, scoretext, 200, 200);
//        batch.end();
        //game.batch.draw(img, xpos, ypos, 101, 126);
        if(!start.startGame) {
                game.batch.draw(setting.icon, setting.x, setting.y, setting.width, setting.height);
        }

        //Settings
        if(setting.showSettings){
            start.showStart=false;
            game.batch.draw(setting.menu, setting.menux, setting.menuy, setting.menuwidth, setting.menuheight);
            if(!setting.bgmuted){
                game.batch.draw(setting.bgmute, setting.menux, setting.menuy, setting.menuwidth, setting.menuheight);
            }else if(setting.bgmuted){
                game.batch.draw(setting.bgunmute, setting.menux, setting.menuy, setting.menuwidth, setting.menuheight);
            }
            if(!setting.sfxmuted){
                game.batch.draw(setting.sfxmute, setting.menux, setting.menuy, setting.menuwidth, setting.menuheight);
            }else if(setting.sfxmuted){
                game.batch.draw(setting.sfxunmute, setting.menux, setting.menuy, setting.menuwidth, setting.menuheight);
            }
        }else if(!setting.showSettings){
            start.showStart=true;
        }

        game.batch.end();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        if(start.startGame){
            hud.stage.draw();
        }

    }

    @Override
    public void resize(int width, int height) {
        // HD GRAFIXXXXXXXXXXXXXXXXXXXXXXXXXX
        gamePort.update(width,height, true);
        hud.stage.getViewport().update(width, height, true);
    }
    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void hide() {

    }
    @Override
    public void dispose() {

    }

    public void update(float delta) {

        if (start.startGame){
            danky.gameStart=true;
            if(setting.showSettings){
                setting.showSettings=false;
            }
        }else if(!start.startGame){
            danky.gameStart=false;
        }

        //if (entity.isCollide==true){
        //   gameEnd=true;


        if(setting.bgmuted) {
            bgm.bgmusic.pause();
        }else if(!setting.bgmuted){
            bgm.bgmusic.resume();
        }


        scoretext="Score: "+danky.score;
        hud.scorenumber=danky.score;
        hud.updateScore("Score: "+danky.score);
        minValue=pipebts[0].x;
        for (int i = 1; i < pipebts.length; i++) {
            if (pipebts[i].x < minValue) {
                minValue = pipebts[i].x;
            }
        }
        if(!start.startGame&&Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            danky.y=400;
            danky.yvel=16;
            for(int i=0; i<pipebts.length; i++) {
                pipebts[i].x = ((pipeSpace * (i)) + 1280);
                pipetops[i].y = pipebts[i].y + 700;
                pipetops[i].x = pipebts[i].x;
            }
        }

//        if(setting.showSettings) {
//            if (!setting.bgmuted) {
//                bgm.soundEnabled = true;
//            } else if (setting.bgmuted) {
//                bgm.soundEnabled = false;
//            }
//        }
        start.update();

        if(!start.startGame) {
            setting.update();

            //Requires make back to original code
//            for (int i = 0; i <= (Constant.booknumber - 1); i++) {
//                if (pipebts[i].x < pipebts[i].x) {
//                    if (danky.y < (pipebts[0].y + pipebts[0].height + 2)) {
//                        danky.yvel = 16;
//                    }
//                }
//            }

            for (int i = 0; i < pipebts.length; i++) {
                if(pipebts[i].x==minValue){
                    if (danky.y<(pipebts[i].y+pipebts[i].height+2)){
                        danky.yvel=16;
                    }
                }
            }
        }
        if(!gameEnd) {
            if (!Pause.gamePause) {
                if (start.startGame) {
                    for (entity e : entity.entities) {
                        if (danky.isCollide(e)) {

                            danky.handleCollision(e);
                            e.handleCollision(danky);

                            if (!danky.qaziAlive) {
                                gameEnd = true;
                            }


                        }
                    }
                }
            }
        }

        if (!gameEnd) {
            if (start.startGame) {
                //Score counter
                Pause.update();


            }
            if (!Pause.gamePause) {

                danky.update();
                for (int i = 0; i <= (Constant.pipenumber - 1); i++) {
                    pipebts[i].update();
                    pipetops[i].update();
                    pipetops[i].y = pipebts[i].y + 700;
                }
                if(start.startGame) {
                    for (int i = 0; i < pipebts.length; i++) {
                        if ((danky.x) == (pipebts[i].x)) {
                            danky.score++;
                            //System.out.println(score);
                        }
                    }
                }
                //System.out.println(danky.score);
                //Number of books is always half of total here.
                for (int i = 0; i <= ((Constant.booknumber - 1)); i++) {
                    books[i].update();
                    int j = 0;
                }

                //Moves books from spaces in between pipes.
                /*while (books[i].y > (pipebts[j].y+427) && books[i].y+100 < pipetops[j].y && j<=1) {
                    books[i].update();
                    if(j<1){
                        j++;
                    }
                }
                */

                bg1.update();
                bg2.update();
            }
        }


        if (danky.y <= 0) {
            gameEnd = true;
            danky.y = 0;
        }

        if (gameEnd) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                danky.score=0;
                gameEnd = false;
                danky.qaziAlive=true;
                start.startGame=false;
                start.y=0;
//                danky.y = 300;
//                danky.yvel = 0;
            }

        }

//        if(Gdx.input.isKeyPressed(Input.Keys.W)){
//            ypos+=5;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.S)){
//            ypos-=5;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.A)){
//            xpos-=5;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.D)){
//            xpos+=5;
//        }
//        System.out.println(delta);
    }
}