# 🧸 Algorithm - Baekjoon


## 📍Silver
### 🧮MATH
- 2869(달팽이는 올라가고 싶다)
  - ``` java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer((br.readLine()));
    ```
  - 기존에 사용하던 `Scanner클래스` 보다 입출력 속도가 빠르고, <br> `StringTokenizer클래스`를 이용하여 공백 기준으로 문자열을 분리.
  - 생각보단 `if/else`가 시간을 잡아먹지 않는다.  

- 2839(설탕 배달)
  - 2869(달팽이는 올라가고 싶다)에서 사용한 `BufferedReader클래스` 이용 <br> -> 입출력 속도 향상
  - 수학 문제인 만큼 N = 3*i + 5*j를 이용하여 i와 j값을 도출

- 4673(셀프 넘버)
  - 수학문제의 경우 설명에서 주어진 함수를 이용하자
    - `d(n)`함수 이용