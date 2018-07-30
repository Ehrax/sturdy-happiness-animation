package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;

import org.w3c.dom.css.RGBColor;

import processing.core.PApplet;

public class Poop {
    public PApplet canvas;

    public float posX;
    public float posY;
    public float size;

    public RGBaColor color;

    public Poop(PApplet canvas, float size, RGBaColor color) {

        this.canvas = canvas;
        this.size = size;
        this.posX = canvas.width / 2;
        this.posY = canvas.height / 2;
        this.color = color;
    }

    public void draw() {

        canvas.ellipse(posX, posY, size, size);
        canvas.fill(color.v1, color.v2, color.v3, color.a);
    }

    public void update() {

    }
}
