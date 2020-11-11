package com.shpp.p2p.cs.espiridonov.assignment12;

import java.util.*;

/**
 * Class outputs to the console the number of silhouettes objects on image.
 */
public class Assignment12Part1 {
    private static String DEFAULT_IMAGE_NAME = "test";
    private static String DEFAULT_IMAGE_EXTENSION = ".jpg";
    private static int PERCENTAGE_NOISE = 3;//

    private static ImageData imageData;

    public static void main(String[] args) {

        if (isEmptyArguments(args)) {
            System.out.println("default picture 'test.jpg'");
            imageData = new ImageData("resource/images/" + DEFAULT_IMAGE_NAME + DEFAULT_IMAGE_EXTENSION);
        } else {
            imageData = new ImageData(args[0]);
        }

        DepthFirstSearch();
    }

    /**
     * Depth first search algorithm.
     * Based on stack collection.
     */
    private static void DepthFirstSearch() {

        Graph graph = new Graph(imageData); // create graph object.
        Map<Vertex, ArrayList<Vertex>> mapVertex = graph.getGraph(); // get map vertexes.
        int totalVertexes = graph.getTotalVertexes(); // get info about total vertexes on picture.
        Set<Vertex> visited = new LinkedHashSet<>(); //visited vertexes.
        int counterSilhouettes = 0;

        System.out.println("total vertexes - " + totalVertexes); // log info.

        for (Vertex entry : mapVertex.keySet()) {

            if (visited.contains(entry)) {// if vertex is visited continue to next not visited Vertex.
                continue;
            }

            Stack<Vertex> stack = new Stack<>(); //create stack
            stack.push(entry);//push first vertex
            int counterSolidVertexes = 0;
            while (!stack.isEmpty()) {
                Vertex element = stack.pop();
                if (!element.wasVisited) {
                    element.wasVisited = true;
                }

                ArrayList<Vertex> neighbours = mapVertex.get(element);
                for (Vertex n : neighbours) {
                    if (!visited.contains(n)) {
                        stack.add(n);
                        visited.add(n);
                        counterSolidVertexes++;
                    }
                }
            }

            if ((double) counterSolidVertexes / totalVertexes * 100 > PERCENTAGE_NOISE) {
                System.out.println("solid object contains (" + counterSolidVertexes + ") vertexes");// log info.
                counterSilhouettes++;
            } else {
                System.out.println("noise range is " + PERCENTAGE_NOISE + "%" + " (" + counterSolidVertexes + ")" + " vertexes");
            }

        }
        System.out.println("potential number of silhouettes on the picture is (" + counterSilhouettes + ")");
    }

    private static boolean isEmptyArguments(String[] args) {
        return args.length == 0;
    }
}
