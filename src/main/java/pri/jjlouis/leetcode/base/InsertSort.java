package pri.jjlouis.leetcode.base;

import java.util.Arrays;

public class InsertSort {

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
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i - 1; j >= 0;j--){
                if((nums[j+1] < nums[j] && !desc) || (nums[j+1] > nums[j] && desc)){
                    nums[j] = nums[j] ^ nums[j+1];
                    nums[j + 1] = nums[j] ^ nums[j+1];
                    nums[j] = nums[j] ^ nums[j+1];
                }
                count++;
            }
        }
        System.out.println("call times = " + count);
        return nums;
    }
}
