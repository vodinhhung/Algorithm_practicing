package course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_dfs {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] onpath = new int[numCourses];

        Map<Integer, List<Integer>> graph = generateMap(prerequisites);

        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0 && dfs_cycle(graph, i, visited, onpath)){
                return false;
            }
        }

        return true;
    }

    private Map<Integer, List<Integer>> generateMap(int[][] arr){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(graph.containsKey(arr[i][0])){
                List<Integer> neighbor = graph.get(arr[i][0]);
                neighbor.add(arr[i][1]);
                graph.put(arr[i][0], neighbor);
            } else {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(arr[i][1]);
                graph.put(arr[i][0], neighbor);
            }
        }
        return graph;
    }

    private boolean dfs_cycle (Map<Integer, List<Integer>> graph, int node, int[] visited, int[] onpath){
        if(visited[node] == 1) return false;
        onpath[node] = visited[node] = 1;

        if(graph.containsKey(node)){
            for(int neigh: graph.get(node)){
                if(onpath[neigh]==1 || dfs_cycle(graph, neigh, visited, onpath))
                    return true;
            }
        }
        onpath[node] = 0;
        return false;
    }
}
