package de.uulm.gdg2.shapes.circle;

import de.looksgood.ani.Ani;
import de.looksgood.ani.AniCore;
import de.uulm.gdg2.animations.CustomAnimation;
import de.uulm.gdg2.shapes.BasicShape;
import de.uulm.gdg2.shapes.basic.Arc;
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
            float gap,
            String animationPath,
            String[] animations
    ) {

        super(canvas, primaryColor, secondaryColor, animationPath, animations);

        this.howMany = howMany;
        this.weight = weight;
        this.gap = gap;
        this.distanceFromCenter = distanceFromCenter;

        arcs = new ArrayList<>();

        for (float i = 0.0f; i < howMany; i++) {

            float drawStart = canvas.TWO_PI * i/howMany;
            float drawEnd = canvas.TWO_PI * ((i + 1) / (howMany));

            Arc arc = new Arc(
                    canvas,
                    primaryColor,
                    secondaryColor,
                    0,
                    distanceFromCenter,
                    weight,
                    drawStart + gap,
                    drawEnd - gap
            );

            arcs.add(arc);
        }
    }

    @Override
    public void update(float cue) {
        if (anis.size() == 0){
            return;
        }

        if(cue < anis.get(0).start) {
            return;
        }

        CustomAnimation ani = anis.remove(0);

        for(Arc a: arcs){
            activeAnimations.add(Ani.to(a, ani.duration, ani.params, ani.value, ani.mode));
        }

        activeAnimations.add(Ani.to(this, ani.duration, ani.params, ani.value, ani.mode));
        activeAnimations.removeIf(AniCore::isEnded);
    }

    @Override
    public void draw() {

        arcs.forEach(BasicShape::draw);
    }

    @Override
    public void updateToSecondaryColor() {

        arcs.forEach(BasicShape::updateToSecondaryColor);
    }
}
