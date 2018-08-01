package de.uulm.gdg2.shapes;

import de.looksgood.ani.Ani;
import de.uulm.gdg2.util.CustomAnimation;
import de.uulm.gdg2.util.RGBaColor;

import java.util.Collections;

import processing.core.PApplet;

public class Poop extends BasicShape {

    public float posX;
    public float posY;

    public float scale;

    public Poop(PApplet canvas,
                RGBaColor primaryColor,
                RGBaColor secondaryColor,
                String animationPath,
                float posX,
                float posY,
                float scale,
                String[] aniModes) {

        super(canvas, primaryColor, secondaryColor, animationPath, aniModes);

        this.posX = posX;
        this.posY = posY;

        this.scale = scale;
    }

    public void draw() {
        canvas.ellipse(posX, posY, scale, scale);
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

        CustomAnimation ani = anis.remove(0);

        Ani.to(this, ani.duration, ani.params, ani.value, ani.mode);

        if (ani.delay != 0) {
            ani.start += ani.delay;
            anis.add(ani);
            Collections.sort(anis);
        }
    }
}
