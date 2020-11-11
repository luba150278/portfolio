package com.shpp.p2p.cs.sserheiev.assignment12.graph;

import java.awt.*;
import java.util.Objects;

/**
 * Vertex of graph.
 */
public class Vertex {
    /**
     * Position in image matrix[][]. 'x' is 'j', 'y' is 'i'.
     */
    private Point data;
    /**
     * Marker for DFS.
     */
    private boolean isPassed = false;
    private boolean isSilhouettes = false;

    public Vertex (int x, int y) {
        data = new Point(x, y);
    }

    public Vertex (int x, int y, boolean isSilhouettes) {
        data = new Point(x, y);
        this.isSilhouettes = isSilhouettes;
    }

    public void setPassed (boolean bool) {
        isPassed = bool;
    }

    public boolean isPassed () {
        return isPassed;
    }

    public void setSilhouettes (boolean bool) {
        isSilhouettes = bool;
    }

    public boolean isSilhouettes() {
        return isSilhouettes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return  isSilhouettes == vertex.isSilhouettes &&
                Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, isSilhouettes);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", isSilhouettes=" + isSilhouettes +
                '}';
    }
}
