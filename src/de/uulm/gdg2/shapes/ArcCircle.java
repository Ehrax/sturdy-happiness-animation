package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;

import processing.core.PApplet;

public class ArcCircle extends BasicShape {

    public int howMany;
    public float weight;
    public float gap;
    public float distanceFromCenter;

    public ArrayList<Arc> arcs;

    public ArcCircle(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            int howMany,
            float weight,
            float distanceFromCenter,
            float gap
    ) {

        super(canvas, primaryColor, secondaryColor);

        this.howMany = howMany;
        this.weight = weight;
        this.gap = gap;
        this.distanceFromCenter = distanceFromCenter;

        arcs = new ArrayList<>();

        String animationPath = "";
        String[] animations = {};

        for (float i = 0.0f; i < howMany; i++) {

            float drawStart = canvas.TWO_PI * i/howMany;
            float drawEnd = canvas.TWO_PI * ((i + 1) / (howMany));

            Arc arc = new Arc(
                    canvas,
                    primaryColor,
                    secondaryColor,
                    animationPath,
                    animations,
                    distanceFromCenter,
                    weight,
                    drawStart + gap,
                    drawEnd - gap
            );

            arcs.add(arc);
        }
    }

    @Override
    public void draw() {

        for (Arc arc : arcs) {

            arc.draw();
        }
    }

    @Override
    public void update(float cue) {

    }

    @Override
    public void updateToPrimaryColor() {

    }

    @Override
    public void updateToSecondaryColor() {

    }
}
