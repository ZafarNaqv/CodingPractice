import java.util.*;

public class GraphTraversals {
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    int vertexes;
    int[][] edges;

    public GraphTraversals(int vertexes,int[][] edges) {
        this.vertexes = vertexes;
        this.edges = edges;
        populateAdjacencyList();
    }

    private void populateAdjacencyList(){
        for(int i=0;i<vertexes;i++){
            adjacencyList.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int nodeA = edge[0];
            int nodeB = edge[1];

            adjacencyList.get(nodeA).add(nodeB);
            adjacencyList.get(nodeB).add(nodeA);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer, List<Integer>> entry:this.adjacencyList.entrySet()){
            builder.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
        }
        return builder.toString();


    }

    public static void main(String[] args) {
        int vertex = 8;
        int[][] edges = {{0,1},{1,3},{3,4},{3,5},{0,2},{2,6},{6,7}};
        GraphTraversals graph = new GraphTraversals(vertex,edges);
        System.out.println(graph);
        System.out.println(graph.validPath(vertex,edges,0,7));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visitedNodes = new HashSet<>();
       // return depthFirstSearch(source,destination,visitedNodes);
        return breathFirstSearch(source,destination,visitedNodes);
    }

    private boolean depthFirstSearch(int source, int destination, Set<Integer> visitedNodes) {
        if(source == destination){
            return true;
        }
        if(!visitedNodes.contains(source)){
            System.out.println(source);
            visitedNodes.add(source);
            for(int i: adjacencyList.get(source)){
                if(depthFirstSearch(i,destination,visitedNodes)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean breathFirstSearch(int source, int destination, Set<Integer> visitedNodes) {
        Queue<Integer> visitList = new LinkedList<>();
        visitList.add(source);
        while(!visitList.isEmpty()){
            int currentNode = visitList.remove();
            System.out.println(currentNode);
            visitedNodes.add(currentNode);
            if(destination==currentNode){
                return true;
            }
            List<Integer> childNodes = adjacencyList.get(currentNode);
            for(int i : childNodes){
                if(!visitedNodes.contains(i)){
                    visitList.add(i);
                }
            }
        }
        return false;
    }
}