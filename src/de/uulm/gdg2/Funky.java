package de.uulm.gdg2;

import de.uulm.gdg2.GUI.GUI;
import de.uulm.gdg2.GUI.HelpMenu;
import de.uulm.gdg2.GUI.MainMenu;
import de.uulm.gdg2.GUI.OptionMenu;
import de.uulm.gdg2.animations.ClickAnimation;
import de.uulm.gdg2.controllers.AnimationImport;
import de.uulm.gdg2.controllers.GlobalAnimationController;
import de.uulm.gdg2.controllers.Player;
import de.uulm.gdg2.shapes.circle.ArcCircle;
import de.uulm.gdg2.shapes.BasicShape;
import de.uulm.gdg2.shapes.circle.InnerCircle;
import de.uulm.gdg2.shapes.circle.OuterCircle;
import de.uulm.gdg2.shapes.basic.Poop;
import de.uulm.gdg2.util.RGBaColor;
import de.uulm.gdg2.util.States;

import java.util.ArrayList;
import java.util.HashMap;

import jogamp.nativewindow.GlobalToolkitLock;
import processing.core.PApplet;

import static de.uulm.gdg2.util.States.AnimationStates.RUNNING;
import static de.uulm.gdg2.util.States.AnimationStates.PAUSED;
import static de.uulm.gdg2.util.States.AnimationStates.MAIN;
import static de.uulm.gdg2.util.States.AnimationStates.HELP;
import static de.uulm.gdg2.util.States.AnimationStates.OPTION;

import static de.uulm.gdg2.util.States.DevelopmentStates.DEBUG;

import static de.uulm.gdg2.util.States.RGBaColors;

public class Funky extends PApplet {

    public static final String SONG_PATH = "./resources/song.mp3";

    // our states
    public static States.AnimationStates aniState = MAIN;
    public static States.DevelopmentStates devState = DEBUG;

    public Player player;

    // GUI's
    public MainMenu mainMenu;
    public OptionMenu optionMenu;
    public HelpMenu helpMenu;

    // our colors
    public HashMap<String, GUI> guis = new HashMap<>();
    public RGBaColor primaryColor = RGBaColors.BLACK;
    public RGBaColor secondaryColor = RGBaColors.WHITE;

    public RGBaColor backgroundColor;

    // our elements
    public HashMap<String, BasicShape> shapes = new HashMap<>();
    public Poop poop;
    public InnerCircle innerCircle;
    public OuterCircle outerCircle;
    public ArcCircle arcCircle;

    //variables for GUI
    public int hmOuterCircle = 40;
    public int hmInnerCircle = 15;
    public int arcCircleWeight = 10;

    // our click Animation
    public ArrayList<ClickAnimation> clickAnimations;

    public GlobalAnimationController globalAnimationController;

    @Override
    public void settings() {

        if (devState == DEBUG) {
            size(1240, 720, P3D);
        } else {
            fullScreen(P3D);
        }
        smooth(8);
    }

    @Override
    public void setup() {

        // setting up player to play our song
        player = new Player(this, SONG_PATH);

        // initialize all our objects
        initialize();

        // setting up our menus
        RGBaColor guiPrimaryColor = primaryColor.copy();
        RGBaColor guiSecondaryColor = secondaryColor.copy();
        mainMenu = new MainMenu(this, guiPrimaryColor, guiSecondaryColor);
        guis.put("main", mainMenu);
        optionMenu = new OptionMenu(this, guiPrimaryColor, guiSecondaryColor);
        guis.put("option", optionMenu);
        helpMenu = new HelpMenu(this, guiPrimaryColor, guiSecondaryColor);
        guis.put("help", helpMenu);
    }

    /**
     * This method is called when the animation is loaded or when the rest button ist preset.
     */
    public void initialize() {

        player.song.rewind();
        player.song.pause();

        // setting up colors that we use :) TODO: color change has to be somehow dynamically
        /*primaryColor = RGBaColors.BLACK;
        secondaryColor = RGBaColors.WHITE;*/

        // set up background color of canvas
        backgroundColor = secondaryColor.copy();

        // Poop related stuff
        String poopAnimationPath = "./resources/json/animation/poop_anim.json";
        String[] poopAnimations = {"scale"};
        RGBaColor poopPrimaryColor = primaryColor.copy();
        RGBaColor poopSecondaryColor = secondaryColor.copy();
        poop = new Poop(
                this,
                poopPrimaryColor,
                poopSecondaryColor,
                255,
                poopAnimationPath,
                width/2,
                height/2,
                5000,
                poopAnimations
        );
        shapes.put("poop", poop);

        // outer line circle related stuff
        String outerCircleAnimationPath = "./resources/json/animation/outer_circle_anim.json";
        String[] outerCircleAnimations = {"innerRadius", "weight", "angle"};
        RGBaColor outerCirclePrimaryColor = primaryColor.copy();
        RGBaColor outerCircleSecondaryColor = secondaryColor.copy();
        outerCircle = new OuterCircle(
                this,
                outerCirclePrimaryColor,
                outerCircleSecondaryColor,
                1000,
                1000,
                0,
                TWO_PI,
                60,
              hmOuterCircle,
                outerCircleAnimationPath,
                outerCircleAnimations
        );
        shapes.put("outer_circle", outerCircle);

        // inner arc circle
        String arcCircleAnimationPath = "./resources/json/animation/arc_circle_anim.json";
        String[] arcCircleAnimations = {"alpha", "angle", "distanceFromCenter"};
        RGBaColor arcCirclePrimaryColor = primaryColor.copy();
        RGBaColor arcCircleSecondaryColor = secondaryColor.copy();
        arcCircle = new ArcCircle(
                this,
                arcCirclePrimaryColor,
                arcCircleSecondaryColor,
                3,                 //
                arcCircleWeight,                  // default weight 15
                160,
                PI/32,
                arcCircleAnimationPath,
                arcCircleAnimations
        );
        shapes.put("arc_circle", arcCircle);

        // inner circle
        String innerLineCircleAnimationPath = "./resources/json/animation/inner_circle_anim.json";
        String[] innerLineCircleAnimations = {"weight"};
        RGBaColor innerCirclePrimaryColor = primaryColor.copy();
        RGBaColor innerCircleSecondaryColor = secondaryColor.copy();
        innerCircle = new InnerCircle(
                this,
                innerCirclePrimaryColor,
                innerCircleSecondaryColor,
                30,
                50,
                0,
                TWO_PI,
                0,
                hmInnerCircle,
                innerLineCircleAnimationPath,
                innerLineCircleAnimations
        );
        shapes.put("inner_circle", innerCircle);

        // init our click animations
        String clickAnimationPath = "./resources/json/animation/click_anim.json";
        clickAnimations = AnimationImport.importClickAnimation(this, clickAnimationPath, "click");

        // global animation stuff
        globalAnimationController = new GlobalAnimationController(
                this,
                clickAnimations,
                shapes,
                primaryColor,
                secondaryColor
        );
    }

    @Override
    public void draw(){

        switch (aniState) {
            case MAIN:
                mainMenu.drawMenuLines();
                mainMenu.draw();
                return;
            case OPTION:
                optionMenu.draw();
                return;
            case HELP:
                helpMenu.draw();
                return;
            case RUNNING:
                globalAnimationController.drawAnimations(player.song.position());
                System.out.println(player.song.position());
                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed() {
        switch (Character.toLowerCase(key)) {
            case ' ':
                // only enable space bar if the scene is the animation
                if(aniState!= MAIN && aniState != HELP && aniState != OPTION) {
                    playPause();
                }
                break;
            case 'r':
                initialize();
                break;
            case 'e':
                break;
            case 'm':
                initialize();
                aniState = MAIN;
                break;
            case 'f':
                player.song.skip(5000);
            default:
                break;
        }
        super.keyPressed();
    }

    public void playPause() {
        aniState = aniState == RUNNING ? PAUSED : RUNNING;
        if (aniState == RUNNING) {
            player.song.play();
        } else {
            player.song.pause();
        }
    }
    // Methoden für Buttons
    public void outerLine30(){
        hmOuterCircle = 30;
        initialize();
    }
    public void outerLine40(){
        hmOuterCircle = 40;
        initialize();
    }
    public void outerLine50(){
        hmOuterCircle = 50;
        initialize();
    }
    public void innerLine10(){
        hmInnerCircle = 10;
        initialize();
    }
    public void innerLine15(){
        hmInnerCircle = 15;
        initialize();
    }
    public void innerLine20(){
        hmInnerCircle = 20;
        initialize();
    }
    public void arcWeight5(){
        arcCircleWeight = 5;
        initialize();
    }
    public void arcWeight10(){
        arcCircleWeight = 10;
        initialize();
    }
    public void arcWeight15(){
        arcCircleWeight = 15;
        initialize();
    }
    public void blackWhite(){
        primaryColor = RGBaColors.BLACK;
        secondaryColor = RGBaColors.WHITE;
        backgroundColor = RGBaColors.WHITE;
        initialize();
    }
    public void greenYellow(){
        primaryColor = new RGBaColor(50,205,50);
        secondaryColor = new RGBaColor(255,255,0);
        backgroundColor = new RGBaColor(50,205,50);
        initialize();
    }
    public void blueOrange(){
        primaryColor = new RGBaColor(250,250,210);
        secondaryColor = new RGBaColor(151,255,255);
        backgroundColor = new RGBaColor(151,255,255);
        initialize();
    }


    public void showHelpGui() { aniState = HELP; }

    public void showOptionGui() { aniState = OPTION; }

    public void showMainMenu() { aniState = MAIN; }

    public static void main(String[] args) {

        PApplet.main(new String[]{Funky.class.getName()});
    }
}
