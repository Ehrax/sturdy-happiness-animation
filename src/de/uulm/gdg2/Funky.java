package de.uulm.gdg2;

import de.uulm.gdg2.controllers.Player;
import de.uulm.gdg2.shapes.Poop;
import de.uulm.gdg2.util.RGBaColor;


import processing.core.PApplet;

public class Funky extends PApplet {

    private Player player;

    public Poop poop;

    public RGBaColor poopPrimaryColor;
    public RGBaColor poopSecondaryColor;

    public RGBaColor backgroundColor;

    @Override
    public void settings() {
        size(1240, 720);
        noStroke();
        smooth(8);
    }

    @Override
    public void setup() {
        backgroundColor = new RGBaColor(255, 255, 255, 255);

        background(backgroundColor.v1, backgroundColor.v2, backgroundColor.v3, backgroundColor.a);

        player = new Player(this, "./resources/song.mp3");
        player.startPlaying();

        poopPrimaryColor = new RGBaColor(0, 0, 0, 255);
        poopSecondaryColor = new RGBaColor(255, 255, 255, 255);
        poop = new Poop(this,  poopPrimaryColor, poopSecondaryColor);
    }

    @Override
    public void draw(){

        // Color reset
        background(backgroundColor.v1, backgroundColor.v2, backgroundColor.v3, backgroundColor.a);

        /*
         * TODO: this goes later to GUI
         */
        poop.draw();
        poop.update(player.getSong().position());

        float innerRadius = 200;
        float autoRadius = 600;

        stroke(0);
        strokeWeight(100);
        strokeCap(1);

        float mx = width / 2;
        float my = height / 2;

        for (float i = 0; i < TWO_PI; i+= TWO_PI/10) {
            line(cos(i) * innerRadius + mx, sin(i) * innerRadius + my, cos(i) * autoRadius + mx, sin(i) * autoRadius + my);
        }
    }


    public void keyPressed(){
        if ((player.getSong().isPlaying())){
            player.pausePlaying();
        }
        else if (player.getSong().position() == player.getSong().length()){
            player.getSong().rewind();
            player.getSong().play();
        }
        else{
            player.getSong().play();
        }
    }

    public static void main(String[] args) {

        PApplet.main(new String[]{Funky.class.getName()});
    }
}
