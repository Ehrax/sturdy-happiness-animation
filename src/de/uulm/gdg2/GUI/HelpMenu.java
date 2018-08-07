package de.uulm.gdg2.GUI;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class HelpMenu extends GUI {

    public HelpMenu(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

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
    }
}
