package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/8/8
 * @Description:
 * @Modified By:
 **/
public class MajorityElement {
    /**
     * hash
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxElement = nums[0];
        int maxElementNum = 1;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                temp = map.get(nums[i]);
                map.put(nums[i], ++temp);
            } else {
                map.put(nums[i], 1);
            }
            if (temp > maxElementNum) {
                maxElementNum = temp;
                maxElement = nums[i];
            }
            if (maxElementNum * 2 > nums.length)
                return maxElement;
        }
        return maxElement;
    }

    /**
     * 分治法
     * 思路：
     * 1将数组无限划分，当只有一个元素时候 它就只子数组的众数
     * 2回溯当两个子数组
     * 当两个子数组中的众数相同 那么他就是众数
     * 不同时候 遍历数组 计算这个两个众数谁出现的次数多谁就是众数
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        return fenzhi(nums, 0, nums.length - 1);
    }

    private int contInRange(int[] nums, int num, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int fenzhi(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }

        int mid = l + (r - l) / 2;
        int left = fenzhi(nums, l, mid);
        int right = fenzhi(nums, mid + 1, r);

        if (left == right) {
            return left;
        }

        int leftCount = contInRange(nums, left, l, r);
        int rightCount = contInRange(nums, right, l, r);

        return leftCount > rightCount ? left : right;
    }

    /**
     * 众数 投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == count) {
                result = nums[i];
            }
            count += result == nums[i] ? 1 : -1;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = {8, 8, 7, 7, 7};
        MajorityElement majorityElement = new MajorityElement();
        int i = majorityElement.majorityElement3(ints);
        System.out.println(i);

    }
}
