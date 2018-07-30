package de.uulm.gdg2;

import de.uulm.gdg2.controllers.Player;

import processing.core.PApplet;

public class Funky extends PApplet {

    private Player player;

    @Override
    public void settings() {
        size(1240, 720);
    }

    @Override
    public void setup() {
        player = new Player(this, "./resources/song.mp3");

        player.startPlaying();
    }

    @Override
    public void draw(){
        background(100);
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{Funky.class.getName()});
        System.out.println("hallo");
    }
}
