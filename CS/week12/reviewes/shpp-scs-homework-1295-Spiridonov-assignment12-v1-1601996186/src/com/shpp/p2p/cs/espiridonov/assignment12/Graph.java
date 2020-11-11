package com.shpp.p2p.cs.espiridonov.assignment12;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * class Graph.
 * Builds a graph based on an incoming array of image pixels that are not the background.
 */
public class Graph {

    private Color[][] colors;
    private Color background;
    private int width;
    private int height;

    private Map<Vertex, ArrayList<Vertex>> graph;
    private int totalVertexes;
    private int x;
    private int y;

    Graph(ImageData imageData) {
        colors = imageData.getColorPixel();
        background = imageData.getBackgroundColor();
        width = imageData.getWidth();
        height = imageData.getHeight();
        graph = new LinkedHashMap<>();
        graph();
    }

    /**
     * Each pixel of the image is checked to see if the current pixel color is the background.
     * If a pixel is not a background, all its eight point neighbors are checked for the same match.
     * @return Map<Vertex,ArrayList<Vertex>
     */
    public Map<Vertex, ArrayList<Vertex>> graph() {

        for (int x = 0; x < colors.length; x++) {
            for (int y = 0; y < colors[0].length; y++) {

                if (!colors[x][y].equals(background)) {

                    ArrayList<Vertex> links = new ArrayList<>();
                    this.x = x;
                    this.y = y;

                    //East pixel.
                    if(hasRightPixel() && isNotBackground(rightPixel(),y)){
                        addNeighbor(links,rightPixel(),y);
                    }
                    //West pixel.
                    if(hasLeftPixel() && isNotBackground(leftPixel(),y)){
                        addNeighbor(links,leftPixel(),y);
                    }
                    //South pixel.
                    if(hasDownPixel() && isNotBackground(x,downPixel())){
                        addNeighbor(links,x,downPixel());
                    }
                    // North pixel.
                    if(hasUpPixel() && isNotBackground(x,upPixel())){
                        addNeighbor(links,x,upPixel());
                    }
                    //North-East pixel.
                    if(hasUpPixel() && hasRightPixel() && isNotBackground(rightPixel(),upPixel())){
                        addNeighbor(links,rightPixel(),upPixel());
                    }
                    //North-West pixel.
                    if(hasUpPixel() && hasLeftPixel() && isNotBackground(leftPixel(),upPixel())){
                        addNeighbor(links,leftPixel(),upPixel());
                    }
                    //South-East pixel.
                    if(hasDownPixel() && hasRightPixel() && isNotBackground(rightPixel(),downPixel())){
                        addNeighbor(links,rightPixel(),downPixel());
                    }
                    //South-West pixel.
                    if(hasDownPixel() && hasLeftPixel() && isNotBackground(leftPixel(),downPixel())){
                        addNeighbor(links,leftPixel(),downPixel());
                    }
                    //Add initial pixel as a key.
                    if (!links.isEmpty()) {
                        graph.put(new Vertex(new Point(x, y)), links);
                    }
                }
            }
        }
        totalVertexes = graph.size();
        return graph;
    }

    private void addNeighbor(ArrayList<Vertex> neighbors, int x, int y){
        Vertex vertex = new Vertex(new Point(x,y));
        neighbors.add(vertex);
    }

    private boolean isNotBackground(int x, int y){ return !colors[x][y].equals(background); }

    private int rightPixel(){ return this.x + 1; }

    private int leftPixel(){ return this.x - 1; }

    private int downPixel(){ return this.y + 1; }

    private int upPixel(){ return this.y - 1; }

    private boolean hasRightPixel() { return rightPixel() < width; }

    private boolean hasLeftPixel() { return leftPixel() >= 0; }

    private boolean hasDownPixel() { return downPixel() < height; }

    private boolean hasUpPixel() { return upPixel() >= 0; }

    public Map<Vertex, ArrayList<Vertex>> getGraph() { return graph; }

    public int getTotalVertexes() { return totalVertexes; }
}
