package de.uulm.gdg2.shapes.basic;

import de.uulm.gdg2.controllers.AnimationImport;
import de.uulm.gdg2.shapes.BasicShape;
import de.uulm.gdg2.util.RGBaColor;

import java.util.Collections;

import processing.core.PApplet;

public class OuterLine extends BasicShape {
    public float x1;
    public float y1;

    public float x2;
    public float y2;

    public float weight;
    public float angle;

    public OuterLine(PApplet canvas,
                     RGBaColor primaryColor,
                     RGBaColor secondaryColor,
                     int alpha,
                     float weight,
                     float angle,
                     float x1, float y1, float x2, float y2
    ) {

        super(canvas, primaryColor, secondaryColor, alpha);

        this.weight = weight;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.angle = angle;

        canvas.strokeCap(1);
    }

    @Override
    public void draw() {

        drawCircle(primaryColor);
    }

    @Override
    public void updateToSecondaryColor() {

        drawCircle(secondaryColor);
    }


    public void drawCircle(RGBaColor color) {

        canvas.pushMatrix();
        canvas.translate(canvas.width/2, canvas.height/2);
        canvas.stroke( color.v1, color.v2, color.v3, alpha);
        canvas.rotate(angle);
        float dist = PApplet.dist(x1, y1, 0, 0);
        for(float i = 0; i < 1; i+= 1f / 75f) {

            canvas.strokeWeight(PApplet.lerp((dist * 3) /weight, weight,i));
//            canvas.strokeWeight(PApplet.lerp(25, weight,i));
//            canvas.stroke(canvas.lerpColor(255, 0, i));

            float xt1 = PApplet.lerp(x1, x2, i);
            float yt1 = PApplet.lerp(y1, y2, i);

            canvas.line(xt1, yt1, x2, y2);
        }
        canvas.popMatrix();
    }
}
