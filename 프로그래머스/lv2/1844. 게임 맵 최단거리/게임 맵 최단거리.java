import java.util.*;


class Solution {
    static int[][] move = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visited;
    static int[][] difs;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        difs = new int[maps.length][maps[0].length];
        Node init = new Node(0,0);
        
        bfs(init, maps);
        
        if(visited[maps.length-1][maps[0].length-1] == false){
            return -1;
        }
        return difs[maps.length-1][maps[0].length-1];
    }
    
    public static void bfs(Node initNode, int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(initNode);
        visited[initNode.x][initNode.y] = true;
        difs[initNode.x][initNode.y] = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            
            for(int[] moved : move){
                int movedX = node.x + moved[0];
                int movedY = node.y + moved[1];
                if(maps.length > movedX && 0 <= movedX && maps[0].length > movedY && 0 <= movedY){
                    if(maps[movedX][movedY] == 1 && visited[movedX][movedY] == false){
                        difs[movedX][movedY] = difs[node.x][node.y] + 1;
                        Node newNode = new Node(movedX, movedY);
                        visited[movedX][movedY] = true;
                        q.offer(newNode);
                    }
                }
            }
        }
        
        
    }
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}