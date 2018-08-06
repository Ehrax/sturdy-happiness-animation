package de.uulm.gdg2.util;

public class States {
    public enum AnimationStates {
        RUNNING, PAUSED, MAIN, OPTION, HELP
    }

    public enum DevelopmentStates {
        DEBUG, DEPLOY
    }

    // TODO: pick up some more colors for a color change
    public interface RGBaColors {
        RGBaColor BLACK = new RGBaColor(0, 0 ,0 ,255);
        RGBaColor WHITE = new RGBaColor(255, 255, 255, 255);
    }

    public interface CColors {

    }
}
