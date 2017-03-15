package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

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

    private Texture img;
    private Texture img1;
    private Texture pause;
    int xpos;
    int ypos;

    //CONSTRUCTOR
    public GameScreen(MyGdxGame game) {

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

        for (int i = 0; i <= (Constant.pipenumber - 1); i++) {
            pipebts[i] = new pipebt(game.batch);
        }

        for (int j = 0; j <= (Constant.booknumber - 1); j++) {
            books[j] = new book(game.batch);
        }

        for (int i = 0; i <= (Constant.booknumber - 1); i++) {
            books[i].x = (700 * i) + 1280;
        }

        for (int i = 0; i <= (Constant.pipenumber - 1); i++) {
            pipetops[i] = new pipetop(game.batch);
        }

        for (int i = 0; i <= (Constant.pipenumber - 1); i++) {

            //pipebts[i].x = pipebts[i].x + 700;
            pipebts[i].x = ((700 * (i)) + 1280);
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
        game.batch.draw(start.texture, start.x, start.y);
        if (gameEnd) {
            game.batch.draw(img, xpos, ypos);
        }
        //game.batch.draw(img, xpos, ypos, 101, 126);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

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

        //if (entity.isCollide==true){
        //   gameEnd=true;

        for (entity e : entity.entities) {
            if (danky.isCollide(e)){
                gameEnd=true;
            }
        }

        start.update();
        if(!start.startGame) {



            //Requires make back to original code
//            for (int i = 0; i <= (Constant.booknumber - 1); i++) {
//                if (pipebts[i].x < pipebts[i].x) {
//                    if (danky.y < (pipebts[0].y + pipebts[0].height + 2)) {
//                        danky.yvel = 16;
//                    }
//                }
//            }

            if(pipebts[0].x<pipebts[1].x){
                if (danky.y<(pipebts[0].y+pipebts[0].height+2)){
                    danky.yvel=16;
                }
            } else if(pipebts[1].x<pipebts[0].x){
                if (danky.y<(pipebts[1].y+pipebts[1].height+10)){
                    danky.yvel=16;
                }
            }
        }

        if (!gameEnd) {
            if (start.startGame) {
                Pause.update();
            }
            if (!Pause.gamePause) {
                danky.update();
                for (int i = 0; i <= (Constant.pipenumber - 1); i++) {
                    pipebts[i].update();
                    pipetops[i].update();
                    pipetops[i].y = pipebts[i].y + 700;
                }

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
                gameEnd = false;
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