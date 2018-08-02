package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class Line extends BasicShape {
    public float x1;
    public float y1;

    public float x2;
    public float y2;

    public boolean thinner = false;

    public float weight;
    public float angle = 0;

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

        canvas.strokeCap(1);
    }

    @Override
    public void draw() {

        canvas.pushMatrix();
        canvas.strokeWeight(weight);
        canvas.translate(canvas.width / 2, canvas.height / 2);
        canvas.rotate(angle);
        canvas.stroke(
                this.primaryColor.v1,
                this.primaryColor.v2,
                this.primaryColor.v3,
                this.primaryColor.a
        );
        canvas.line(x1, y1, x2, y2);
        canvas.popMatrix();
    }

    @Override
    public void update(float cue) {
        // TODO: do animation here
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
