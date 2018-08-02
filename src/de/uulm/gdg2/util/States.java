package de.uulm.gdg2.util;

public class States {
    public enum AnimationStates {
        READY, RUNNING, PAUSED
    }

    public enum DevelopmentStates {
        DEBUG, DEPLOY
    }

    // TODO: pick up some colors :)
    public interface RGBaColors {
        RGBaColor BLACK = new RGBaColor(0, 0 ,0 ,255);
        RGBaColor WHITE = new RGBaColor(255, 255, 255, 255);
    }

    public interface CColors {

    }
}
