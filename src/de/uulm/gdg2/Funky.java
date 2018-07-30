package de.uulm.gdg2;

import de.uulm.gdg2.controllers.Player;
import de.uulm.gdg2.shapes.CustomLine;
import de.uulm.gdg2.shapes.Poop;
import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class Funky extends PApplet {

    private Player player;

    @Override
    public void settings() {
        size(1240, 720);
    }

    @Override
    public void setup() {

        this.background(255);
        this.noStroke();
        this.smooth();

        player = new Player(this, "./resources/song.mp3");

        player.startPlaying();
    }

    @Override
    public void draw(){

        RGBaColor poopColor = new RGBaColor(0, 0, 0, 100);
        Poop poop = new Poop(this, 50, poopColor);

    }

    public static void main(String[] args) {

        PApplet.main(new String[]{Funky.class.getName()});
    }
}
