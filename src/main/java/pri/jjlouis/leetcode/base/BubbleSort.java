package pri.jjlouis.leetcode.base;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,6,7,1,0,5,3};
        System.out.println(Arrays.toString(sort(nums,true)));
        System.out.println(Arrays.toString(sort(nums,false)));
    }


    /**
     *1.a ⊕ a = 0
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
        for(int i = 0;i < nums.length;i++){
            for(int j1 = 0,j2 = j1 + 1; j2 < nums.length - i;j1++,j2++){
                int first = nums[j1];
                int second = nums[j2];
                if(!desc){
                    if(first > second){
                        nums[j1] = nums[j1]^nums[j2];
                        nums[j2] = nums[j1]^nums[j2];
                        nums[j1] = nums[j1]^nums[j2];
                    }
                }else {
                    if(first < second){
                        nums[j1] = nums[j1]^nums[j2];
                        nums[j2] = nums[j1]^nums[j2];
                        nums[j1] = nums[j1]^nums[j2];
                    }
                }
            }
        }
        return nums;
    }
}
