package de.uulm.gdg2.controllers;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Player {
    public AudioPlayer song;

    public Player(PApplet p, String file) {

        Minim minim = new Minim(p);
        this.song = minim.loadFile(file);
    }
}
