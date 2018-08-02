package de.uulm.gdg2.controllers;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Player {
    private AudioPlayer song;

    public Player(PApplet p, String file) {

        Minim minim = new Minim(p);
        this.song = minim.loadFile(file);
    }

    public void startPlaying() {
        if (!song.isPlaying()) {
            song.play();
        }
    }

    public AudioPlayer getSong() {
        return this.song;
    }
}
