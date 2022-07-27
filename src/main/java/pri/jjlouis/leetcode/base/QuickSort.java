package pri.jjlouis.leetcode.base;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,6,7,1,0,5,3};
        System.out.println(Arrays.toString(sort(nums,true)));
        System.out.println(Arrays.toString(sort(nums,false)));
    }


    /**
     * 1.a ⊕ a = 0
     * 2. a ⊕ b = b ⊕ a
     * 3. a ⊕b ⊕ c = a ⊕ (b ⊕ c) = (a ⊕ b) ⊕ c;
     * 4. d = a ⊕ b ⊕ c 可以推出 a = d ⊕ b ⊕ c.
     * 5. a ⊕ b ⊕ a = b
     * */
    private static int[] sort(int[] nums,boolean desc){
        if(nums == null){
            return null;
        }
        if(nums.length < 2){
            return nums;
        }
        return splitSort(nums,desc,0,nums.length - 1);
    }

    private static int[] splitSort(int[] nums,boolean desc,int start,int end){
        if(end <= start){
            return nums;
        }
        int base = nums[start];
        int low = start;
        int high = end;
        while (low < high){
            while (low < high && ((nums[high] >= base && !desc) || (desc && nums[high] <= base))){
                high--;
            }
            nums[low] = nums[high];
            while (low < high && ((nums[low] <= base && !desc) || (nums[low] >= base && desc))){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = base;
        splitSort(nums,desc,start,low);
        splitSort(nums,desc,low+1,end);
        return nums;
    }
}
