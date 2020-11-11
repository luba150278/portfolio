package com.shpp.p2p.cs.sserheiev.assignment12;

import com.shpp.p2p.cs.sserheiev.assignment12.oldImplementation.graph.Graph;
import com.shpp.p2p.cs.sserheiev.assignment12.oldImplementation.graph.Vertex;

import java.util.ArrayList;

/**
 * This class fill graph-image.
 * Graph-image - it's representation of image as a graph.
 * All silhouette pixels are graph vertices.
 */
public class GraphFiller {

    /**
     * @param graph graph representation of image.
     * @param booleanMatrix boolean matrix of image. true - silhouette, false - background.
     * @return matrix [][] of vertices.
     */
    public static Vertex[][] fillGraph(Graph graph, boolean[][] booleanMatrix) {
        int width = booleanMatrix[0].length;
        int height = booleanMatrix.length;
        Vertex[][] verticesMatrix = new Vertex[height][width];

        /*
            Build vertices matrix.
         */
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (booleanMatrix[i][j]) {
                    verticesMatrix[i][j] = new Vertex(j, i, true);
                } else {
                    verticesMatrix[i][j] = new Vertex(j, i);
                }
            }
        }

        /*
            If boolean[i][j] = true - it's a silhouette.
            So, get vertex from verticesMatrix[i][j], add all neighbor-vertices and put it in graph.
         */
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (booleanMatrix[i][j]) {
                    Vertex currentVertex;
                    currentVertex = verticesMatrix[i][j];
                    ArrayList<Vertex> neighborList = new ArrayList<>();
                    if (i == 0 && j == 0) { //top-left
                        if (verticesMatrix[i][j + 1].isSilhouettes()) { //right
                            neighborList.add(verticesMatrix[i][j + 1]);
                        }
                        if (verticesMatrix[i + 1][j + 1].isSilhouettes()) { //bot-right
                            neighborList.add(verticesMatrix[i + 1][j + 1]);
                        }
                        if (verticesMatrix[i + 1][j].isSilhouettes()) { //bot
                            neighborList.add(verticesMatrix[i + 1][j]);
                        }
                    } else if (i == 0 && j == width - 1) { //top-right
                        if (verticesMatrix[i][j - 1].isSilhouettes()) { //left
                            neighborList.add(verticesMatrix[i][j - 1]);
                        }
                        if (verticesMatrix[i + 1][j - 1].isSilhouettes()) { //bot-left
                            neighborList.add(verticesMatrix[i + 1][j - 1]);
                        }
                        if (verticesMatrix[i + 1][j].isSilhouettes()) { //bot
                            neighborList.add(verticesMatrix[i + 1][j]);
                        }
                    } else if (i == height - 1 && j == 0) { //bottom-left
                        if (verticesMatrix[i][j + 1].isSilhouettes()) { //right
                            neighborList.add(verticesMatrix[i][j + 1]);
                        }
                    } else if (i == height - 1 && j == width - 1) { //bottom-right
                        if (verticesMatrix[i][j - 1].isSilhouettes()) { //left
                            neighborList.add(verticesMatrix[i][j - 1]);
                        }
                    } else if (i == 0) { //top-line
                        if (verticesMatrix[i][j - 1].isSilhouettes()) { //left
                            neighborList.add(verticesMatrix[i][j - 1]);
                        }
                        if (verticesMatrix[i][j + 1].isSilhouettes()) { //right
                            neighborList.add(verticesMatrix[i][j + 1]);
                        }
                        if (verticesMatrix[i + 1][j - 1].isSilhouettes()) { //bot-left
                            neighborList.add(verticesMatrix[i + 1][j - 1]);
                        }
                        if (verticesMatrix[i + 1][j].isSilhouettes()) { //bot
                            neighborList.add(verticesMatrix[i + 1][j]);
                        }
                        if (verticesMatrix[i + 1][j + 1].isSilhouettes()) { //bot-right
                            neighborList.add(verticesMatrix[i + 1][j + 1]);
                        }
                    } else if (j == 0) { //left-line
                        if (verticesMatrix[i + 1][j].isSilhouettes()) {  //bot
                            neighborList.add(verticesMatrix[i + 1][j]);
                        }
                        if (verticesMatrix[i][j + 1].isSilhouettes()) { //right
                            neighborList.add(verticesMatrix[i][j + 1]);
                        }
                    } else if (i == height - 1) { //bottom-line
                        if (verticesMatrix[i][j - 1].isSilhouettes()) { //left
                            neighborList.add(verticesMatrix[i][j - 1]);
                        }
                        if (verticesMatrix[i][j + 1].isSilhouettes()) { //right
                            neighborList.add(verticesMatrix[i][j + 1]);
                        }
                    } else if (j == width - 1) { //right-line
                        if (verticesMatrix[i + 1][j].isSilhouettes()) { //bot
                            neighborList.add(verticesMatrix[i + 1][j]);
                        }
                        if (verticesMatrix[i][j - 1].isSilhouettes()) { //left
                            neighborList.add(verticesMatrix[i][j - 1]);
                        }
                        if (verticesMatrix[i + 1][j - 1].isSilhouettes()) { //bot-left
                            neighborList.add(verticesMatrix[i + 1][j - 1]);
                        }
                    } else { //else cells
                        if (verticesMatrix[i][j + 1].isSilhouettes()) { //right
                            neighborList.add(verticesMatrix[i][j + 1]);
                        }
                        if (verticesMatrix[i + 1][j + 1].isSilhouettes()) { //bot-right
                            neighborList.add(verticesMatrix[i + 1][j + 1]);
                        }
                        if (verticesMatrix[i + 1][j].isSilhouettes()) { //bot
                            neighborList.add(verticesMatrix[i + 1][j]);
                        }
                        if (verticesMatrix[i + 1][j - 1].isSilhouettes()) { //bot-left
                            neighborList.add(verticesMatrix[i + 1][j - 1]);
                        }
                        if (verticesMatrix[i][j - 1].isSilhouettes()) { //left
                            neighborList.add(verticesMatrix[i][j - 1]);
                        }
                    }

                    graph.putVertex(currentVertex, neighborList);
                }
            }
        }
        return verticesMatrix;
    }

}
