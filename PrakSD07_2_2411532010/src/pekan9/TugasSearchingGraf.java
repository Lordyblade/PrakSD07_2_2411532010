package pekan9;

// NAMA : IBRAHIM MOUSA DHANI
// NIM  : 2411532010

import java.util.*;

public class TugasSearchingGraf {

    private Map<String, List<String>> graph;

    public TugasSearchingGraf() {
        graph = new HashMap<>();
        addNode("A");
        addNode("B");
        addNode("C");
        addNode("D");
        addNode("E");
        addNode("F");
        addNode("G");
        addNode("H");

        addEdge("A", "B");
        addEdge("A", "C");
        addEdge("B", "D");
        addEdge("C", "D");
        addEdge("C", "E");
        addEdge("D", "F");
        addEdge("E", "H");
        addEdge("E", "F");
        addEdge("F", "G");
        addEdge("H", "G");
    }

    public void addNode(String node) {
        graph.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String source, String destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public void search(String startNode, String goalNode) {
        System.out.println("Nama: IBRAHIM MOUSA DHANI");
        System.out.println("NIM: 2411532010\n");
        System.out.println("Node awal: " + startNode);
        System.out.println("Node tujuan: " + goalNode);

        Set<String> visited = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();
        Stack<String> stack = new Stack<>();
        String foundGoalNode = null;
        int step = 1;
        String algorithmType = "DFS\n";

        System.out.println("Algoritma: " + algorithmType);

        stack.push(startNode);
        parentMap.put(startNode, null);
        while (!stack.isEmpty()) {
            String currentNode = stack.pop();
            if (visited.contains(currentNode)) {
                continue;
            }
            visited.add(currentNode);
            System.out.println("Langkah " + step++ + ": Kunjungi " + currentNode);
            if (currentNode.equals(goalNode)) {
                foundGoalNode = currentNode;
                break;
            }
            List<String> neighbors = new ArrayList<>(graph.get(currentNode));
            Collections.reverse(neighbors);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    if (!parentMap.containsKey(neighbor)) {
                         parentMap.put(neighbor, currentNode);
                    }
                }
            }
        }
        if (foundGoalNode != null) {
            System.out.println("\nTujuan " + goalNode + " ditemukan");
            String route = buatRute(parentMap, startNode, goalNode);
            System.out.println("\nRute: " + route);
        } else {
            System.out.println("Tujuan " + goalNode + " tidak ditemukan");
        }
    }
    private String buatRute(Map<String, String> parentMap, String startNode, String goalNode) {
        LinkedList<String> path = new LinkedList<>();
        String current = goalNode;
        while (current != null) {
            path.addFirst(current);
            current = parentMap.get(current);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TugasSearchingGraf graphSearch = new TugasSearchingGraf();
        graphSearch.search("A", "G");
    }
}