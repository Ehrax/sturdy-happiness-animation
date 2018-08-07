package de.uulm.gdg2.GUI;

import de.uulm.gdg2.util.RGBaColor;
import de.uulm.gdg2.util.States;

import controlP5.ControlFont;
import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PFont;

public abstract class GUI {
    public static final String OPEN_SANS_REGULAR_12 = "./resources/font/OpenSans-Regular-12.vlw";
    public static final String OPEN_SANS_REGULAR_14 = "./resources/font/OpenSans-Regular-14.vlw";
    public static final String OPEN_SANS_REGULAR_18 = "./resources/font/OpenSans-Regular-18.vlw";

    public ControlP5 cp5;
    public PApplet canvas;

    public ControlFont font;

    public RGBaColor primaryColor;
    public RGBaColor secondaryColor;

    public GUI(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

        this.canvas = canvas;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;

        PFont pFont = canvas.loadFont(OPEN_SANS_REGULAR_12);
        font = new ControlFont(pFont, 12);

        cp5 = new ControlP5(canvas);
        cp5.setAutoDraw(false);
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

    public void draw() {

        canvas.fill(
                primaryColor.v1,
                primaryColor.v2,
                primaryColor.v3
        );

        canvas.noStroke();
        canvas.rect(0, 0, canvas.width, canvas.height);

        canvas.stroke(
                secondaryColor.v1,
                secondaryColor.v2,
                secondaryColor.v3
        );

        canvas.strokeCap(1);
        canvas.strokeWeight(2);
        canvas.line(20, 20, 100, 20);
        canvas.line(100, 30, 100, 10);
        canvas.line(20, 20, 20, 100);
        canvas.line(30, 100, 10, 100);

        canvas.line(20, canvas.height - 20 , 100, canvas.height - 20);
        canvas.line(100, canvas.height - 10, 100, canvas.height - 30);
        canvas.line(20, canvas.height - 20, 20, canvas.height - 100);
        canvas.line(30, canvas.height - 100, 10, canvas.height - 100);

        canvas.line(20, canvas.height - 20 , 100, canvas.height - 20);
        canvas.line(100, canvas.height - 10, 100, canvas.height - 30);
        canvas.line(20, canvas.height - 20, 20, canvas.height - 100);
        canvas.line(30, canvas.height - 100, 10, canvas.height - 100);

        canvas.line(canvas.width - 100, 20 , canvas.width - 20, 20);
        canvas.line(canvas.width - 100, 10, canvas.width - 100, 30);
        canvas.line(canvas.width - 20, 20, canvas.width - 20, 100);
        canvas.line(canvas.width - 30, 100, canvas.width - 10, 100);

        canvas.line(canvas.width - 100, canvas.height - 20, canvas.width - 20, canvas.height - 20);
        canvas.line(canvas.width - 100, canvas.height - 10, canvas.width - 100, canvas.height - 30);
        canvas.line(canvas.width - 20, canvas.height - 20, canvas.width - 20, canvas.height - 100);
        canvas.line(canvas.width - 30, canvas.height - 100, canvas.width - 10, canvas.height - 100);

        cp5.draw();
    };
}
