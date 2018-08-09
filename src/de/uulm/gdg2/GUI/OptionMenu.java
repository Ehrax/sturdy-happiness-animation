package de.uulm.gdg2.GUI;

import controlP5.*;
import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class OptionMenu extends GUI {

    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;

    public OptionMenu(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

        super(canvas, primaryColor, secondaryColor);

        // play button
        String defaultPlayImgPath = "./resources/button/close_default.png";
        String hoverPlayImgPath = "./resources/button/close_hover.png";
        cp5.addButton("close" )
            .setPosition(canvas.width - 90, 40)
            .setImages(canvas.loadImage(defaultPlayImgPath), canvas.loadImage(hoverPlayImgPath), canvas.loadImage(hoverPlayImgPath))
            .updateSize()
            .plugTo(canvas, "showMainMenu"

        );

        //Color RadioButton

        r1 = cp5.addRadioButton("Colorset")
                .setPosition(100,100)
                .setSize(40,40)
                .setItemsPerRow(1)
                .setSpacingRow(20)
                .addItem("Black/White",0)
                .addItem("Green/Yellow",50)
                .addItem("Blue/Orange",100);

        //RadioButtons how many Lines innerCircle

        r2 = cp5.addRadioButton("howManyInner")
                .setPosition(100,400)
                .setSize(40,40)
                .setItemsPerRow(1)
                .setSpacingRow(20)
                .addItem("8 Inner Lines", 8)
                .addItem("16 Inner Lines",16)
                .addItem("32 Inner Lines",32);

        //RadioButtons how many Lines outerCircle

        r3 = cp5.addRadioButton("howManyOuter")
                .setPosition(400,100)
                .setSize(40,40)
                .setItemsPerRow(1)
                .setSpacingRow(20)
                .addItem("30 Outer Lines",30)
                .addItem("40 Outer Lines",40)
                .addItem("50 Outer Lines",50);

        //RadioButtons Arc Circle weight

        r4 = cp5.addRadioButton("arcCircleWeight")
                .setPosition(400,400)
                .setSize(40,40)
                .setItemsPerRow(1)
                .setSpacingRow(20)
                .addItem("WeightArc = 5",5)
                .addItem("WeightArc = 10",10)
                .addItem("WeightArc = 15",15);
    }
}
