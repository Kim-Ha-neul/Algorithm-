import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
  public int[] solution(int N, int[] stages) {

    List<Stage> list = new ArrayList<>();

    for (int i = 1; i < N + 1; i++) {
      int now = 0;
      int clear = 0;

      for (int stage : stages) {
        if (i <= stage) {
          clear += 1;
        }
        if (i == stage) {
          now += 1;
        }
      }

      if (clear == 0) {
        list.add(new Stage(i, 0));
      } else {
        list.add(new Stage(i, (double) now / clear));
      }
    }

    list.sort(Stage::compareTo);
    return list.stream().mapToInt(Stage::getNum).toArray();
  }
}
class Stage implements Comparable<Stage> {

  private int num; // 고유번호
  private double failure; // 실패율

  public int getNum() {
    return num;
  }

  public Stage(int num, double failure) {
    this.num = num;
    this.failure = failure;
  }

  @Override
  public int compareTo(Stage o) {
    if (this.failure == o.failure) {
      return this.num < o.num ? -1 : 1;
    } else {
      return this.failure > o.failure ? -1 : 1;
    }
  }
}