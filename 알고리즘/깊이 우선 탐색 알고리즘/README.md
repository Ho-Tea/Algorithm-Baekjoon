# 🧸 Algorithm - Baekjoon


## 📍 인상깊은 문제
- 적록색약(10026번)
	- 한 노드를 기점으로 갈수있는, 연관된 노드 끝 까지 탐색 가능(**집합을 찾는 것**)



### ⛏DFS (Stack)

- 자기 자신을 호출하는 순환 알고리즘의 형태를 지닌다 (재귀 or 스택)
  - 순환 호출 이용(재귀)
  - 명시적인 스택 사용 - > 스택 자료구조를 생성(Linked List)
- 모든 정점을 방문해야하는경우에 사용하자 -> 백트래킹에 용이(전체노드를 탐색하므로) 
- 포함 + 포함되지 않음을 나타낼때, 즉 **집합**을 만들때는 사용하자.
- 특정한 타겟으로 잡은 노드로부터 가장 멀리 있는 노드를 먼저 탐색할 때 사용
- 방문노드 검사 필수

```java
// 재귀

// dfs, 재귀, 인접 행렬, i 정점부터 시작한다.
    public static void dfs(int i) {
		visit[i] = true;
		System.out.print(i + " ");
		
		for(int j=1; j<n+1; j++) {
			if((map[i][j] == 1 || map[j][i]) == 1)&& visit[j] == false) {
				dfs(j);
			}
		}
	}
```

- <img src="../Image/DFS.png" weight = "300">