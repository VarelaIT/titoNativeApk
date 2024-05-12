package com.varelait.titonativeapk;

import com.varelait.titonativeapk.entities.FrameDiff;
import com.varelait.titonativeapk.logic.IMeasures;
import com.varelait.titonativeapk.logic.Measures;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeasuresTests {

    @Test
    public void railsTest(){
        float base = 100f;
        float height = 100f;
        FrameDiff frameDiff = new FrameDiff();
        Float rails = base - frameDiff.base;
        IMeasures measures = new Measures(base, height, 2);

        assertNotNull(measures);
        assertEquals(rails.toString(), measures.getRails().toString());
    }

    @Test
    public void glassBaseTest(){
        float base = 100f;
        float height = 100f;
        Float expected = 48f;
        IMeasures measures = new Measures(base, height, 2);

        assertNotNull(measures);
        assertEquals(expected.toString(), measures.getGlassBase().toString());
    }

}
