import java.util.*;

public class Dijkstra {

    public static void shortestPath(Graph g, String start, String end) {

        Map<String, List<Edge>> graph = g.getGraph();

        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        for (String city : graph.keySet()) {
            distance.put(city, Integer.MAX_VALUE);
        }

        distance.put(start, 0);

        PriorityQueue<String> pq =
                new PriorityQueue<>(Comparator.comparingInt(distance::get));

        pq.add(start);

        while (!pq.isEmpty()) {

            String current = pq.poll();

            for (Edge edge : graph.get(current)) {

                int newDistance =
                        distance.get(current) + edge.distance;

                if (newDistance < distance.get(edge.destination)) {

                    distance.put(edge.destination, newDistance);

                    previous.put(edge.destination, current);

                    pq.add(edge.destination);
                }
            }
        }

        if (distance.get(end) == Integer.MAX_VALUE) {
            System.out.println("No route found!");
            return;
        }

        List<String> path = new ArrayList<>();

        for (String at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }

        Collections.reverse(path);

        System.out.println("\nShortest Route:");
        System.out.println(String.join(" -> ", path));

        System.out.println("Total Distance: "
                + distance.get(end) + " km");
    }
}
