package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;

import processing.core.PApplet;

public class OuterCircle extends BasicShape {

    public float innerRadius;
    public float outerRadius;

    public float startToDrawLine;
    public float endToDrawLine;

    public float centerX;
    public float centerY;

    public float weight;

    public int howMany;

    public ArrayList<OuterLine> lines;

    public OuterCircle(
            PApplet canvas,
            RGBaColor primaryColor,
            RGBaColor secondaryColor,

            float innerRadius,
            float outerRadius,
            float startToDrawLine,
            float endToDrawLine,
            float weight,
            int howMany,
            String animationPath,
            String[] animations
    ) {

        super(canvas, primaryColor, secondaryColor, animationPath, animations);

        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        this.startToDrawLine = startToDrawLine;
        this.endToDrawLine = endToDrawLine;
        this.howMany = howMany;
        this.weight = weight;

        centerX = canvas.width / 2;
        centerY = canvas.height / 2;

        lines = new ArrayList<>();

        for (float i = startToDrawLine; i < endToDrawLine; i += endToDrawLine / howMany) {
            OuterLine outerLine = new OuterLine(
                    canvas,
                    primaryColor,
                    secondaryColor,
                    255,
                    weight,
                    PApplet.cos(i) * innerRadius,
                    PApplet.sin(i) * innerRadius,
                    PApplet.cos(i) * outerRadius,
                    PApplet.sin(i) * outerRadius
            );

            lines.add(outerLine);
        }
    }

    /**
     * second constructor for InnerLineCircle because the draw method there is slightly different
     * @param canvas
     * @param primaryColor
     * @param secondaryColor
     * @param innerRadius
     * @param outerRadius
     * @param startToDrawLine
     * @param endToDrawLine
     * @param weight
     * @param howMany
     */
    public OuterCircle(
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
        this.weight = weight;
        this.howMany = howMany;
    }

    @Override
    public void update(float cue) {

        // TODO trigger animations for the lines
        for (OuterLine outerLine : lines) {
            outerLine.update(cue);
        }
    }

    @Override
    public void draw() {

        canvas.pushMatrix();
        canvas.translate(centerX, centerY);

        for (OuterLine outerLine : lines) {
            outerLine.draw();
        }

        canvas.popMatrix();
    }

    @Override
    public void updateToPrimaryColor() {

        for (OuterLine outerLine : lines) { outerLine.updateToPrimaryColor(); }
    }

    @Override
    public void updateToSecondaryColor() {

        for (OuterLine outerLine : lines) { outerLine.updateToSecondaryColor(); }
    }
}
