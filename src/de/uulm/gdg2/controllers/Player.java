package de.uulm.gdg2.controllers;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Player {
    private AudioPlayer song;
    private FFT fft;

    public Player(PApplet p, String file) {

        Minim minim = new Minim(p);
        this.song = minim.loadFile(file);
        this.fft = new FFT(song.bufferSize(), song.sampleRate());
    }

    public void startPlaying() {
        if (!song.isPlaying()) {
            song.play();
        }
    }

    public void pausePlaying() {
        if (song.isPlaying()) {
            song.pause();
        }
    }

    public void stopPlaying() {
        if (song.isPlaying()) {
            song.pause();
            song.cue(0);
        }
    }

    public void toggleReplay() {
        if (!song.isPlaying()) {
            song.play();
        } else {
            song.pause();
            song.cue(0);
        }
    }

    public FFT getFft () {
        return this.fft;
    }

    public AudioPlayer getSong() {
        return this.song;
    }
}
