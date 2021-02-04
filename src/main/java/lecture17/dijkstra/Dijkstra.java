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
        Node nodeA = new Node("A");
        NODE_START = nodeA;
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        NODE_END = nodeF;
        Node nodeG = new Node("G");

        nodeA.addDestination(nodeB, 4);
        nodeA.addDestination(nodeC, 8);
        nodeA.addDestination(nodeD, 6);

        nodeB.addDestination(nodeG, 4);

        nodeC.addDestination(nodeF, 13);

        nodeD.addDestination(nodeE, 5);

        nodeE.addDestination(nodeF, 9);

        nodeG.addDestination(nodeF, 4);

        GRAPH = new Graph();

        GRAPH.addNode(nodeA);
        GRAPH.addNode(nodeB);
        GRAPH.addNode(nodeC);
        GRAPH.addNode(nodeD);
        GRAPH.addNode(nodeE);
        GRAPH.addNode(nodeF);
        GRAPH.addNode(nodeG);
    }

    public static void main(String[] args) {
        calculateShortestPathFromSource(GRAPH, NODE_START);

        System.out.println("Самый короткий путь от точки А в точку F = " + NODE_END.getDistance());
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
