package de.uulm.gdg2.GUI;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class MainMenu extends GUI {

    public MainMenu(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

        super(canvas, primaryColor, secondaryColor);

        String defaultImage = "./resources/button/play_default.png";
        String rolloverImage = "./resources/button/play_default.png";
        String pressedImagee = "./resources/button/play_hover.png";

        cp5.addButton("Play" )
            .setPosition(canvas.width / 2 - 45, canvas.height /2 - 45)
            .setImages(canvas.loadImage(defaultImage), canvas.loadImage(rolloverImage), canvas.loadImage(pressedImagee))
            .updateSize()
            .plugTo(canvas, "playPause"
        );
    }

    public void drawMenuLines() {

        canvas.stroke(
                secondaryColor.v1,
                secondaryColor.v2,
                secondaryColor.v3,
                secondaryColor.a
        );

        canvas.strokeCap(1);
        canvas.strokeWeight(50);
        canvas.line(0, canvas.height/2, canvas.width/2 - 150, canvas.height/2);
        canvas.line(canvas.width/2 + 150, canvas.height/2, canvas.width, canvas.height/2);

        canvas.strokeWeight(2);
        canvas.line(canvas.width/2 - 150, canvas.height/2 + 100, canvas.width/2 - 150, canvas.height/2 - 100);
        canvas.line(canvas.width/2 + 150, canvas.height/2 + 100, canvas.width/2 + 150, canvas.height/2 - 100);
    }
}
