package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;

import processing.core.PApplet;

public class LineCircle extends BasicShape {

    public float innerRadius;
    public float outerRadius;

    public float startToDrawLine;
    public float endToDrawLine;

    public float centerX;
    public float centerY;

    public float weight;

    public int howMany;

    public boolean rnd;
    public String circle;

    public ArrayList<Line> lines;

    public LineCircle(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            String animationPath,
            String[] aniModes,
            float innerRadius,
            float outerRadius,
            float startToDrawLine,
            float endToDrawLine,
            float weight,
            int howMany
    ) {

        super(canvas, primaryColor, secondaryColor, animationPath, aniModes);

        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        this.startToDrawLine = startToDrawLine;
        this.endToDrawLine = endToDrawLine;
        this.howMany = howMany;
        this.weight = weight;

        centerX = canvas.width / 2;
        centerY = canvas.height / 2;

        lines = new ArrayList<>();
    }

    @Override
    public void draw() {
        String lineAnimationPath = "";
        String[] lineAnimations = {};

        for(float i = startToDrawLine; i < endToDrawLine; i += endToDrawLine/howMany) {
            float nOuterRadius = outerRadius;

            Line line = new Line(
                    canvas,
                    primaryColor,
                    secondaryColor,
                    lineAnimationPath,
                    lineAnimations,
                    weight,
                PApplet.cos(i) * innerRadius + centerX,
                PApplet.sin(i) * innerRadius + centerY,
                PApplet.cos(i) * nOuterRadius + centerX,
                PApplet.sin(i) * nOuterRadius + centerY
            );

            line.draw();
            lines.add(line);
        }
    }

    @Override
    public void update(float cue) {

    }

    @Override
    public void updateToPrimaryColor() {
        for(Line line : lines) {
            line.updateToPrimaryColor();;
        }
    }

    @Override
    public void updateToSecondaryColor() {
        for (Line line : lines) {
            line.updateToSecondaryColor();
        }
    }
}
