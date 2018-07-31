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
        this.color = color;
    }

    public void display() {

        canvas.fill(color.v1, color.v2, color.v3, color.a);
        canvas.ellipse(posX, posY, size, size);
    }

    public void update() {
        if (size < 50)
        size = size + 2;
    }
}
