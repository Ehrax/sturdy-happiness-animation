package de.uulm.gdg2.util;

public class RGBaColor {
    public int v1;
    public int v2;
    public int v3;
    public int a;

    public RGBaColor(int v1, int v2, int v3) {

        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.a = a;
    }

    public RGBaColor copy() {
        return new RGBaColor(v1,v2, v3);
    }
}
