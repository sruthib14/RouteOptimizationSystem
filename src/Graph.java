import java.util.*;

public class Graph {

    private Map<String, List<Edge>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addCity(String city) {
        graph.putIfAbsent(city, new ArrayList<>());
    }

    public void addRoad(String source, String destination, int distance) {

        graph.get(source).add(new Edge(destination, distance));
        graph.get(destination).add(new Edge(source, distance));
    }

    public Map<String, List<Edge>> getGraph() {
        return graph;
    }
    public boolean cityExists(String city) {
    return graph.containsKey(city);
}
}