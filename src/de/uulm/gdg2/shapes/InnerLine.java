package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class InnerLine extends OuterLine {

    public InnerLine(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            float weight,
            float x1, float y1, float x2, float y2) {

        super(canvas, primaryColor, secondaryColor, weight, x1, y1, x2, y2);

        canvas.strokeCap(1);
    }

    @Override
    public void draw() {

        drawInnerLineCircle(primaryColor);
    }

    @Override
    public void updateToPrimaryColor() {

        drawInnerLineCircle(primaryColor);
    }

    @Override
    public void updateToSecondaryColor() {

        drawInnerLineCircle(secondaryColor);
    }

    public void drawInnerLineCircle(RGBaColor color) {

        canvas.rotate(angle);
        canvas.stroke(color.v1, color.v2, color.v3, color.a);
        canvas.strokeWeight(weight);
        canvas.line(x1, y1, x2, y2);
    }
}
