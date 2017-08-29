//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import java.io.File;

public class Settings {
    Texture icon = new Texture("settingsicon.png");
    int height = 90;
    int width = 90;
    int x = 1160;
    int y = 600;
    boolean showSettings = false;
    int menuwidth = 300;
    int menux;
    int menuheight;
    int menuy;
    int buttonx;
    int buttonxlim;
    int bgmutey;
    int bgmuteylim;
    int sfxmutey;
    int sfxmuteylim;
    int pgselecty;
    int pgselectylim;
    int pgbackx;
    int pgbackxlim;
    int pgfwdx;
    int pgfwdxlim;
    int diffx;
    int diffxlim;
    int easyy;
    int easyylim;
    int mediumy;
    int mediumylim;
    int hardy;
    int hardylim;
    int eeggy;
    int eeggylim;
    int eeggx;
    int eeggxlim;
    int pagenumber;
    int numberofpages;
    int difficulty;
    static boolean bgmuted = false;
    static boolean sfxmuted = false;
    boolean eeggenabled;
    Sound fb;
    Sound santa;
    Sound cry;
    Sound brilliant;
    Sound boo;
    Sound imqazi;
    Sound egg;
    Texture bgmute;
    Texture bgunmute;
    Texture sfxmute;
    Texture sfxunmute;
    Texture menu;
    Texture menu2;
    Texture menu2e;
    Texture eegg;
    Texture easy;
    Texture medium;
    Texture hard;

    public Settings() {
        this.menux = (1280 - this.menuwidth) / 2;
        this.menuheight = 350;
        this.menuy = (720 - this.menuheight) / 2;
        this.buttonx = this.menux + 183;
        this.buttonxlim = this.buttonx + 90;
        this.bgmutey = this.menuy + 165;
        this.bgmuteylim = this.menuy + 196;
        this.sfxmutey = this.menuy + 220;
        this.sfxmuteylim = this.menuy + 251;
        this.pgselecty = this.menuy + 110;
        this.pgselectylim = this.menuy + 135;
        this.pgbackx = this.menux + 210;
        this.pgbackxlim = this.menux + 230;
        this.pgfwdx = this.menux + 241;
        this.pgfwdxlim = this.menux + 261;
        this.diffx = this.menux + 44;
        this.diffxlim = this.menux + 159;
        this.easyy = this.menuy + 164;
        this.easyylim = this.menuy + 184;
        this.mediumy = this.menuy + 207;
        this.mediumylim = this.menuy + 227;
        this.hardy = this.menuy + 252;
        this.hardylim = this.menuy + 272;
        this.eeggy = this.menuy + 138;
        this.eeggylim = this.menuy + 282;
        this.eeggx = this.menux + 17;
        this.eeggxlim = this.menux + 287;
        this.pagenumber = 1;
        this.numberofpages = 2;
        this.difficulty = 2;
        this.eeggenabled = false;
        this.fb = Gdx.audio.newSound(Gdx.files.internal("Settings" + File.separator + "facebook.mp3"));
        this.santa = Gdx.audio.newSound(Gdx.files.internal("Settings" + File.separator + "santa.mp3"));
        this.cry = Gdx.audio.newSound(Gdx.files.internal("Settings" + File.separator + "cry.mp3"));
        this.brilliant = Gdx.audio.newSound(Gdx.files.internal("Settings" + File.separator + "brilliant.mp3"));
        this.boo = Gdx.audio.newSound(Gdx.files.internal("Settings" + File.separator + "boo.mp3"));
        this.imqazi = Gdx.audio.newSound(Gdx.files.internal("Settings" + File.separator + "imqazi.mp3"));
        this.egg = Gdx.audio.newSound(Gdx.files.internal("Settings" + File.separator + "AIRHORN.mp3"));
        this.bgmute = new Texture("Settings" + File.separator + "BGmute.png");
        this.bgunmute = new Texture("Settings" + File.separator + "BGunmute.png");
        this.sfxmute = new Texture("Settings" + File.separator + "SFXmute.png");
        this.sfxunmute = new Texture("Settings" + File.separator + "SFXunmute.png");
        this.menu = new Texture("Settings" + File.separator + "bg.png");
        this.menu2 = new Texture("Settings" + File.separator + "bg2.png");
        this.menu2e = new Texture("Settings" + File.separator + "bg2.1.png");
        this.eegg = new Texture("Settings" + File.separator + "bg3.png");
        this.easy = new Texture("Settings" + File.separator + "easy.png");
        this.medium = new Texture("Settings" + File.separator + "medium.png");
        this.hard = new Texture("Settings" + File.separator + "hard.png");
    }

    public void update() {
        if (Gdx.input.justTouched()) {
            if (Gdx.input.getX() > this.x && Gdx.input.getX() < this.x + this.width && Gdx.input.getY() < this.y && Gdx.input.getY() < this.y + this.height) {
                System.out.println("DANKY SETTINGS TOGGLED");
                if (!this.showSettings) {
                    this.showSettings = true;
                } else if (this.showSettings) {
                    this.showSettings = false;
                }
            }

            if (this.showSettings) {
                if (Gdx.input.getY() > this.pgselecty && Gdx.input.getY() < this.pgselectylim) {
                    if (Gdx.input.getX() > this.pgfwdx && Gdx.input.getX() < this.pgfwdxlim) {
                        System.out.println("Page Forward");
                        if (this.pagenumber < this.numberofpages) {
                            ++this.pagenumber;
                            if (this.eeggenabled && !sfxmuted) {
                                this.egg.play();
                            }
                        } else if (this.eeggenabled && this.pagenumber < 3) {
                            ++this.pagenumber;
                            if (this.eeggenabled && !sfxmuted) {
                                this.egg.play();
                            }
                        }
                    }

                    if (Gdx.input.getX() > this.pgbackx && Gdx.input.getX() < this.pgbackxlim) {
                        System.out.println("Page Back");
                        if (this.pagenumber > 1) {
                            --this.pagenumber;
                            if (this.eeggenabled && !sfxmuted) {
                                this.egg.play();
                            }
                        }
                    }
                }

                if (this.pagenumber == 1 && Gdx.input.getX() > this.buttonx && Gdx.input.getX() < this.buttonxlim) {
                    if (Gdx.input.getY() > this.bgmutey && Gdx.input.getY() < this.bgmuteylim) {
                        System.out.println("BG music toggled");
                        if (!bgmuted) {
                            bgmuted = true;
                        } else if (bgmuted) {
                            bgmuted = false;
                        }
                    }

                    if (Gdx.input.getY() > this.sfxmutey && Gdx.input.getY() < this.sfxmuteylim) {
                        System.out.println("SFX music toggled");
                        if (!sfxmuted) {
                            sfxmuted = true;
                        } else if (sfxmuted) {
                            sfxmuted = false;
                        }
                    }
                }

                if (this.pagenumber == 2 && Gdx.input.getX() > this.diffx && Gdx.input.getX() < this.diffxlim) {
                    System.out.println("XXXXXXXX");
                    if (Gdx.input.getY() > this.easyy && Gdx.input.getY() < this.easyylim) {
                        System.out.println("Game set to easy");
                        this.difficulty = 1;
                        Constant.pipenumber = 2;
                    }

                    if (Gdx.input.getY() > this.mediumy && Gdx.input.getY() < this.mediumylim) {
                        System.out.println("Game set to medium");
                        this.difficulty = 2;
                        Constant.pipenumber = 3;
                    }

                    if (Gdx.input.getY() > this.hardy && Gdx.input.getY() < this.hardylim) {
                        System.out.println("Game set to hard");
                        this.difficulty = 3;
                        Constant.pipenumber = 4;
                    }
                }

                if (this.pagenumber == 3 && Gdx.input.getX() > this.eeggx && Gdx.input.getX() < this.eeggxlim && Gdx.input.getY() > this.eeggy && Gdx.input.getY() < this.eeggylim) {
                    System.out.println("HAIL LORD QAZI");
                    int rand = 1 + (int)(Math.random() * 6.0D);
                    if (rand == 1) {
                        this.imqazi.play(1.1F);
                    } else if (rand == 2) {
                        this.boo.play(1.1F);
                    } else if (rand == 3) {
                        this.santa.play(1.1F);
                    } else if (rand == 4) {
                        this.brilliant.play(1.1F);
                    } else if (rand == 5) {
                        this.fb.play(1.1F);
                    } else if (rand == 6) {
                        this.cry.play(1.1F);
                    }
                }
            }
        }

        if (this.showSettings && Gdx.input.isKeyJustPressed(45)) {
            if (!this.eeggenabled && !sfxmuted) {
                this.egg.play(0.7F);
            }

            this.eeggenabled = true;
            System.out.println(this.eeggenabled);
        }

    }
}
