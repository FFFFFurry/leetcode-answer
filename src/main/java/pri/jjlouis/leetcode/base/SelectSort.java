package pri.jjlouis.leetcode.base;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,6,7,1,0,5,3};
        System.out.println(Arrays.toString(sort(nums,true)));
        System.out.println(Arrays.toString(sort(nums,false)));
    }

    private static int[] sort(int[] nums,boolean desc){
        if(nums == null){
            return null;
        }
        if(nums.length < 2){
            return nums;
        }
        for(int i = 0;i < nums.length;i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[j] > nums[i] && !desc) || (nums[j] < nums[i] && desc)) {
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }
            }
        }
        return nums;
    }
}
