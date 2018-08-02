package de.uulm.gdg2;

import de.uulm.gdg2.controllers.Player;
import de.uulm.gdg2.shapes.ArcCircle;
import de.uulm.gdg2.shapes.LineCircle;
import de.uulm.gdg2.shapes.Poop;
import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class Funky extends PApplet {

    public static String SONG_PATH = "./resources/song.mp3";

    public Player player;

    // our colors
    public RGBaColor primaryColor;
    public RGBaColor secondaryColor;
    public RGBaColor backgroundColor;

    // our elements
    public Poop poop;
    public LineCircle innerCircle;
    public LineCircle outerCircle;
    public LineCircle threeLineCircle;
    public ArcCircle arcCircle;

    @Override
    public void settings() {
        size(1240, 720);
        fullScreen();
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
        innerCircle = new LineCircle(
                this,
                primaryColor,
                secondaryColor,
                30,
                35,
                0,
                TWO_PI,
                1,
            45
        );

        // outer line circle related stuff
        outerCircle = new LineCircle(
                this,
                primaryColor,
                secondaryColor,
                400,
                1300,
                0,
                TWO_PI,
                20,
              40
        );

        // inner arc circle
        arcCircle = new ArcCircle(
                this,
                primaryColor,
                secondaryColor,
                3,
                25,
                180,
                PI/16
        );

        updateOuterLines();
    }

    public void updateOuterLines() {
        outerCircle.lines.get(0).weight = 40;
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

        arcCircle.draw();
        arcCircle.update(player.getSong().position());
    }

    public static void main(String[] args) {

        PApplet.main(new String[]{Funky.class.getName()});
    }
}
