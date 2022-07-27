package pri.jjlouis.leetcode.base;

import java.util.Arrays;

public class HeapSort {

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
        for(int step = nums.length/2;step > 0;step = step/2){
            for(int i = 0;i < nums.length;i+= step){
                for(int j = i - step;j >= 0;j-=step){
                    if((nums[j + step] > nums[j] && desc) || (nums[j + step] < nums[j] && !desc)){
                        nums[j + step] = nums[j + step] ^ nums[j];
                        nums[j] = nums[j + step] ^ nums[j];
                        nums[j + step] = nums[j + step] ^ nums[j];
                    }
                    count++;
                }
            }
        }
        System.out.println("call times = " + count);
        return nums;
    }
}
