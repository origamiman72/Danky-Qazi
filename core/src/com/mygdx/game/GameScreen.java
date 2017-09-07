//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.Iterator;

public class GameScreen implements Screen {
    private MyGdxGame game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private final int LEVEL_WIDTH;
    private final int LEVEL_HEIGHT;
    private int pipeSpace;
    private BitmapFont scorecounter;
    private SpriteBatch batch;
    private String scoretext;
    private int highscore;
    Settings setting;
    Qazi danky;
    boolean gameEnd = false;
    startScreen start;
    pause Pause;
    musicbg bgm;
    book[] books;
    book booko;
    pipebt[] pipebts;
    pipetop[] pipetops;
    bg bg1;
    bg bg2;
    private int minValue;
    private Texture img;
    private Texture img1;
    private Texture pause;
    int xpos;
    int ypos;
    HUD hud;

    public GameScreen(MyGdxGame game) {
        this.books = new book[Constant.booknumber];
        this.pipebts = new pipebt[Constant.pipenumber];
        this.pipetops = new pipetop[Constant.pipenumber];
        this.scoretext = "Score: 0";
        this.batch = new SpriteBatch();
        this.scorecounter = new BitmapFont();
        this.game = game;
        this.img1 = new Texture("background2.jpg");
        this.bgm = new musicbg();
        this.start = new startScreen();
        this.bg1 = new bg();
        this.bg2 = new bg();
        this.bg2.x = 1280L;
        this.danky = new Qazi(game.batch);
        this.booko = new book(game.batch);
        this.Pause = new pause();
        this.hud = new HUD(game.batch);
        this.setting = new Settings();
        highscore=0;

        int i;
        for(i = 0; i <= Constant.pipenumber - 1; ++i) {
            this.pipebts[i] = new pipebt(game.batch);
            entity.entities.add(this.pipebts[i]);
        }

        for(i = 0; i <= Constant.booknumber - 1; ++i) {
            this.books[i] = new book(game.batch);
            entity.entities.add(this.books[i]);
        }

        for(i = 0; i <= Constant.booknumber - 1; ++i) {
            this.books[i].x = 700 * i + 1280;
        }

        for(i = 0; i <= Constant.pipenumber - 1; ++i) {
            this.pipetops[i] = new pipetop(game.batch);
            entity.entities.add(this.pipetops[i]);
        }

        if (this.setting.difficulty == 1) {
            Constant.pipenumber = 2;
        } else if (this.setting.difficulty == 2) {
            Constant.pipenumber = 3;
        } else if (this.setting.difficulty == 3) {
            Constant.pipenumber = 4;
        }

        this.pipeSpace = (1280 + this.pipebts[1].width * (Constant.pipenumber + 1) - this.pipebts[1].width * Constant.pipenumber) / Constant.pipenumber;

        for(i = 0; i <= Constant.pipenumber - 1; ++i) {
            this.pipebts[i].x = this.pipeSpace * i + 1280;
            this.pipetops[i].y = this.pipebts[i].y + 700;
            this.pipetops[i].x = this.pipebts[i].x;
        }

        this.LEVEL_WIDTH = 1500;
        this.LEVEL_HEIGHT = 1500;
        this.gameCam = new OrthographicCamera();
        this.gamePort = new ExtendViewport((float)this.LEVEL_WIDTH, (float)this.LEVEL_HEIGHT, this.gameCam);
        this.img = new Texture("gameover.png");
        this.xpos = 390;
        this.ypos = 310;
        this.pause = new Texture("pause.png");
        this.bgm.play();
    }

    public void show() {
    }

    public void render(float delta) {
        this.update(delta);
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.game.batch.enableBlending();
        this.game.batch.begin();
        this.game.batch.draw(this.bg1.texture, (float)this.bg1.x, (float)this.bg1.y, (float)this.bg1.width, (float)this.bg1.height);
        this.game.batch.draw(this.img1, (float)this.bg2.x, (float)this.bg2.y, (float)this.bg2.width, (float)this.bg2.height);
        this.game.batch.draw(this.danky.texture, (float)this.danky.x, (float)this.danky.y, (float)this.danky.width, (float)this.danky.height);

        int i;
        for(i = 0; i <= Constant.booknumber - 1; ++i) {
            this.game.batch.draw(this.books[i].texture, (float)this.books[i].x, (float)this.books[i].y, (float)this.books[i].width, (float)this.books[i].height);
        }

        for(i = 0; i <= Constant.pipenumber - 1; ++i) {
            this.game.batch.draw(this.pipebts[i].texture, (float)this.pipebts[i].x, (float)this.pipebts[i].y, (float)this.pipebts[i].width, (float)this.pipebts[i].height);
            this.game.batch.draw(this.pipetops[i].texture, (float)this.pipetops[i].x, (float)this.pipetops[i].y, (float)this.pipetops[i].width, (float)this.pipetops[i].height);
        }

        if (this.Pause.gamePause) {
            this.game.batch.draw(this.pause, 0.0F, 0.0F);
        }

        if (this.start.showStart) {
            this.game.batch.draw(this.start.texture, (float)this.start.x, (float)this.start.y);
        }

        if (this.gameEnd) {
            this.game.batch.draw(this.img, (float)this.xpos, (float)this.ypos);
        }

        if (!this.start.startGame) {
            this.game.batch.draw(this.setting.icon, (float)this.setting.x, (float)this.setting.y, (float)this.setting.width, (float)this.setting.height);
        }

        if (this.setting.showSettings) {
            this.start.showStart = false;
            if (this.setting.pagenumber == 1) {
                this.game.batch.draw(this.setting.menu, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                Settings var10000 = this.setting;
                if (!Settings.bgmuted) {
                    this.game.batch.draw(this.setting.bgmute, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                } else {
                    var10000 = this.setting;
                    if (Settings.bgmuted) {
                        this.game.batch.draw(this.setting.bgunmute, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                    }
                }

                var10000 = this.setting;
                if (!Settings.sfxmuted) {
                    this.game.batch.draw(this.setting.sfxmute, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                } else {
                    var10000 = this.setting;
                    if (Settings.sfxmuted) {
                        this.game.batch.draw(this.setting.sfxunmute, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                    }
                }
            } else if (this.setting.pagenumber == 2) {
                if (!this.setting.eeggenabled) {
                    this.game.batch.draw(this.setting.menu2, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                } else {
                    this.game.batch.draw(this.setting.menu2e, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                }
            } else if (this.setting.pagenumber == 3) {
                this.game.batch.draw(this.setting.eegg, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
            }

            if (this.setting.pagenumber == 2) {
                if (this.setting.difficulty == 1) {
                    this.game.batch.draw(this.setting.easy, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                } else if (this.setting.difficulty == 2) {
                    this.game.batch.draw(this.setting.medium, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                } else if (this.setting.difficulty == 3) {
                    this.game.batch.draw(this.setting.hard, (float)this.setting.menux, (float)this.setting.menuy, (float)this.setting.menuwidth, (float)this.setting.menuheight);
                }
            }
        } else if (!this.setting.showSettings) {
            this.start.showStart = true;
        }

        this.game.batch.end();
        this.game.batch.setProjectionMatrix(this.hud.stage.getCamera().combined);
        if (this.start.startGame) {
            this.hud.stage.draw();
        }

    }

    public void resize(int width, int height) {
        this.gamePort.update(width, height, true);
        this.hud.stage.getViewport().update(width, height, true);
    }

    public void pause() {
    }

    public void resume() {
    }

    public void hide() {
    }

    public void dispose() {
    }

    public void update(float delta) {
        if (this.start.startGame) {
            this.danky.gameStart = true;
            if (this.setting.showSettings) {
                this.setting.showSettings = false;
            }
        } else if (!this.start.startGame) {
            this.danky.gameStart = false;
        }

        if(danky.score>highscore){
            highscore=danky.score;
        }

        this.bgm.update();
        this.scoretext = "Score: " + this.danky.score;
        this.hud.scorenumber = this.danky.score;
        this.hud.updateScore("Score: " + this.danky.score+"   High Score: "+highscore);
        this.minValue = this.pipebts[0].x;

        int i;
        for(i = 1; i < this.pipebts.length; ++i) {
            if (this.pipebts[i].x < this.minValue) {
                this.minValue = this.pipebts[i].x;
            }
        }

        if (!this.start.startGame && Gdx.input.isKeyJustPressed(66)) {
            this.danky.y = 320;
            this.danky.yvel = -16;

            for(i = 0; i < this.pipebts.length; ++i) {
                this.pipebts[i].x = this.pipeSpace * i + 1280;
                this.pipetops[i].y = this.pipebts[i].y + 700;
                this.pipetops[i].x = this.pipebts[i].x;
            }
        }

        this.start.update();
        if (!this.start.startGame) {
            this.setting.update();
            this.pipeSpace = (1280 + this.pipebts[1].width * (Constant.pipenumber + 1) - this.pipebts[1].width * Constant.pipenumber) / Constant.pipenumber;
            if (Gdx.input.justTouched() && this.setting.pagenumber == 2 && Gdx.input.getX() > this.setting.diffx && Gdx.input.getX() < this.setting.diffxlim) {
                for(i = 0; i <= Constant.pipenumber - 1; ++i) {
                    this.pipebts[i].x = this.pipeSpace * i + 500;
                    this.pipetops[i].y = this.pipebts[i].y + 700;
                    this.pipetops[i].x = this.pipebts[i].x;
                }
            }

            for(i = 0; i < this.pipebts.length; i++) {
                if (this.pipebts[i].x == this.minValue && (this.danky.y +this.danky.height)> this.pipetops[i].y - 2) {
                    System.out.println(this.pipetops[i].height);
                    this.danky.yvel = -16;
                }
            }
        }

        if (!this.gameEnd && !this.Pause.gamePause && this.start.startGame) {
            Iterator var5 = entity.entities.iterator();

            while(var5.hasNext()) {
                entity e = (entity)var5.next();
                if (this.danky.isCollide(e)) {
                    this.danky.handleCollision(e);
                    e.handleCollision(this.danky);
                    if (!this.danky.qaziAlive) {
                        this.gameEnd = true;
                    }
                }
            }
        }

        if (!this.gameEnd) {
            if (this.start.startGame) {
                this.Pause.update();
            }

            if (!this.Pause.gamePause) {
                this.danky.update();

                for(i = 0; i <= Constant.pipenumber - 1; ++i) {
                    this.pipebts[i].update();
                    this.pipetops[i].update();
                    this.pipetops[i].y = this.pipebts[i].y + 700;
                }

                if (this.start.startGame) {
                    for(i = 0; i < this.pipebts.length; ++i) {
                        if (this.danky.x == this.pipebts[i].x) {
                            ++this.danky.score;
                        }
                    }
                }

                for(i = 0; i <= Constant.booknumber - 1; ++i) {
                    this.books[i].update();
                    boolean var4 = false;
                }

                this.bg1.update();
                this.bg2.update();
            }
        }

        if (this.danky.y>=(720-this.danky.height)) {
            this.gameEnd = true;
            this.danky.y = (720-this.danky.height);
        }

        if (this.gameEnd && Gdx.input.isKeyJustPressed(66)) {
            this.setting.pagenumber = 1;
            this.danky.score = 0;
            this.gameEnd = false;
            this.danky.qaziAlive = true;
            this.start.startGame = false;
            this.start.y = 0;
        }

    }
}
