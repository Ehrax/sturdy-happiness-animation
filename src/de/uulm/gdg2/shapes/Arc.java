package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.CustomAnimation;
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
            float distanceFromCenter,
            float weight,
            float drawStart,
            float drawEnd
    ) {

        super(canvas, primaryColor, secondaryColor);

        this.distanceFromCenter = distanceFromCenter;
        this.weight = weight;

        this.drawStart = drawStart;
        this.drawEnd = drawEnd;
    }

    @Override
    public void update(float cue, CustomAnimation ani) {

        // TODO: trigger here Ani animation
    }

    @Override
    public void draw() {

        drawArc(primaryColor);
    }

    @Override
    public void updateToPrimaryColor() {

        drawArc(primaryColor);
    }

    @Override
    public void updateToSecondaryColor() {

        drawArc(secondaryColor);
    }

    public void drawArc(RGBaColor color) {

        color.a = 0;

        canvas.noFill();
        canvas.strokeWeight(weight);
        canvas.rotate(angle);
        canvas.stroke(
                color.v1,
                color.v2,
                color.v3,
                color.a
        );
        canvas.arc(0, 0, distanceFromCenter, distanceFromCenter, drawStart, drawEnd);
    }
}
