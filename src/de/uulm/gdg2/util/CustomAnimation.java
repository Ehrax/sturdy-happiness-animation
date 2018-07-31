package de.uulm.gdg2.util;

import de.looksgood.ani.easing.Easing;

public class CustomAnimation implements Comparable<CustomAnimation> {

    public float start;
    public float end;
    public float duration;
    public float value;

    public String params;
    public Easing mode;

    public CustomAnimation(float start, float end, float duration, float value, String params, Easing mode) {

        this.duration = duration;
        this.start = start;
        this.end = end;
        this.value = value;
        this.params = params;
        this.mode = mode;
    }

    @Override
    public int compareTo(CustomAnimation o) {

        if(this.start < o.start) {
            return -1;
        } else if (this.start > o.start){
            return 1;
        }

        return 0;
    }
}
