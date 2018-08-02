package de.uulm.gdg2.controllers;

import controlP5.CColor;
import controlP5.ControlFont;
import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PFont;

public class GUI {
    public static final String OPEN_SANS_REGULAR_12 = "./resources/font/OpenSans-Regular-12.vlw";
    public static final String OPEN_SANS_REGULAR_14 = "./resources/font/OpenSans-Regular-14.vlw";
    public static final String OPEN_SANS_REGULAR_18 = "./resources/font/OpenSans-Regular-18.vlw";

    public ControlP5 cp5;

    public PApplet canvas;

    public GUI(PApplet canvas) {

        this.canvas = canvas;

        PFont pFont = canvas.loadFont(OPEN_SANS_REGULAR_12);
        ControlFont font = new ControlFont(pFont, 12);

        cp5 = new ControlP5(canvas);
        cp5.addButton("Play" )
            .setPosition(20, 125)
            .setSize(150, 136)
            .setFont(font)
            .plugTo(canvas, "playPause");
    }

    /**
     * if the gui is currently shown
     *
     * @return is visible
     */
    public boolean isVisible() {
        return cp5.isVisible();
    }

    /**
     * hides the gui
     */
    public void hide() {
        cp5.hide();
    }

    /**
     * displays the gui
     */
    public void show() {
        cp5.show();
    }
}
