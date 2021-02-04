package lecture17.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GraphApp {

    // однонаправленный граф
    static UnidirectionalGraph graph;
    // пройденные вершины
    static Map<String, Marker> visitedMap = new LinkedHashMap<>();
    // счетчик
    static int counter = 1;

    public static void main(String[] args) {
        graph = new UnidirectionalGraph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "E");
        graph.addEdge("B", "C");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "F");
        graph.addEdge("F", "I");

        graph.addEdge("D", "G");
        graph.addEdge("D", "H");
        graph.addEdge("G", "H");
        Map<String, List<String>> vm = graph.getVertexMap();

        List<String> vertexList = new ArrayList<>(vm.size());
        vertexList.addAll(vm.keySet());
        Collections.sort(vertexList);

        for (String v : vertexList) {
            dfs(v);
        }

        for (Map.Entry<String, Marker> entry : visitedMap.entrySet()) {
            Marker m = entry.getValue();
            System.out.format("%1$s : (%2$d, %3$d)\n", entry.getKey(), m.pre, m.post);
        }
    }

    static void dfs(String vertexName) {
        if (visitedMap.containsKey(vertexName)) {
            return;
        }

        visitedMap.put(vertexName, new Marker(counter, -1));
        counter++;

        Map<String, List<String>> vm = graph.getVertexMap();
        List<String> adjacentVertices = vm.get(vertexName);

        for (String v : adjacentVertices) {
            if (!visitedMap.containsKey(v)) {
                dfs(v);
            }
        }

        Marker m = visitedMap.get(vertexName);
        m.post = counter++;
    }
}

