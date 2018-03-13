package com.company;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Task

        //        Implement a version of Dijkstra's algorithm that computes a shortest path from a start vertex to an end vertex in a directed graph.
        //        Run your program with the following directed graph to find the shortest path from vertex   a   to vertex   e.
        //                Show the output of your program.


        //        Mark all nodes unvisited. Create a set of all the unvisited nodes called the unvisited set.
        //
        //        Assign to every node a tentative distance value: set it to zero for our initial node and to infinity for all other nodes.
        // Set the initial node as current.
        //
        //        For the current node, consider all of its unvisited neighbors and calculate their tentative distances through the current node.
        // Compare the newly calculated tentative distance to the current assigned value and assign the smaller one.
        // For example, if the current node A is marked with a distance of 6, and the edge connecting it with a neighbor B has length 2,
        // then the distance to B through A will be 6 + 2 = 8. If B was previously marked with a distance greater than 8 then change it to 8.
        // Otherwise, keep the current value.
        //
        //                When we are done considering all of the neighbors of the current node, mark the current node as visited and remove it from
        // the unvisited set. A visited node will never be checked again.
        //        If the destination node has been marked visited (when planning a route between two specific nodes) or if the smallest tentative
        // distance among the nodes in the unvisited set is infinity (when planning a complete traversal; occurs when there is no connection between
        // the initial node and remaining unvisited nodes), then stop. The algorithm has finished.
        //        Otherwise, select the unvisited node that is marked with the smallest tentative distance, set it as the new "current node", and go
        // back to step 3.

//        List<Vertex> v = new LinkedList();
        Map<String, Integer> v = new HashMap<String, Integer>();
        List<Edge> e = new LinkedList();

            v.put("a", 0);
            v.put("b", -1);
            v.put("c", -1);
            v.put("d", -1);
            v.put("e", -1);
            v.put("f", -1);

//        v.add(new Vertex(0, "a"));
//        v.add(new Vertex(-1, "b"));
//        v.add(new Vertex(-1, "c"));
//        v.add(new Vertex(-1, "d"));
//        v.add(new Vertex(-1, "e"));
//        v.add(new Vertex(-1, "f"));

        e.add(new Edge("a", "b", 7));
        e.add(new Edge("a", "c", 9));
        e.add(new Edge("a", "f", 14));
        e.add(new Edge("b", "c", 10));
        e.add(new Edge("b", "d", 15));
        e.add(new Edge("c", "d", 11));
        e.add(new Edge("c", "f", 2));
        e.add(new Edge("d", "e", 6));
        e.add(new Edge("e", "f", 9));



        dijkstra(v,e);


    }
    static void dijkstra(Map<String, Integer> v, List<Edge> e) {

        Iterator<Map.Entry<String, Integer>> it = v.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();

            if (entry.getKey() != "e") {
                for (Edge o : e) {
                    if (o.getStart().equals(entry.getKey())) {
                        if (v.get(o.getEnd()) < 0) {
                            v.put(o.getEnd(), entry.getValue() + o.getValue());
                        } else if (/*iValue+o.value<=oEnd.value*/ (v.get(entry.getKey()) + o.getValue()) < v.get(o.getEnd())) {
                            // replace oEndValue in vMap
                            v.put(o.getEnd(), entry.getValue() + o.getValue());
                            System.out.println(entry.getKey() + "(" + v.get(entry.getKey()) + ")-" + o.getEnd() + "(" + v.get(o.getEnd()) + ")");
                        } else {
                            System.out.println("how'd i get here");
                        }
                    }

                }
                it.remove();
            } else {
                System.out.println("Solution: it takes " + v.get("e") + " steps to take the shortest path from a to e.");
            }
        }
    }
}
//class Vertex {
//    public Vertex(int value, String name) {
//        this.value = value;
//        this.name = name;
//    }
//
//    int value;
//    String name;
//    boolean visited = false;
//
//    public boolean isVisited() {
//        return visited;
//    }
//
//    public void setVisited(boolean visited) {
//        this.visited = visited;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }
//
//    public String getName() {
//        return name;
//    }
//}

class Edge {
    public Edge(String start, String end, int value) {
        this.end = end;
        this.start = start;
        this.value = value;
    }

    String end;
    String start;
    int value;

    public void setValue(int value) {
        this.value = value;
    }

    public String getEnd() {
        return end;
    }

    public String getStart() {
        return start;
    }

    public int getValue() {
        return value;
    }
}
