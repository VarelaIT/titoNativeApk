package com.varelait.titonativeapk.logic;

import com.varelait.titonativeapk.entities.FrameDiff;
import com.varelait.titonativeapk.entities.GlassDiff;
import com.varelait.titonativeapk.entities.PanelDiff;

public class Measures implements IMeasures {
    private FrameDiff frameDiff = new FrameDiff();
    private PanelDiff panelDiff = new PanelDiff();
    private GlassDiff glassDiff = new GlassDiff();
    private final Float base;
    private Float heigth;
    private Float panels;

    public Measures(float base, float heigth, float panels) {
        this.base = base;
        this.heigth = heigth;
        this.panels = panels;
    }

    public Float getRails() {
        return this.base - this.frameDiff.base;
    }

    public Float getLaterals() {
        return this.heigth - this.frameDiff.heigth;
    }

    public Float getAlfaisal() {
        return (this.base - this.panelDiff.alfaisal * this.panels) / this.panels;
    }

    public Float getJambas() {
        return this.heigth - this.panelDiff.jambas;
    }

    public Float getGlassBase() {
        return (
            (this.getRails() - this.glassDiff.base - this.glassDiff.base * this.panels)
            / this.panels
        );
    }

    public Float getGlassHeigth() {
        return this.heigth - this.glassDiff.heigth;
    }
}
