package pri.jjlouis.leetcode.base;

import java.util.Arrays;

public class MergeSort {

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
        return mergeSort(nums,0,nums.length -1,desc);
    }

    private static int[] mergeSort(int[] nums,int start,int end,boolean desc){
        if(start >= end){
            return nums;
        }
        int step = (end - start)/2;
        mergeSort(nums,start,start + step,desc);
        mergeSort(nums,start + step + 1,end,desc);
        return merge(nums,start,start + step,end,desc);
    }

    private static int[] merge(int[] nums,int start,int mid,int end,boolean desc){
        int [] tmp = new int[end - start + 1];
        int leftStart = start;
        int rightStart = mid + 1;
        for(int i = 0;i < tmp.length;i++){
            if(leftStart > mid){
                tmp[i] = nums[rightStart++];
                continue;
            }
            if(rightStart > end){
                tmp[i] = nums[leftStart++];
                continue;
            }
            if((nums[leftStart] > nums[rightStart] && desc) ||
                    (nums[leftStart] < nums[rightStart] && !desc)){
                tmp[i] = nums[leftStart];
                leftStart++;
            }else {
                tmp[i] = nums[rightStart];
                rightStart++;
            }
        }
        for(int i = start;i <= end;i++){
            nums[i] = tmp[i-start];
        }
        return nums;
    }

}
