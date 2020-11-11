package com.shpp.p2p.cs.ashepel.assignment9;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Caterpillar extends WindowProgram {

    /* Number of segments that caterpillar consists of */
    private static final int SEGMENTS_NUM = 8;

    /* The diameter of the caterpillar's segments */
    private static final double DIAMETER = 100;

    /* The colors of the caterpillar's segments */
    public static final Color FILL_COLOR = Color.GREEN;
    public static final Color EDGE_COLOR = Color.BLACK;

    /**
     * Draws a caterpillar.
     */
    public void run() {
        drawCaterpillar();
    }

    /**
     * Draws N caterpillar's segments, where N = SEGMENTS_NUM.
     */
    private void drawCaterpillar() {
        for (int i = 0; i < SEGMENTS_NUM; i++) {
            double x = DIAMETER / 2 * i;
            double y = yOffset(i);
            drawCaterpillarSegment(x, y);
        }
    }

    /**
     * Returns y-offset for current caterpillar's segment.
     *
     * Each 2nd segment will have y-offset that equals DIAMETER / 2.
     * All another segments will not have the offset.
     *
     * @param segmentNum The number of segment.
     *
     * @return The y-offset.
     */
    private double yOffset(int segmentNum) {
        if (segmentNum % 2 == 0)
            return DIAMETER / 2;
        else
            return 0;
    }

    /**
     * Draws one caterpillar's segment.
     *
     * @param x The x-offset of the segment.
     * @param y The y-offset of the segment.
     */
    private void drawCaterpillarSegment(double x, double y) {
        GOval segment = new GOval(x, y, DIAMETER, DIAMETER);
        segment.setFilled(true);
        segment.setFillColor(FILL_COLOR);
        segment.setColor(EDGE_COLOR);
        add(segment);
    }

}

