package com.shpp.p2p.cs.espiridonov.assignment12;

import java.awt.*;
import java.util.Objects;

public class Vertex {

    public Point data; // Tag (example - Point(1,2))
    public boolean wasVisited;

    Vertex(Point data)
    {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
