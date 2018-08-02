package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;
import java.util.Random;

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

    public ArrayList<Line> lines;

    public LineCircle(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,
            float innerRadius,
            float outerRadius,
            float startToDrawLine,
            float endToDrawLine,
            float weight,
            int howMany
    ) {

        super(canvas, primaryColor, secondaryColor);

        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        this.startToDrawLine = startToDrawLine;
        this.endToDrawLine = endToDrawLine;
        this.howMany = howMany;
        this.weight = weight;

        centerX = canvas.width / 2;
        centerY = canvas.height / 2;

        lines = new ArrayList<>();

        // TODO load correct animations
        String lineAnimationPath = "";
        String[] lineAnimations = {};

        for (float i = startToDrawLine; i < endToDrawLine; i += endToDrawLine / howMany) {
            Line line = new Line(
                    canvas,
                    primaryColor,
                    secondaryColor,
                    lineAnimationPath,
                    lineAnimations,
                    weight,
                    PApplet.cos(i) * innerRadius,
                    PApplet.sin(i) * innerRadius,
                    PApplet.cos(i) * outerRadius,
                    PApplet.sin(i) * outerRadius
            );

            lines.add(line);
        }
    }

    @Override
    public void update(float cue) {

        
    }

    public void drawThreeLinesThinner() {

        Random rnd = new Random();
        int rndNumber = rnd.nextInt(lines.size() + 1);

        Line firstLine = lines.get(rndNumber);
        Line secondLine = rndNumber + 1 > lines.size() ? lines.get(rndNumber % 40) : lines.get(rndNumber + 1);
        Line thirdLine = rndNumber - 1 < 0 ? lines.get(40) : lines.get(rndNumber - 1);
    }

    @Override
    public void draw() {

        for (Line line : lines) {
            line.draw();
        }
    }

    @Override
    public void updateToPrimaryColor() {

        for (Line line : lines) { line.updateToPrimaryColor(); }
    }

    @Override
    public void updateToSecondaryColor() {

        for (Line line : lines) { line.updateToSecondaryColor(); }
    }
}
