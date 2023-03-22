# 🧸 Algorithm - Baekjoon
 


## 📍 인상깊은 문제
- 절댓값 힙(11286번)
	- `Comparable`를 구현하는 특정 클래스를 이용
- 가운데를 말해요(1655번)
    - `maxhip`(큰거를 출력) 하는 우선순위 큐와 <br>`minhip`(작은것을 출력)하는 우선순위 큐를 두어 가운데 값을 가져올수 있게끔 구성

### 🎱 Priority Queue
- `PriorityQueue`란 우선순위 큐 로써 일반적인 큐의 구조 `FIFO`를 가지면서 데이터가 들어온 순서대로 데이터가 나가는 것이 아닌 <br> **우선순위**를 먼저 결정하고 그 우선순위가 높은 데이터가 먼저 나가는 자료구조이다
- `PriorityQueue`를 사용하기 위해선 우선순위 큐에 저장할 객체는 필수적으로 `Comparable Interface`를 구현해야 한다
- `PriorityQueue`는 `Heap`을 이용하여 구현하는 것이 일반적이다
  - Heap이라는 자료구조는 값들이 모여있는 자료구조를 트리로 구현하였다고 할 때,<br> 루트에 위치하는 값이 최대 혹은 최소값이 되는 자료구조를 의미한다.


- <img src="../Image/heap.png" width = "500">


```java
// PriorityQ
static PriorityQueue<Abs> priorityQ = new PriorityQueue<>(Abs);
priorityQ.add();    // 추가를 못한다면 예외를 발생
priorityQ.offer();  //추가실패를 의미하는 false 리턴의 차이정도가 존재

static class Abs implements Comparable<Abs> {
        private int num;
        public Abs(int num) {
            this.num = num;
        }
        @Override
        public int compareTo(Abs o) {
            if (Math.abs(this.num) > Math.abs(o.num)) {
                return 1;
            } else if (Math.abs(this.num) < Math.abs(o.num)) {
                return -1;
            } else {
                return Integer.compare(this.num, o.num);
            }
        }
        // TODO Auto-generated method stub

    }
```