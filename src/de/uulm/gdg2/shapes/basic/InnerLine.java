package de.uulm.gdg2.shapes.basic;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class InnerLine extends OuterLine {

    public InnerLine(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            int alpha,
            float weight,
            float x1, float y1, float x2, float y2) {

        super(canvas, primaryColor, secondaryColor, alpha, weight, x1, y1, x2, y2);

        canvas.strokeCap(1);
    }

    @Override
    public void draw() {

        drawInnerLineCircle(primaryColor);
    }

    @Override
    public void updateToSecondaryColor() {

        drawInnerLineCircle(secondaryColor);
    }

    public void drawInnerLineCircle(RGBaColor color) {

        canvas.pushMatrix();
        canvas.translate(canvas.width/2, canvas.height/2);
        canvas.rotate(angle);
        canvas.stroke(color.v1, color.v2, color.v3, alpha);
        canvas.strokeWeight(weight);
        canvas.line(x1, y1, x2, y2);
        canvas.popMatrix();
    }
}
