package leetcode.array;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/8/8
 * @Description:
 * @Modified By:
 **/
public class TwpSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (hashMap.containsKey(nums[i]) && hashMap.get(nums[i]) != i) {
                return new int[]{hashMap.get(nums[i]),i};
            } else {
                hashMap.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int[] ints = new TwpSum().twoSum(a, 9);
        System.out.println(JSONObject.toJSONString(ints));
    }
}
