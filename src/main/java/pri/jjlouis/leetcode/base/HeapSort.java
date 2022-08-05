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
        buildMaxHeap(nums,desc);
        return nums;
    }

    private static void buildMaxHeap(int[] array,boolean desc){
        for(int i = array.length;i > 0; i--){
            for(int j = (i>>1) - 1;j >= 0; j--){
                adjustHeap(array,j,i, desc);
            }
            if(i > 1){
                swap(array,0,i-1);
            }

        }
    }

    private static void adjustHeap(int[] array, int startIndex,int length,boolean desc){

        int maxIndex = startIndex;
        int leftIndex = ((startIndex + 1) << 1) - 1;
        int rightIndex =  (startIndex + 1) << 1;
        if(leftIndex < length && ((array[leftIndex] > array[maxIndex] && desc) ||
                (array[leftIndex] < array[maxIndex] && !desc))) {
            maxIndex = leftIndex;
        }
        if(rightIndex < length && ((array[rightIndex] > array[maxIndex] && desc) ||
                ((array[rightIndex] < array[maxIndex] && !desc) ))) {
            maxIndex = rightIndex;
        }
        System.out.println(Arrays.toString(array) + String.format("top = %s,left = %s,right = %s,max = %s",startIndex,leftIndex,rightIndex,maxIndex));
        if(maxIndex != startIndex) {
            swap(array,startIndex,maxIndex);
            adjustHeap(array, maxIndex, length, desc);
        }
    }

    private static void swap(int[] array,int s,int t){
        array[s] = array[s] ^ array[t];
        array[t] = array[s] ^ array[t];
        array[s] = array[s] ^ array[t];
    }
}
