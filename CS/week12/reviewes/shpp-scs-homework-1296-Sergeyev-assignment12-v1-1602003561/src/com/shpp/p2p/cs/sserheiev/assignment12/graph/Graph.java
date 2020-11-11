package com.shpp.p2p.cs.sserheiev.assignment12.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Graph representation of image.
 * Each vertices in Map <Vertex, List<Vertex>> are pixel of silhouette.
 * Graph is represented by adjacency list.
 */
public class Graph {
    /**
     *  adjacency list of graph.
     *  Key - vertex
     *  Value - list of neighbors, which are silhouette-pixels.
     */
    private Map<Vertex, List<Vertex>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void putVertex(Vertex vertex, List<Vertex> adjacencyList) {
        adjacencyMap.put(vertex, adjacencyList);
    }

    public Map<Vertex, List<Vertex>> getAdjacencyMap() {
        return adjacencyMap;
    }
}
