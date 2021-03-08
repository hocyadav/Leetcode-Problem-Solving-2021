package io.hari.problemsolving2021.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 08-03-2021
 */
class GraphNode {
    int nodeSize;
    LinkedList<Integer>[] adjList;

    public GraphNode(int nodeSize) {
        this.nodeSize = nodeSize;
        this.adjList = new LinkedList[nodeSize];
        for (int i = 0; i < nodeSize; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        this.adjList[source].add(destination);
        this.adjList[destination].add(source);
    }

    public void printEdge() {
        //m1
        for (List<Integer> list : this.adjList) {
            System.out.println("list = " + list);
        }
        //m2
        for (int i = 0; i < nodeSize; i++) {
            final LinkedList<Integer> integers = this.adjList[i];
            System.out.print(i + " -> ");
            for (Integer source : integers) {
                System.out.print(source+" ");
            }
            System.out.println();
        }
    }
}

public class GraphBiDirectional {

    public static void main(String[] args) {
        GraphNode graph = new GraphNode(4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.printEdge();
    }
}
