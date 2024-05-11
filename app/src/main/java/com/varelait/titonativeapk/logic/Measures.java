package com.varelait.titonativeapk.logic;

import com.varelait.titonativeapk.entities.FrameDiff;
import com.varelait.titonativeapk.entities.GlassDiff;
import com.varelait.titonativeapk.entities.PanelDiff;

public class Measures implements IMeasures {
    private final FrameDiff frameDiff = new FrameDiff();
    private final PanelDiff panelDiff = new PanelDiff();
    private final GlassDiff glassDiff = new GlassDiff();
    private final Float base;
    private final Float height;
    private final Float panels;

    public Measures(float base, float height, float panels) {
        this.base = base;
        this.height = height;
        this.panels = panels;
    }

    public Float getRails() {
        return this.base - this.frameDiff.base;
    }

    public Float getLaterals() {
        return this.height - this.frameDiff.height;
    }

    public Float getAlfaisal() {
        return (this.base - this.panelDiff.alfaisal * this.panels) / this.panels;
    }

    public Float getJambas() {
        return this.height - this.panelDiff.jambas;
    }

    public Float getGlassBase() {
        return (this.getRails() - glassDiff.base - (glassDiff.base * this.panels)) / this.panels;
    }

    public Float getGlassHeigth() {
        return this.height - this.glassDiff.heigth;
    }
}
