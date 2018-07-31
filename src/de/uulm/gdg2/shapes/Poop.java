package de.uulm.gdg2.shapes;

import de.looksgood.ani.Ani;
import de.uulm.gdg2.controllers.AnimationImport;
import de.uulm.gdg2.util.CustomAnimation;
import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;

public class Poop {
    public static String ANIMATIN_PATH =  "./resources/times/poop.json";

    public PApplet canvas;

    public float posX;
    public float posY;
    public float size;

    public ArrayList<CustomAnimation> anis;

    public RGBaColor primaryColor;
    public RGBaColor secondaryColor;

    public Poop(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

        this.canvas = canvas;
        this.size = 0.2f;

        this.posX = canvas.width / 2;
        this.posY = canvas.height / 2;

        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;

        Ani.init(canvas);
        anis = AnimationImport.importAnimation(this.canvas, ANIMATIN_PATH, "size");
        Collections.sort(anis);
    }

    public void draw() {
        // draw inner ellipse
        canvas.ellipse(posX, posY, size, size);
        canvas.fill(
                this.primaryColor.v1,
                this.primaryColor.v2,
                this.primaryColor.v3,
                this.primaryColor.a
        );
    }

    public void update(float cue) {

        if (anis.size() == 0) {
            return;
        }
        if (cue < anis.get(0).start) {
            return;
        }

        CustomAnimation ani = anis.get(0);
        Ani.to(this, ani.duration, ani.params, ani.value, ani.mode);
        System.out.println(size);

        anis.remove(0);
    }

    public void updateToPrimaryColor() {
        canvas.fill(
                primaryColor.v1,
                primaryColor.v2,
                primaryColor.v3,
                primaryColor.a
        );
    }


    public void updateToSecondaryColor() {
        canvas.fill(
                secondaryColor.v1,
                secondaryColor.v2,
                secondaryColor.v3,
                secondaryColor.a
        );
    }
}
