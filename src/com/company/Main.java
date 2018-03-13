package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // Task

        //        Implement a version of Dijkstra's algorithm that computes a shortest path from a start vertex to an end vertex in a directed graph.
        //        Run your program with the following directed graph to find the shortest path from vertex   a   to vertex   e.
        //                Show the output of your program.

        Map<String, Integer> v = new HashMap<String, Integer>();
        List<Edge> e = new LinkedList();

        v.put("a", 0);
        v.put("b", -1);
        v.put("c", -1);
        v.put("d", -1);
        v.put("e", -1);
        v.put("f", -1);

        e.add(new Edge("a", "b", 7));
        e.add(new Edge("a", "c", 9));
        e.add(new Edge("a", "f", 14));
        e.add(new Edge("b", "c", 10));
        e.add(new Edge("b", "d", 15));
        e.add(new Edge("c", "d", 11));
        e.add(new Edge("c", "f", 2));
        e.add(new Edge("d", "e", 6));
        e.add(new Edge("e", "f", 9));


        dijkstra(v, e, "e");


    }

    static void dijkstra(Map<String, Integer> v, List<Edge> e, String endVertex) {

        Iterator<Map.Entry<String, Integer>> it = v.entrySet().iterator();

        while (it.hasNext()) {

            Map.Entry<String, Integer> entry = it.next();


            if (entry.getKey() != endVertex ) {
                for (Edge o : e) {
                    if (o.getStart().equals(entry.getKey())) {
                        if (v.get(o.getEnd()) < 0) {
                            v.put(o.getEnd(), entry.getValue() + o.getValue());
                        } else if ((entry.getValue() + o.getValue()) < v.get(o.getEnd())) {
                            v.put(o.getEnd(), entry.getValue() + o.getValue());
                        }
                    }

                }
            } else {
                System.out.println("Solution: it takes " + v.get(endVertex) + " steps to take the shortest path from a to " + endVertex);

            }

        }
    }
}

class Edge {
    String end;
    String start;
    int value;

    public Edge(String start, String end, int value) {
        this.end = end;
        this.start = start;
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
