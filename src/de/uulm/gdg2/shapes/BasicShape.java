package de.uulm.gdg2.shapes;

import de.looksgood.ani.Ani;
import de.uulm.gdg2.controllers.AnimationImport;
import de.uulm.gdg2.util.CustomAnimation;
import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;

public abstract class BasicShape {
    public PApplet canvas;

    public RGBaColor primaryColor;
    public RGBaColor secondaryColor;

    public ArrayList<CustomAnimation> anis;
    public String[] aniModes;

    public BasicShape(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            String animationPath,
            String[] aniModes
    ) {

        this.canvas = canvas;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.anis = new ArrayList<>();
        this.aniModes = aniModes;

        if (!animationPath.equals("") && aniModes.length != 0) {

            Ani.init(canvas);

            for (String mode : aniModes) {
                anis.addAll(AnimationImport.importAnimation(this.canvas, animationPath, mode));
            }

            Collections.sort(this.anis);
        }
    }

    public BasicShape(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

        this.canvas = canvas;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public abstract void draw();

    public abstract void update(float cue);

    public abstract void updateToPrimaryColor();

    public abstract void updateToSecondaryColor();

}
