package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class Line extends BasicShape {
    float x1;
    float y1;

    float x2;
    float y2;

    float weight;

    public Line(PApplet canvas,
                RGBaColor primaryColor,
                RGBaColor secondaryColor,
                String animationPath,
                String[] aniModes,
                float weight,
                float x1, float y1, float x2, float y2) {

        super(canvas, primaryColor, secondaryColor, animationPath, aniModes);

        this.weight = weight;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        canvas.strokeWeight(weight);
        canvas.strokeCap(1);
    }

    @Override
    public void draw() {
        canvas.stroke(
                this.primaryColor.v1,
                this.primaryColor.v2,
                this.primaryColor.v3,
                this.primaryColor.a
        );
        canvas.line(x1, y1, x2, y2);
    }

    @Override
    public void update(float cue) {

    }

    @Override
    public void updateToPrimaryColor() {
        canvas.stroke(
                this.primaryColor.v1,
                this.primaryColor.v2,
                this.primaryColor.v3,
                this.primaryColor.a
        );
        canvas.line(x1, y1, x2, y2);
    }

    @Override
    public void updateToSecondaryColor() {
        canvas.stroke(
                this.secondaryColor.v1,
                this.secondaryColor.v2,
                this.secondaryColor.v3,
                this.secondaryColor.a
        );
        canvas.line(x1, y1, x2, y2);
    }
}
