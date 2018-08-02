package de.uulm.gdg2;

import de.uulm.gdg2.controllers.GUI;
import de.uulm.gdg2.controllers.Player;
import de.uulm.gdg2.shapes.ArcCircle;
import de.uulm.gdg2.shapes.LineCircle;
import de.uulm.gdg2.shapes.Poop;
import de.uulm.gdg2.util.RGBaColor;
import de.uulm.gdg2.util.States;

import processing.core.PApplet;

import static de.uulm.gdg2.util.States.AnimationStates.RUNNING;
import static de.uulm.gdg2.util.States.AnimationStates.READY;
import static de.uulm.gdg2.util.States.AnimationStates.PAUSED;

import static de.uulm.gdg2.util.States.DevelopmentStates.DEBUG;
import static de.uulm.gdg2.util.States.DevelopmentStates.DEPLOY;

import static de.uulm.gdg2.util.States.RGBaColors;

public class Funky extends PApplet {

    public static final String SONG_PATH = "./resources/song.mp3";

    public static float ANI_DELAY = 1000;

    public static States.AnimationStates aniState = READY;
    public static States.DevelopmentStates devState = DEBUG;

    public Player player;

    public GUI gui;

    // our colors
    public RGBaColor primaryColor;
    public RGBaColor secondaryColor;
    public RGBaColor backgroundColor;

    // our elements
    public Poop poop;
    public LineCircle innerCircle;
    public LineCircle outerCircle;

    public ArcCircle arcCircle;

    @Override
    public void settings() {
        if (devState == DEBUG) {
            setSize(1240, 720);
        } else {
            fullScreen(1);
        }
        smooth(8);
    }

    @Override
    public void setup() {
        // setting up player to play our song
        player = new Player(this, SONG_PATH);

        // setting up gui
        gui = new GUI(this);

        // initialize all our objects
        initialize();
    }

    /**
     * This method is called when the animation is loaded or when the rest button ist preset.
     */
    public void initialize() {
        player.getSong().rewind();
        player.getSong().pause();

        // setting up colors that we use :) TODO: color change has to be somehow dynamically
        primaryColor = RGBaColors.BLACK;
        secondaryColor = RGBaColors.WHITE;

        // set up background color of canvas
        backgroundColor = secondaryColor;

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
                5000,
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
                2500,
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
                15,
                180,
                PI/16
        );

        aniState = States.AnimationStates.READY;
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

        poop.draw();
        poop.update(player.getSong().position());

        innerCircle.draw();
        innerCircle.update(player.getSong().position());

        outerCircle.draw();
        outerCircle.update(player.getSong().position());

        arcCircle.draw();
        arcCircle.update(player.getSong().position());
    }

    @Override
    public void keyPressed() {
        switch (Character.toLowerCase(key)) {
            case ' ':
            case ENTER:
                // Switch between running and paused state when pressing space
                playPause();
                break;
            case 'h':
                break;
            case 'j':
                break;
            case 'k':
                break;
            case 'l':
                break;
            default:
                break;
        }
        super.keyPressed();
    }

    public void playPause() {
        aniState = aniState == RUNNING ? PAUSED : RUNNING;
        if (aniState == RUNNING) {
            player.getSong().play();
            gui.hide();
        } else {
            player.getSong().pause();
//            gui.show();
        }
    }

    public static void main(String[] args) {

        PApplet.main(new String[]{Funky.class.getName()});
    }
}
