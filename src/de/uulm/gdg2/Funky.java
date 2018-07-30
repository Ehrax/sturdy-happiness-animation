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
        smooth(8);
    }

    @Override
    public void setup() {
        backgroundColor = new RGBaColor(255, 255, 255, 255);

        background(backgroundColor.v1, backgroundColor.v2, backgroundColor.v3, backgroundColor.a);

        noStroke();
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
    }

    public static void main(String[] args) {

        PApplet.main(new String[]{Funky.class.getName()});
    }
}
