package graphs;

import java.util.*;

public class GraphPathExists {


    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    GraphPathExists(int n,int[][]edges){
        this.populateAdjacencyList(n,edges);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            Integer key = entry.getKey();          // Get the key (vertex)
            List<Integer> nodes = entry.getValue();
            result.append(key).append(":").append(nodes).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {

        int [][] edges =  {{0,1}, {1,3},{3,4},{3,5},{0,2},{2,6},{6,7}};
        int nodes =8;
        GraphPathExists obj = new GraphPathExists(nodes,edges);
        System.out.println(obj);
        System.out.println(obj.validPath(nodes,edges,0,7));

    }

    private void populateAdjacencyList(int n, int[][] edges){
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for(int[] edge:edges){
            int startNode = edge[0];
            int endNode = edge[1];

            adjacencyList.get(startNode).add(endNode);
            adjacencyList.get(endNode).add(startNode);
         }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> visitedNodes = new HashSet<>();
        //return dfs(source,destination,visitedNodes);
        return bfs(source,destination,visitedNodes);
    }

    private boolean dfs(int currentNode, int destination,Set<Integer> visitedNodes) {
        System.out.println(currentNode);
        if(currentNode == destination){
            return true;
        }
        List<Integer> neighbours = adjacencyList.get(currentNode);
        visitedNodes.add(currentNode);
        for(int i:neighbours){
            if(!visitedNodes.contains(i)){
                if(dfs(i,destination,visitedNodes)){
                    return true;
                }
            }
        }
        return false;

    }


    private boolean bfs(int source, int destination,Set<Integer> visitedNodes) {
        Queue<Integer> toVisitQ = new LinkedList<>();
        toVisitQ.add(source);
        visitedNodes.add(source);
        while(!toVisitQ.isEmpty()){
            int currentNode = toVisitQ.remove();
            System.out.println(currentNode);
            if(currentNode==destination){
                return true;
            }
            for(int child:adjacencyList.get(currentNode)){
                if(!visitedNodes.contains(child)){
                    toVisitQ.add(child);
                    visitedNodes.add(child);
                }
            }
        }
       return false;
    }
}