package de.uulm.gdg2.shapes.basic;

import de.uulm.gdg2.animations.CustomAnimation;
import de.uulm.gdg2.shapes.BasicShape;
import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class Arc extends BasicShape {

    public float distanceFromCenter;
    public float weight;

    public float angle = 0;

    public float drawStart;
    public float drawEnd;

    public CustomAnimation ani;

    public Arc(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            int alpha,
            float distanceFromCenter,
            float weight,
            float drawStart,
            float drawEnd
    ) {

        super(canvas, primaryColor, secondaryColor, alpha);

        this.distanceFromCenter = distanceFromCenter;
        this.weight = weight;

        this.drawStart = drawStart;
        this.drawEnd = drawEnd;
    }

    @Override
    public void draw() {

        drawArc(primaryColor);
    }

    @Override
    public void updateToSecondaryColor() {

        drawArc(secondaryColor);
    }

    public void drawArc(RGBaColor color) {

        canvas.pushMatrix();
        canvas.translate(canvas.width/2, canvas.height/2);
        canvas.noFill();
        canvas.strokeWeight(weight);
        canvas.rotate(angle);
        canvas.stroke(
                color.v1,
                color.v2,
                color.v3,
                alpha
        );
        canvas.arc(0, 0, distanceFromCenter, distanceFromCenter, drawStart, drawEnd);
        canvas.popMatrix();
    }
}
