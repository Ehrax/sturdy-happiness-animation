package de.uulm.gdg2.shapes;

import de.uulm.gdg2.util.RGBaColor;
import processing.core.PApplet;

public class OuterShape {
    PApplet canvas;

    float posX;
    float posY;
    float height;
    float width;
    RGBaColor color;

    public OuterShape(PApplet canvas, float posX, float posY, float height, float width, RGBaColor color) {
        this.canvas = canvas;
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public void display(){
        canvas.fill(color.v1,color.v2,color.v3,color.a);
        canvas.rect(posX,posY,width,height);
    }

    public void update(){

    }
}
