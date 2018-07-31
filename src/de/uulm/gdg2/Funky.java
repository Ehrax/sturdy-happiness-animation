package de.uulm.gdg2;

import de.uulm.gdg2.controllers.Player;
import de.uulm.gdg2.shapes.CustomLine;
import de.uulm.gdg2.shapes.OuterShape;
import de.uulm.gdg2.shapes.Poop;
import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class Funky extends PApplet {

    private Player player;

    RGBaColor poopColor = new RGBaColor(0, 0, 0, 255);
    RGBaColor outerSColor = new RGBaColor(0,0,0,255);
    Poop poop = new Poop(this, 20, poopColor);
    OuterShape outerS = new OuterShape(this,-10,400,0,20,outerSColor);

    @Override
    public void settings() {
        size(1240, 720);
    }

    @Override
    public void setup() {
        this.background(255);

        this.noStroke();

        player = new Player(this, "./resources/song.mp3");

    }

    @Override
    public void draw(){
        translate(width/2,height/2);
        poop.update();
        poop.display();

        outerS.update();
        outerS.display();

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
