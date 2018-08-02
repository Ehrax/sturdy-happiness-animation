package de.uulm.gdg2.shapes;

import de.looksgood.ani.Ani;
import de.looksgood.ani.AniCore;
import de.uulm.gdg2.util.CustomAnimation;
import de.uulm.gdg2.util.RGBaColor;

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
            String animationPath,
            float posX,
            float posY,
            float scale,
            String[] aniModes
    ) {

        super(canvas, primaryColor, secondaryColor, animationPath, aniModes);


        this.posX = posX;
        this.posY = posY;

        this.scale = scale;
    }

    @Override
    public void draw() {

        canvas.pushMatrix();
        canvas.translate(posX, posY);
        canvas.noStroke();
        canvas.fill(
                this.primaryColor.v1,
                this.primaryColor.v2,
                this.primaryColor.v3,
                this.primaryColor.a
        );
        canvas.ellipse(0, 0, scale, scale);
        canvas.popMatrix();
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

        canvas.fill(
                this.primaryColor.v1,
                this.primaryColor.v2,
                this.primaryColor.v3,
                this.primaryColor.a
        );
        canvas.ellipse(posX, posY, scale, scale);
    }

    @Override
    public void updateToSecondaryColor() {

        canvas.fill(
                this.secondaryColor.v1,
                this.secondaryColor.v2,
                this.secondaryColor.v3,
                this.secondaryColor.a
        );
        canvas.ellipse(posX, posY, scale, scale);
    }
}
