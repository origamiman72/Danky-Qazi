package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.io.File;

/**
 * Created by ahuja on 3/31/2017.
 */
public class Settings{

    Texture icon = new Texture("settingsicon.png");
    int height = 90;
    int width = 90;
    int x = 1160;

    int y = 600;
    boolean showSettings=false;
    int menuwidth=300;
    int menux = ((1280-menuwidth)/2);
    int menuheight=350;
    int menuy = ((720-menuheight)/2);

    int buttonx=menux+183;
    int buttonxlim=buttonx+90;
    int bgmutey= menuy+165;
    int bgmuteylim=menuy+196;
    int sfxmutey= menuy+220;
    int sfxmuteylim=menuy+251;

    int pgselecty= menuy+110;
    int pgselectylim = menuy+135;
    int pgbackx = menux+210;
    int pgbackxlim = menux+230;
    int pgfwdx = menux+241;
    int pgfwdxlim = menux+261;

    int diffx = menux+44;
    int diffxlim = menux+159;
    int easyy = menuy+164;
    int easyylim = menuy+184;
    int mediumy = menuy+207;
    int mediumylim = menuy+227;
    int hardy = menuy+252;
    int hardylim = menuy+272;

    int pagenumber=1;
    int numberofpages = 2;

    int difficulty = 2;

    static boolean bgmuted=false;
    static boolean sfxmuted=false;

    Texture bgmute = new Texture("Settings"+ File.separator+"BGmute.png");
    Texture bgunmute = new Texture("Settings"+ File.separator+"BGunmute.png");
    Texture sfxmute = new Texture("Settings"+ File.separator+"SFXmute.png");
    Texture sfxunmute = new Texture("Settings"+ File.separator+"SFXunmute.png");
    Texture menu = new Texture("Settings"+ File.separator+"bg.png");
    Texture menu2 = new Texture("Settings"+ File.separator+"bg2.png");

    Texture easy = new Texture("Settings"+ File.separator+"easy.png");
    Texture medium = new Texture("Settings"+ File.separator+"medium.png");
    Texture hard = new Texture("Settings"+ File.separator+"hard.png");

    public void update(){

        //Toggles Settings
        if(Gdx.input.justTouched()) {
            //System.out.println("DANKY SETTINGS TEST");
            if ((Gdx.input.getX() > x) && (Gdx.input.getX() < (x + width))){
                if((Gdx.input.getY()<y)&&(Gdx.input.getY()<(y+height))){
                    System.out.println("DANKY SETTINGS TOGGLED");
                    if(!showSettings){
                        showSettings=true;
                    }else if(showSettings){
                        showSettings=false;
                    }
                }
            }
            if(showSettings){

                if ((Gdx.input.getY() > pgselecty) && (Gdx.input.getY() < (pgselectylim))) {

                    //Page Forward
                    if ((Gdx.input.getX() > pgfwdx) && (Gdx.input.getX() < (pgfwdxlim))) {
                        System.out.println("Page Forward");
                        if (pagenumber<numberofpages) {
                            pagenumber++;
                        }
                    }

                    //Page Back
                    if ((Gdx.input.getX() > pgbackx) && (Gdx.input.getX() < (pgbackxlim))) {
                        System.out.println("Page Back");
                        if (pagenumber>1) {
                            pagenumber--;
                        }
                    }
                }
                if(pagenumber==1) {
                    //Toggle background music
                    if ((Gdx.input.getX() > buttonx) && (Gdx.input.getX() < (buttonxlim))) {
                        if ((Gdx.input.getY() > bgmutey) && (Gdx.input.getY() < (bgmuteylim))) {
                            System.out.println("BG music toggled");
                            if (!bgmuted) {
                                bgmuted = true;
//                            musicbg.soundEnabled=false;
//                            System.out.println(musicbg.soundEnabled);
                            } else if (bgmuted) {
                                bgmuted = false;
//                            musicbg.soundEnabled=true;
//                            System.out.println(musicbg.soundEnabled);
                            }
                        }

                        //Toggle sfx
                        if ((Gdx.input.getY() > sfxmutey) && (Gdx.input.getY() < (sfxmuteylim))) {
                            System.out.println("SFX music toggled");
                            if (!sfxmuted) {
                                sfxmuted = true;
//                            musicbg.soundEnabled=false;
//                            System.out.println(musicbg.soundEnabled);
                            } else if (sfxmuted) {
                                sfxmuted = false;
//                            musicbg.soundEnabled=true;
//                            System.out.println(musicbg.soundEnabled);
                            }
                        }
                    }
                }
                if(pagenumber==2){
                    if ((Gdx.input.getX() > diffx) && (Gdx.input.getX() < (diffxlim))) {
                        System.out.println("XXXXXXXX");
                        //Set game to easy
                        if ((Gdx.input.getY() > easyy) && (Gdx.input.getY() < (easyylim))) {
                            System.out.println("Game set to easy");
                            difficulty=1;
                            Constant.pipenumber=2;
                        }

                        //Set game to medium
                        if ((Gdx.input.getY() > mediumy) && (Gdx.input.getY() < (mediumylim))) {
                            System.out.println("Game set to medium");
                            difficulty=2;
                            Constant.pipenumber=3;
                        }

                        //Set game to hard
                        if ((Gdx.input.getY() > hardy) && (Gdx.input.getY() < (hardylim))) {
                            System.out.println("Game set to hard");
                            difficulty=3;
                            Constant.pipenumber=4;
                        }
                    }
                }
            }
        }
    }
}