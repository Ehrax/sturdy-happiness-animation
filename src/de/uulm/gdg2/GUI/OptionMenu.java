package de.uulm.gdg2.GUI;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class OptionMenu extends GUI {

    public OptionMenu(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

        super(canvas, primaryColor, secondaryColor);

        cp5.addButton("Play" )
            .setPosition(20, 125)
            .setSize(150, 136)
            .setFont(font)
            .plugTo(canvas, "playPause"
        );
    }
}
