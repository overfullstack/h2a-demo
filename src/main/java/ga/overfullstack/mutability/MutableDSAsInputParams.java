package ga.overfullstack.mutability;

import java.util.Arrays;
import java.util.List;

public class MutableDSAsInputParams {
  static int sum(List<Integer> nums) {
    var result = 0;
    for (int num : nums) {
      result += num;
    }
    return result;
  }

  static int sumAbsolute(List<Integer> nums) {
    for (var i = 0; i < nums.size(); i++) nums.set(i, Math.abs(nums.get(i)));
    return sum(nums); // DRY
  }

  public static void client1() {
    var nums = Arrays.asList(-2, 5, -6);
    System.out.println(sumAbsolute(nums));
  }

  public static void client2() {
    var nums = Arrays.asList(-2, 5, -6);
    System.out.println(sumAbsolute(nums));
    System.out.println(sum(nums)); // 😬
  }
}
