# 🧸 Algorithm - Baekjoon


## 📍Silver
- 2869(달팽이는 올라가고 싶다)
  - ``` java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer((br.readLine()));
    ```
  - 기존에 사용하던 `Scanner클래스` 보다 입출력 속도가 빠르고, <br> `StringTokenizer클래스`를 이용하여 공백 기준으로 문자열을 분리.
  - 생각보단 `if/else`가 시간을 잡아먹지 않는다.