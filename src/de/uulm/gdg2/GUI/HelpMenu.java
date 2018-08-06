package de.uulm.gdg2.GUI;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class HelpMenu extends GUI {

    public HelpMenu(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

        super(canvas, primaryColor, secondaryColor);

        cp5.addButton("close" )
            .setPosition(20, 500)
            .setSize(150, 136)
            .setFont(font)
            .plugTo(canvas, "showMainMenu"
        );


    }
}
