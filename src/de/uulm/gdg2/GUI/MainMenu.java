package de.uulm.gdg2.GUI;

import de.uulm.gdg2.util.RGBaColor;

import processing.core.PApplet;

public class MainMenu extends GUI {

    public MainMenu(PApplet canvas, RGBaColor primaryColor, RGBaColor secondaryColor) {

        super(canvas, primaryColor, secondaryColor);

        // play button
        String defaultPlayImgPath = "./resources/button/play_default.png";
        String hoverPlayImgPath = "./resources/button/play_hover.png";
        cp5.addButton("play" )
            .setPosition(canvas.width / 2 - 55, canvas.height /2 - 45)
            .setImages(canvas.loadImage(defaultPlayImgPath), canvas.loadImage(hoverPlayImgPath), canvas.loadImage(hoverPlayImgPath))
            .updateSize()
            .plugTo(canvas, "playPause"
        );

        // help button
        String defaultHelpImgPath = "./resources/button/help_default.png";
        String hoverHelpImgPath = "./resources/button/help_hover.png";
        cp5.addButton("help" )
            .setPosition(35, canvas.height - 85)
            .setImages(canvas.loadImage(defaultHelpImgPath), canvas.loadImage(hoverHelpImgPath), canvas.loadImage(hoverHelpImgPath))
            .updateSize()
            .plugTo(canvas, "showHelpGui"
        );

        // settings button
        String defaultSettingsImgPath = "./resources/button/settings_default.png";
        String hoverSettingsImgPath = "./resources/button/settings_hover.png";
        cp5.addButton("settings" )
            .setPosition(canvas.width - 85, canvas.height - 85)
            .setImages(canvas.loadImage(defaultSettingsImgPath), canvas.loadImage(hoverSettingsImgPath), canvas.loadImage(hoverSettingsImgPath))
            .updateSize()
            .plugTo(canvas, "showOptionGui"
        );
    }

    public void drawMenuLines() {

        canvas.stroke(
                secondaryColor.v1,
                secondaryColor.v2,
                secondaryColor.v3
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
