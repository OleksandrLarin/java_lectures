package lecture17.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
    private static final Graph GRAPH;
    private static final Node NODE_START;
    private static final Node NODE_END;

    static {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        NODE_START = node1;
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        NODE_END = node5;

        node1.addDestination(node2, 10);
        node1.addDestination(node4, 30);
        node1.addDestination(node5, 100);

        node2.addDestination(node3, 50);

        node3.addDestination(node5, 10);

        node4.addDestination(node5, 60);
        node4.addDestination(node3, 20);
        GRAPH = new Graph();

        GRAPH.addNode(node1);
        GRAPH.addNode(node2);
        GRAPH.addNode(node3);
        GRAPH.addNode(node4);
        GRAPH.addNode(node5);
    }

    public static void main(String[] args) {
        calculateShortestPathFromSource(GRAPH, NODE_START);

        System.out.println("Самый короткий путь от точки 1 в точку " + NODE_END.getName() + " = " + NODE_END.getDistance());
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
