package course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_topological {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = generateMap(prerequisites);
        int[] inDegree = generateDegree(numCourses, graph);

        for(int i=0; i<numCourses; i++){
            int j=0;
            for(j=0; j<numCourses; j++) {
                if (inDegree[j] == 0)
                    break;
            }
            if (j == numCourses) return false;
            inDegree[j] = -1;
            if(graph.containsKey(j)) {
                for (int neigh : graph.get(j))
                    inDegree[neigh]--;
            }
        }

        return true;
    }

    private Map<Integer, List<Integer>> generateMap(int[][] arr){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(graph.containsKey(arr[i][1])){
                List<Integer> neighbor = graph.get(arr[i][1]);
                neighbor.add(arr[i][0]);
                graph.put(arr[i][1], neighbor);
            } else {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(arr[i][0]);
                graph.put(arr[i][1], neighbor);
            }
        }
        return graph;
    }

    private int[] generateDegree(int num, Map<Integer, List<Integer>> graph){
        int[] degree = new int[num];

        for(int neighbors: graph.keySet()){
            for(int neigh: graph.get(neighbors))
                degree[neigh]++;
        }
        return degree;
    }
}