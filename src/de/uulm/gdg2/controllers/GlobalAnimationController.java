package de.uulm.gdg2.controllers;

import de.uulm.gdg2.animations.ClickAnimation;
import de.uulm.gdg2.shapes.BasicShape;
import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;

public class GlobalAnimationController {
    public PApplet canvas;

    public float lastClickStart;
    public float lastClickEnd;

    public ArrayList<ClickAnimation> anis;
    public HashMap<String, BasicShape> shapes;
    RGBaColor primaryColor;
    RGBaColor secondaryColor;

    public GlobalAnimationController(
            PApplet canvas,
            ArrayList<ClickAnimation> anis,
            HashMap<String, BasicShape> shapes,
            RGBaColor primaryColor,
            RGBaColor secondaryColor
    ) {

        this.canvas = canvas;
        this.anis = anis;
        this.shapes = shapes;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;

        this.lastClickStart = anis.get(0).start;
        this.lastClickEnd = anis.get(0).end;
    }

    public void drawAnimations(float cue) {

        if (cue >= lastClickStart && cue <= lastClickEnd && anis.size() != 0) {
            canvas.background( primaryColor.v1, primaryColor.v2, primaryColor.v3);
            shapes.forEach((k, s) -> {
                s.updateToSecondaryColor();
                s.update(cue);
            });

            if (lastClickStart == anis.get(0).start) {
                anis.remove(0);
            }
        } else {
            canvas.background( secondaryColor.v1, secondaryColor.v2, secondaryColor.v3);
            shapes.forEach((k, s) -> {
                s.draw();
                s.update(cue);
            });

            lastClickStart = anis.get(0).start;
            lastClickEnd = anis.get(0).end;
        }
    }
}
