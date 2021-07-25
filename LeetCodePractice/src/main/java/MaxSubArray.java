/**
 * 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 * */
public class MaxSubArray {
    /**
     * 方法1： 动态规划
     * 思想：
     *  1. 指针
     *  2. f(i) = f(f(i-1))
     *
     * 复杂度分析： 时间复杂度 O(n) 仅遍历一遍数组； 空间复杂度O(1) 仅需要常数空间存放若干变量。
     * */
    public int maxSubArray(int[] nums){
        int pre =0;
        int maxAns = nums[0];
        for (int x: nums){
            pre = Math.max(pre+x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        int res = maxSubArray.maxSubArray(nums);
        System.out.println("Result: "+ res);

    }
}
