package io.hari.problemsolving2021.graph;

import lombok.Getter;

import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * @Author Hariom Yadav
 * @create 08-03-2021
 */
@Getter
class Graph {
    int nodeSize;
    LinkedList<Integer>[] linkedLists = new LinkedList[4];

    public Graph(int nodeSize) {
        this.nodeSize = nodeSize;
        this.linkedLists = new LinkedList[nodeSize];
        for (int i = 0; i < nodeSize; i++) { // allocate space for each node
            linkedLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(final int source, final int destination) {
        linkedLists[source].add(destination);
    }


    public void dfs(final int startNode) {
        boolean[] visited = new boolean[nodeSize];//if we take Boolean then all values will be null
        for (boolean b : visited) {
            System.out.println("b = " + b);//we will get false, since this is primitive type
        }
//        Boolean[] visited2 = new Boolean[nodeSize];
//        for (Boolean b : visited2) {
//            System.out.println("b = " + b);//we will get null, this is non primitive type
//        }
        dfsUtil(startNode, visited);
        System.out.println();
    }

    private void dfsUtil(final int currNode, final boolean[] visited) {
        if (currNode < 0 || currNode > nodeSize) return; //null check, valid invalid check

        visited[currNode] = true;
        System.out.print(currNode+" ");

        //get all connected nodes with current start node
        final LinkedList<Integer> linkedList = linkedLists[currNode];
        for (Integer node : linkedList) {
            if (visited[node] == false) {
                dfsUtil(node, visited);
            }
        }
    }
}
public class GraphDfsDirected {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);

        final LinkedList<Integer>[] linkedLists = graph.getLinkedLists();
        Stream.of(linkedLists).forEach(i -> {
            final LinkedList<Integer> i1 = i;
            System.out.println("i1 = " + i1);
        });

        graph.dfs(0);
    }
}
