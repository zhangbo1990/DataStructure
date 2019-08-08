package leetcode.array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangbo
 * @Date: 2019/8/8
 * @Description:
 * @Modified By:
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        //排序
        Arrays.sort(nums);
        //边界判断
        if (null == nums || nums.length <= 0 || nums[0] > 0) {
            return lists;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return lists;
            //元素1去重 使用重复元素中第一个 避免 000 -1-1 2 组合漏掉
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (r > l) {
                int sum = nums[i] + nums[l] + nums[r];
                if (0 == sum) {
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //第二个元素 去重 使用最右边重复元素
                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    // add 后的位移
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] array = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(array);
        Arrays.sort(array);
        System.out.println(JSONObject.toJSON(array));
        System.out.println(JSONObject.toJSON(lists));
    }
}
