package de.uulm.gdg2.shapes.circle;

import de.looksgood.ani.Ani;
import de.looksgood.ani.AniCore;
import de.uulm.gdg2.animations.CustomAnimation;
import de.uulm.gdg2.controllers.AnimationImport;
import de.uulm.gdg2.shapes.BasicShape;
import de.uulm.gdg2.shapes.basic.OuterLine;
import de.uulm.gdg2.util.RGBaColor;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;

public class OuterCircle extends BasicShape {

    public float innerRadius;
    public float outerRadius;

    public float startToDrawLine;
    public float endToDrawLine;

    public float centerX;
    public float centerY;

    public float weight;
    public float angle;

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
        this.angle = 0;

        centerX = canvas.width / 2;
        centerY = canvas.height / 2;
    }

    @Override
    public void update(float cue) {

        for (OuterLine outerLine : lines) {
            outerLine.update(cue);
        }
        if (anis.size() == 0){
            return;
        }

        if(cue <= anis.get(0).start) {
            return;
        }

        CustomAnimation ani = anis.remove(0);
        activeAnimations.add(Ani.to(this, ani.duration, ani.params, ani.value, ani.mode));
        draw();
        activeAnimations.removeIf(AniCore::isEnded);
    }

    @Override
    public void draw() {

        lines = new ArrayList<>();

        innerRadius += 0.15f;
        System.out.println();
        for (float i = startToDrawLine; i < endToDrawLine; i += endToDrawLine / howMany) {
            OuterLine outerLine = new OuterLine(
                    canvas,
                    primaryColor,
                    secondaryColor,
                    255,
                    weight,
                    angle,
                    PApplet.cos(i) * innerRadius,
                    PApplet.sin(i) * innerRadius,
                    PApplet.cos(i) * outerRadius,
                    PApplet.sin(i) * outerRadius
            );

            lines.add(outerLine);
        }
        lines.forEach(BasicShape::draw);
    }

    @Override
    public void updateToSecondaryColor() {

        lines.forEach(BasicShape::updateToSecondaryColor);
    }
}
