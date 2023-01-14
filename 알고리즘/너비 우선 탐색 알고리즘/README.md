# 🧸 Algorithm - Baekjoon


## 📍Silver
- 1260(DFS와BFS)

### 🛠BFS (Queue)
- BFS는 재귀적으로 동작하지 않습니다.
- 방문노드 검사 필수

- <img src="../Image/BFSvsDFS.png" weight = "300">
- <img src="../Image/BFS.png" weight = "300">


```java
// bfs, q사용, 인접행렬, i 정점부터 시작한다.
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for(int j=1; j<n+1; j++) {
				if((map[temp][j] == 1|| map[j][temp]) == 1 && visit[j] == false) {
					q.offer(j);
					visit[j] = true;
				}
			}
		}
	}
```