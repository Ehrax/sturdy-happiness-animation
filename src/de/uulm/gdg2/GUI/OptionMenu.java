package de.uulm.gdg2.GUI;

import controlP5.*;
import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class OptionMenu extends GUI {

    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;
    CheckBox cb1;

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

        //label with description
        String imgPath = "./resources/png/stratttt.PNG";
        cp5.addButton("pngLabel")
                .setPosition(550,202)
                .setImage(canvas.loadImage(imgPath))
                .updateSize();
        //outer lines button/label
        cp5.addButton("OuterCircle30")
                .setPosition(220,210)
                .setLabel("30")
                .setSize(70,20)
                .plugTo(canvas,"outerLine30");

        cp5.addButton("OuterCircle40")
                .setPosition(300,210)
                .setLabel("40")
                .setSize(70,20)
                .plugTo(canvas,"outerLine40");

        cp5.addButton("OuterCircle50")
                .setPosition(380,210)
                .setLabel("50")
                .setSize(70,20)
                .plugTo(canvas,"outerLine50");

        cp5.addLabel("How many outer lines:")
                .setPosition(100,210)
                .setSize(100,100);

        //inner line buttons/label
        cp5.addLabel("How many inner lines:")
                .setPosition(100,310)
                .setSize(100,100);

        cp5.addButton("InnerCircle10")
                .setPosition(220,310)
                .setLabel("10")
                .setSize(70,20)
                .plugTo(canvas,"innerLine10");

        cp5.addButton("InnerCircle15")
                .setPosition(300,310)
                .setLabel("15")
                .setSize(70,20)
                .plugTo(canvas,"innerLine15");

        cp5.addButton("InnerCircle20")
                .setPosition(380,310)
                .setLabel("20")
                .setSize(70,20)
                .plugTo(canvas,"innerLine50");

        //arc circle weight buttons/label
        cp5.addLabel("ArcCircle weigth:")
                .setPosition(100,410)
                .setSize(100,100);

        cp5.addButton("arcWeight5")
                .setPosition(220,410)
                .setLabel("5")
                .setSize(70,20)
                .plugTo(canvas,"arcWeight5");

        cp5.addButton("arcWeight10")
                .setPosition(300,410)
                .setLabel("10")
                .setSize(70,20)
                .plugTo(canvas,"arcWeight10");

        cp5.addButton("arcWeight15")
                .setPosition(380,410)
                .setLabel("15")
                .setSize(70,20)
                .plugTo(canvas,"arcWeight15");

        //color change buttons/label
        cp5.addLabel("Color scheme:")
                .setPosition(100,510)
                .setSize(100,100);

        cp5.addButton("Black/White")
                .setPosition(220,510)
                .setLabel("Black/White")
                .setSize(70,20)
                .plugTo(canvas,"blackWhite");

        cp5.addButton("Green/Yellow")
                .setPosition(300,510)
                .setLabel("Green/Yellow")
                .setSize(70,20)
                .plugTo(canvas,"greenYellow");

        cp5.addButton("Blue/Orange")
                .setPosition(380,510)
                .setLabel("Blue/Orange")
                .setSize(70,20)
                .plugTo(canvas,"blueOrange");


       /* //Color RadioButton
        r1 = cp5.addRadioButton("Colorset")
                .setPosition(100,145)
                .setSize(40,40)
                .setItemsPerRow(1)
                .setSpacingRow(20)
                .addItem("Black/White",0)
                .addItem("Green/Yellow",50)
                .addItem("Blue/Orange",100);

        //RadioButtons how many Lines innerCircle
        r2 = cp5.addRadioButton("howManyInner")
                .setPosition(100,420)
                .setSize(40,40)
                .setItemsPerRow(1)
                .setSpacingRow(20)
                .addItem("8 Inner Lines", 8)
                .addItem("16 Inner Lines",16)
                .addItem("32 Inner Lines",32);

        //RadioButtons how many Lines outerCircle
        r3 = cp5.addRadioButton("howManyOuter")
                .setPosition(400,145)
                .setSize(40,40)
                .setItemsPerRow(1)
                .setSpacingRow(20)
                .addItem("30 Outer Lines",30)
                .addItem("40 Outer Lines",40)
                .addItem("50 Outer Lines",50);

        //RadioButtons Arc Circle weight
        r4 = cp5.addRadioButton("arcCircleWeight")
                .setPosition(400,420)
                .setSize(40,40)
                .setItemsPerRow(1)
                .setSpacingRow(20)
                .addItem("WeightArc = 5",5)
                .addItem("WeightArc = 10",10)
                .addItem("WeightArc = 15",15);*/
    }
}
