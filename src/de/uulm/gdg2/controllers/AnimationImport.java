package de.uulm.gdg2.controllers;

import de.looksgood.ani.AniConstants;
import de.looksgood.ani.easing.Easing;
import de.uulm.gdg2.animations.ClickAnimation;
import de.uulm.gdg2.animations.CustomAnimation;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

public abstract class AnimationImport {

    public static ArrayList<CustomAnimation> importAnimation(PApplet canvas, String filePath, String type) {

        ArrayList<CustomAnimation> anisAnimations = new ArrayList<>();
        JSONObject json = canvas.loadJSONObject(filePath);
        JSONArray array = json.getJSONArray(type);

        for (int i = 0; i < array.size(); i++) {
            JSONObject o = array.getJSONObject(i);
            CustomAnimation custAnim;

            float start = o.getFloat("start");
            float end = o.getFloat("end");
            float duration = o.getFloat("duration");
            float value = o.getFloat("value");

            String easingString = o.getString("easing");
            Easing easing = determineEasing(easingString);
            if (o.hasKey("delay")) {
                float delay = o.getFloat("delay");
                custAnim = new CustomAnimation(start, end, duration, value, delay, type, easing);
            } else {
                custAnim = new CustomAnimation(start, end, duration, value, type, easing);
            }

            anisAnimations.add(custAnim);
        }

        return anisAnimations;
    }

    public static ArrayList<ClickAnimation> importClickAnimation(PApplet canvas, String filePath, String mode) {

        ArrayList<ClickAnimation>  animations = new ArrayList<>();
        JSONObject json =  canvas.loadJSONObject(filePath);
        JSONArray jsonArray = json.getJSONArray(mode);

        for(int i = 0; i < jsonArray.size(); i++) {
            JSONObject o = jsonArray.getJSONObject(i);
            ClickAnimation clickAnimation = new ClickAnimation();

            clickAnimation.start = o.getFloat("start");
            clickAnimation.end = o.getFloat("end");
            animations.add(clickAnimation);
        }
        return animations;
    }

    private static Easing determineEasing(String ease) {
        Easing e;

        switch (ease) {
            case "sine_in":
                e = AniConstants.SINE_IN;
                break;
            case "sine_out":
                e = AniConstants.SINE_OUT;
                break;
            case "sine_in_out":
                e = AniConstants.SINE_IN_OUT;
                break;
            case "cubic_in":
                e = AniConstants.CUBIC_IN;
                break;
            case "cubic_in_out":
                e = AniConstants.CUBIC_IN_OUT;
            break;
            case "cubic_out":
                e = AniConstants.CUBIC_OUT;
                break;
            case "bounce_in":
                e = AniConstants.BOUNCE_IN;
                break;
            case "bounce_out":
                e = AniConstants.BOUNCE_OUT;
                break;
            case "bounce_in_out":
                e = AniConstants.BOUNCE_IN_OUT;
                break;
            case "elastic_out":
                e = AniConstants.ELASTIC_OUT;
                break;
            case "elastic_in_out":
                e = AniConstants.ELASTIC_IN_OUT;
                break;
            default:
                e = AniConstants.LINEAR;
                break;
        }
        return e;
    }
}
