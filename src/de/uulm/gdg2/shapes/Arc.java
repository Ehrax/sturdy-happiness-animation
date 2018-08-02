package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class Arc extends BasicShape {

    public float centerX;
    public  float centerY;

    public float distanceFromCenter;
    public float weight;

    public float angle = 0;

    public float drawStart;
    public float drawEnd;

    public Arc(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            String animationPath,
            String[] aniModes,
            float distanceFromCenter,
            float weight,
            float drawStart,
            float drawEnd
    ) {

        super(canvas, primaryColor, secondaryColor, animationPath, aniModes);

        this.centerX = canvas.width / 2;
        this.centerY = canvas.height / 2;

        this.distanceFromCenter = distanceFromCenter;
        this.weight = weight;

        this.drawStart = drawStart;
        this.drawEnd = drawEnd;
    }

    @Override
    public void draw() {

        canvas.pushMatrix();
        canvas.noFill();
        canvas.translate(centerX, centerY);
        canvas.strokeWeight(weight);
        canvas.rotate(angle);
        canvas.stroke(
                primaryColor.v1,
                primaryColor.v2,
                primaryColor.v3,
                primaryColor.a
        );
        canvas.arc(0, 0, distanceFromCenter, distanceFromCenter, drawStart, drawEnd);
        canvas.popMatrix();
    }

    @Override
    public void update(float cue) {
        // TODO
    }

    @Override
    public void updateToPrimaryColor() {
        canvas.stroke(
                primaryColor.v1,
                primaryColor.v2,
                primaryColor.v3,
                primaryColor.a
        );
    }

    @Override
    public void updateToSecondaryColor() {
        canvas.stroke(
                secondaryColor.v1,
                secondaryColor.v2,
                secondaryColor.v3,
                secondaryColor.a
        );
    }
}
