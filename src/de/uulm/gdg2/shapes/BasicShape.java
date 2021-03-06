package de.uulm.gdg2.shapes;

import de.looksgood.ani.Ani;
import de.looksgood.ani.AniCore;
import de.uulm.gdg2.controllers.AnimationImport;
import de.uulm.gdg2.animations.CustomAnimation;
import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;

public abstract class BasicShape {
    public PApplet canvas;

    public RGBaColor primaryColor;
    public RGBaColor secondaryColor;

    public ArrayList<CustomAnimation> anis;
    public ArrayList<Ani> activeAnimations;
    public String[] aniModes;

    public int alpha;

    public BasicShape(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            int alpha
    ) {

        this.canvas = canvas;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.alpha = alpha;
    }

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
        this.activeAnimations = new ArrayList<>();
        this.aniModes = aniModes;

        if (!animationPath.equals("") && aniModes.length != 0) {

            Ani.init(canvas);

            for (String mode : aniModes) {
                anis.addAll(AnimationImport.importAnimation(this.canvas, animationPath, mode));
            }

            Collections.sort(this.anis);
        }
    }

    public BasicShape(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            int alpha,
            String animationPath,
            String[] aniModes
    ) {

        this.canvas = canvas;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.alpha = alpha;
        this.anis = new ArrayList<>();
        this.activeAnimations = new ArrayList<>();
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

    public abstract void updateToSecondaryColor();

    public void update(float cue) {

    }


    public void resume() {
        activeAnimations.removeIf(AniCore::isEnded);
        activeAnimations.forEach(AniCore::resume);
    }

    public void pause() {
        activeAnimations.forEach(AniCore::pause);
    }
}
