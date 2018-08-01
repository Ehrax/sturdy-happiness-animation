package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class LineCircle extends BasicShape {
    public float innerRadius;
    public float outerRadius;

    public float weight;
    public float lines;

    public LineCircle(PApplet canvas,
                      RGBaColor primaryColor,
                      RGBaColor secondaryColor,
                      String animationPath,
                      String[] aniModes) {

        super(canvas, primaryColor, secondaryColor, animationPath, aniModes);
    }

    @Override
    void draw() {

    }

    @Override
    void update(float cue) {

    }
}

