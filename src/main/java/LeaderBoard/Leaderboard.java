package LeaderBoard;

import java.util.*;

public class Leaderboard {
    public class Node implements Comparable<Node>{
        int id;
        int score;

        public Node(){

        }

        public Node(int id, int score){
            this.id = id;
            this.score = score;
        }

        public int compareTo(Node other){
            return Integer.compare(this.score, other.score);
        }
    }

    public PriorityQueue<Node> queue;
    public Map<Integer, Integer> listId;

    public Leaderboard() {
        queue = new PriorityQueue<Node>(Collections.reverseOrder());
        listId = new HashMap<>();
    }

    public void addScore(int id, int score) {
        if(listId.containsKey(id)) {
            reset(id);
            Node node = new Node(id, score);
            queue.add(node);
            listId.put(id, 1);
        } else{
            Node node = new Node(id, score);
            queue.add(node);
            listId.put(id, 1);
        }
    }

    public int top(int K) {
        int result = 0;
        List<Node> list = new ArrayList<>();
        for(int i=0; i<K; i++){
            Node newNode = queue.poll();
            result += newNode.score;
            list.add(newNode);
        }

        for(int i=0; i<K; i++){
            Node newNode = list.get(i);
            queue.add(newNode);
        }
        return result;
    }

    public void reset(int playerId) {
        List<Node> list = new ArrayList<>();
        while(true){
            Node newNode = queue.poll();
            if(newNode.id != playerId)
                list.add(newNode);
            else{
                newNode.id = 0;
                listId.remove(playerId);
                break;
            }
        }

        for(int i=0; i<list.size(); i++){
            Node newNode = list.get(i);
            queue.add(newNode);
        }
    }
}

