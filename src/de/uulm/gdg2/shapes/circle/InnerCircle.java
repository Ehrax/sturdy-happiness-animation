package de.uulm.gdg2.shapes.circle;

import de.uulm.gdg2.shapes.BasicShape;
import de.uulm.gdg2.shapes.basic.InnerLine;
import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;

import processing.core.PApplet;

public class InnerCircle extends OuterCircle {

    public ArrayList<InnerLine> lines;

    public InnerCircle(
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

        super(
                canvas,
                primaryColor,
                secondaryColor,
                innerRadius,
                outerRadius,
                startToDrawLine,
                endToDrawLine,
                weight,
                howMany,
                animationPath,
                animations
        );

        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        this.startToDrawLine = startToDrawLine;
        this.endToDrawLine = endToDrawLine;
        this.howMany = howMany;
        this.weight = weight;

        centerX = canvas.width/2;
        centerY = canvas.height/2;

        lines = new ArrayList<>();

        for(float i = startToDrawLine; i < endToDrawLine; i+= endToDrawLine / howMany) {
            InnerLine innerLine = new InnerLine(
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

            lines.add(innerLine);
        }
    }

    @Override
    public void update(float cue) {

       // TODO trigger animations here
    }

    @Override
    public void draw() {

        lines.forEach(BasicShape::draw);
    }

    @Override
    public void updateToSecondaryColor() {

        lines.forEach(BasicShape::updateToSecondaryColor);
    }
}
