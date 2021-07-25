
import java.util.*;

/**
 * 数据结构入门
 * https://leetcode-cn.com/problems/contains-duplicate/
 * */
public class ContainsDuplicate {

    /**
     *  1.存在重复元素 - containsDuplicate
     * */
    // 方法1： 使用双循环 -- 时间复杂度：O(n^2) 空间复杂度：？？
    public boolean containsDuplicate01(int[] nums) {
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j< nums.length-i; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    // 方法2： 使用Array.sort()先排序
    public boolean containsDuplicate02(int[] nums){
        Arrays.sort(nums); // 原地排序
        for(int i = 0; i< nums.length; i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    // 方法3：使用哈希表 -- 时间复杂度：O(N  空间复杂度：O(N)
    public boolean containsDuplicate03(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int x: nums){
            if (!set.add(x)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean res = containsDuplicate.containsDuplicate01(nums);

        System.out.println("result: " + res);
    }
}
