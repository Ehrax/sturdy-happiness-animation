package de.uulm.gdg2;

import de.uulm.gdg2.controllers.Player;
import de.uulm.gdg2.shapes.LineCircle;
import de.uulm.gdg2.shapes.Poop;
import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class Funky extends PApplet {

    public static String SONG_PATH = "./resources/song.mp3";

    public Player player;

    public RGBaColor primaryColor;
    public RGBaColor secondaryColor;

    // our elements
    public Poop poop;
    public LineCircle innerCircle;
    public LineCircle outerCircle;
    public LineCircle threeCircle;

    public RGBaColor backgroundColor;

    @Override
    public void settings() {
        size(1240, 720);
        smooth(8);
    }

    @Override
    public void setup() {
        // setting up colors that we use :)
        primaryColor = new RGBaColor(0, 0, 0, 255);
        secondaryColor = new RGBaColor(255, 255, 255, 255);

        // set up background color of canvas
        backgroundColor = secondaryColor;
        background(backgroundColor.v1, backgroundColor.v2, backgroundColor.v3, backgroundColor.a);

        // setting up player to play our song
        player = new Player(this, SONG_PATH);
        player.startPlaying();

        // Poop related stuff
        String poopAnimationPath = "./resources/times/poop_anim.json";
        String[] poopAnimations = {"scale"};
        poop = new Poop(
                this,
                primaryColor,
                secondaryColor,
                poopAnimationPath,
                width/2,
                height/2,
                40,
                poopAnimations);

        // inner line circle related stuff
        String innerLineCircleAnimationPath = "";
        String[] innerLineCircleAnimations = {};
        innerCircle = new LineCircle(
                this,
                primaryColor,
                secondaryColor,
                innerLineCircleAnimationPath,
                innerLineCircleAnimations,
                30,
                35,
                0,
                TWO_PI,
                1,
            45
        );

        // outer line circle related stuff
        String outerLineCircleAnimationPath = "";
        String[] outerLineCircleAnimations = {};
        outerCircle = new LineCircle(
                this,
                primaryColor,
                secondaryColor,
                outerLineCircleAnimationPath,
                outerLineCircleAnimations,
                400,
                1300,
                0,
                TWO_PI,
                50,
               20
        );
    }

    @Override
    public void draw(){

        // is needed because each frame we redraw our background :)
        background(
                backgroundColor.v1,
                backgroundColor.v2,
                backgroundColor.v3,
                backgroundColor.a
        );

        /*
         * TODO: this goes later to GUI
         */
        poop.draw();
        poop.update(player.getSong().position());

        innerCircle.draw();
        innerCircle.update(player.getSong().position());

        outerCircle.draw();
        outerCircle.update(player.getSong().position());
    }

    public static void main(String[] args) {

        PApplet.main(new String[]{Funky.class.getName()});
    }
}
