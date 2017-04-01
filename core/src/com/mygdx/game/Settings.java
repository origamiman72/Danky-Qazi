package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.InputProcessor;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    static boolean bgmuted=false;
    static boolean sfxmuted=false;

    Texture bgmute = new Texture("Settings"+ File.separator+"BGmute.png");
    Texture bgunmute = new Texture("Settings"+ File.separator+"BGunmute.png");
    Texture sfxmute = new Texture("Settings"+ File.separator+"SFXmute.png");
    Texture sfxunmute = new Texture("Settings"+ File.separator+"SFXunmute.png");
    Texture menu = new Texture("Settings"+ File.separator+"bg.png");


    public void update(){
        if(Gdx.input.justTouched()) {
            //System.out.println("DANKY SETTINGS TEST");
            if ((Gdx.input.getX() > x) && (Gdx.input.getX() < (x + width))){
                if((Gdx.input.getY()<y)&&(Gdx.input.getY()<(y+height))){
                    System.out.println("DANKY SETTINGS ACTIVE");
                    if(!showSettings){
                        showSettings=true;
                    }else if(showSettings){
                        showSettings=false;
                    }
                }
            }
            if(showSettings){
                if ((Gdx.input.getX() > buttonx) && (Gdx.input.getX() < (buttonxlim))){
                    if((Gdx.input.getY()>bgmutey)&&(Gdx.input.getY()<(bgmuteylim))){
                        System.out.println("BG music toggled");
                        if(!bgmuted){
                            bgmuted=true;
//                            musicbg.soundEnabled=false;
//                            System.out.println(musicbg.soundEnabled);
                        }else if(bgmuted){
                            bgmuted=false;
//                            musicbg.soundEnabled=true;
//                            System.out.println(musicbg.soundEnabled);
                        }
                    }
                    if((Gdx.input.getY()>sfxmutey)&&(Gdx.input.getY()<(sfxmuteylim))){
                        System.out.println("SFX music toggled");
                        if(!sfxmuted){
                            sfxmuted=true;
//                            musicbg.soundEnabled=false;
//                            System.out.println(musicbg.soundEnabled);
                        }else if(sfxmuted){
                            sfxmuted=false;
//                            musicbg.soundEnabled=true;
//                            System.out.println(musicbg.soundEnabled);
                        }
                    }
                }

            }
        }
    }
}