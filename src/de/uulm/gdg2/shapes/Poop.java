package de.uulm.gdg2.shapes;

import de.looksgood.ani.Ani;
import de.looksgood.ani.AniCore;
import de.uulm.gdg2.util.CustomAnimation;
import de.uulm.gdg2.util.RGBaColor;

import sun.awt.image.PixelConverter;

import java.util.Collections;

import processing.core.PApplet;

public class Poop extends BasicShape {

    public float posX;
    public float posY;

    public float scale;

    public Poop(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            int alpha,
            String animationPath,
            float posX,
            float posY,
            float scale,
            String[] aniModes
    ) {

        super(canvas, primaryColor, secondaryColor, alpha, animationPath, aniModes);

        this.posX = posX;
        this.posY = posY;

        this.scale = scale;
    }

    @Override
    public void draw() {

        drawCircle(primaryColor);
    }

    @Override
    public void update(float cue) {

        if (anis.size() == 0) {
            return;
        }
        if (cue < anis.get(0).start) {
            return;
        }

        CustomAnimation ani = anis.remove(0);

        activeAnimations.add(Ani.to(this, ani.duration, ani.params, ani.value, ani.mode));

        if (ani.delay != 0) {
            ani.start += ani.delay;
            anis.add(ani);
            Collections.sort(anis);
        }

        activeAnimations.removeIf(AniCore::isEnded);
    }

    @Override
    public void updateToPrimaryColor() {

       drawCircle(primaryColor);
    }

    @Override
    public void updateToSecondaryColor() {

        drawCircle(secondaryColor);
    }

    public void drawCircle(RGBaColor color) {

        canvas.pushMatrix();
        canvas.translate(posX, posY);
        canvas.noStroke();
        canvas.fill( color.v1, color.v2, color.v3, alpha);
        canvas.ellipse(0, 0, scale, scale);
        canvas.popMatrix();
    }
}
