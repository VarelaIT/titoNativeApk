package com.varelait.titonativeapk.logic;

import com.varelait.titonativeapk.entities.FrameDiff;
import com.varelait.titonativeapk.entities.GlassDiff;
import com.varelait.titonativeapk.entities.PanelDiff;

public class Measures {
    private FrameDiff frameDiff = new FrameDiff();
    private PanelDiff panelDiff = new PanelDiff();
    private GlassDiff glassDiff = new GlassDiff();
    private final float base;
    private float heigth;
    private float panels;

    Measures(float base, float heigth, float panels) {
        this.base = base;
        this.heigth = heigth;
        this.panels = panels;
    }

    float getRails() {
        return this.base - this.frameDiff.base;
    }

    float getLaterals() {
        return this.heigth - this.frameDiff.heigth;
    }

    float getAlfaisal() {
        return (this.base - this.panelDiff.alfaisal * this.panels) / this.panels;
    }

    float getJambas() {
        return this.heigth - this.panelDiff.jambas;
    }

    float getGlassBase() {
        return (
            (this.getRails() - this.glassDiff.base - this.glassDiff.base * this.panels)
            / this.panels
        );
    }

    float getGlassHeigth() {
        return this.heigth - this.glassDiff.heigth;
    }
}
