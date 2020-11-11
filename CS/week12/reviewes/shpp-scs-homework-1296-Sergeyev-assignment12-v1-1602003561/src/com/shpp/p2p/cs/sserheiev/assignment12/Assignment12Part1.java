package com.shpp.p2p.cs.sserheiev.assignment12;

import com.shpp.p2p.cs.sserheiev.assignment12.oldImplementation.graph.Graph;
import com.shpp.p2p.cs.sserheiev.assignment12.oldImplementation.graph.Vertex;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Main class with depp-first search realisation.
 */
public class Assignment12Part1 {
    private static final String FILE_PATH = "resources/assignment12/";
    /*
        The biggest graph is taken as a standard. Value of filter show how much vertices
        others sub-graphs should have to be count as a silhouette.
     */
    private static final double SILHOUETTE_FILTER = 0.5;

    private static Graph graph = new Graph();

    public static void main(String[] args) {
        boolean[][] booleanMatrix; //in this matrix true - silhouette, false - background

        if (args.length != 0) {
            booleanMatrix = readImageAndCreateBooleanMatrix(args[0]);
        }
        else {
            booleanMatrix = readImageAndCreateBooleanMatrix("test.jpg");
        }

        Vertex[][] verticesMatrix = GraphFiller.fillGraph(graph, booleanMatrix);

        int width = booleanMatrix[0].length;
        int height = booleanMatrix.length;

        ArrayList<Graph> subGraphs = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (booleanMatrix[i][j]) {
                    if (!verticesMatrix[i][j].isPassed()) {
                        /*
                            If vertex is silhouette, then DFS will start from this vertex.
                            While proceed, DFS will add vertices into Set of sub-graph.
                            Each sub-graph is a one silhouette.
                         */
                        HashSet<Vertex> verticesOfSubGraph = new HashSet<>();

                        DFS(verticesMatrix[i][j], verticesOfSubGraph);

                        Graph subGraph = new Graph();
                        for (Vertex vertex : verticesOfSubGraph) {
                            subGraph.putVertex(vertex, null);
                        }
                        subGraphs.add(subGraph);
                    }
                }
            }
        }

        /*
            Trash-filtration.
         */
        int maxGraphVertices = 0;
        for (Graph graph : subGraphs) {
            if (graph.getAdjacencyMap().keySet().size() > maxGraphVertices)
                maxGraphVertices = graph.getAdjacencyMap().keySet().size();
        }
        int finalMaxGraphVertices = maxGraphVertices; //temporary variable to use in subGraphs.removeIf statement.
        subGraphs.removeIf(graph ->
                graph.getAdjacencyMap().keySet().size() < (finalMaxGraphVertices * SILHOUETTE_FILTER));

        System.out.println("Silhouettes: " + subGraphs.size());
    }


    /**
     * Implement of deep-first search.
     * @param vertex current vertex which is on spot.
     * @param vertices Set of vertices of sub-graph.
     */
    private static void DFS(Vertex vertex, HashSet<Vertex> vertices) {
        Map<Vertex, List<Vertex>> adjacencyList = graph.getAdjacencyMap();
        Stack<Vertex> stackVertex = new Stack<>();
        if (!vertex.isPassed()) {
            vertex.setPassed(true);
            vertices.add(vertex);
            for (Vertex adjVertex : adjacencyList.get(vertex)) {
                if (!adjVertex.isPassed() && !stackVertex.contains(adjVertex)) {
                    stackVertex.push(adjVertex);
                }
            }
            while (stackVertex.size() != 0) {
                if (!stackVertex.peek().isPassed()) {
                    DFS(stackVertex.pop(), vertices);
                } else {
                    stackVertex.pop();
                }
            }
        }
    }

    /**
     * Preprocessing method. Read image, convert to black and white.
     * Create boolean matrix, where true - silhouette, false - background.
     * @param fileName image.
     */
    private static boolean[][] readImageAndCreateBooleanMatrix (String fileName) {
        Color[][] pixelMatrix = ImageWorker.readImage(FILE_PATH + fileName);
        int[][] luminance = ImageWorker.getLuminanceMatrix(pixelMatrix);
        int[] histogram = HistogramWorker.createHistogram(luminance);
        int median = HistogramWorker.getMedianFromHistogram(histogram);
        boolean[][] booleanMatrix = BooleanWorker.getBooleanMatrix(luminance, median);

        return booleanMatrix;
    }
}