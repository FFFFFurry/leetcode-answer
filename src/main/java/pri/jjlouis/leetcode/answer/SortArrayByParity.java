package pri.jjlouis.leetcode.answer;

import java.util.Arrays;

/**
 * @Author : xiongyijie
 * @Time : 2018/9/30 16:23
 * @Function:
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 变量替换写法思路：
 * 方法1：
 * int temp = x;
 * x = y;
 * y = temp;
 *
 * 方法2：
 * x = x + y;
 * y = x - y;
 * x = x - y;
 *
 * 方法3：
 * 原理：A = A^B^B
 *
 * a = a^b;
 * b = a^b;
 * a = a^b;
 *
 * 思考：如何证明循环体的正确性：https://blog.csdn.net/dc_726/article/details/44785395
 *
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution4(new int[]{0,6,1,2,4})));
        System.out.println(Arrays.toString(solution4(new int[]{0,1,3,5})));
        System.out.println(Arrays.toString(solution4(new int[]{3,1,2,4,3,2,789,3})));
        System.out.println(Arrays.toString(solution4(new int[]{3})));
        System.out.println(Arrays.toString(solution4(new int[]{4})));
    }

    public static int[] solution(int[] A) {
        if(A == null || A.length == 0){
            return A;
        }
        int headIndex = 0;
        int tailIndex = A.length - 1;
        for(;headIndex < A.length -1;headIndex++){
            if(isOdd(A[headIndex])){
                for(;tailIndex >=0 && tailIndex != headIndex;tailIndex--){
                    if(!isOdd(A[tailIndex])){
                        swop(A,headIndex,tailIndex);
                        break;
                    }
                }
            }
            if(headIndex == tailIndex){
                break;
            }

        }
        return A;
    }

    /**
     * 控制指针同步移动的方式
     * 1.两个循环体(这种更好理解)
     * while(条件1){
     *     do A
     * }
     * while(条件2){
     *     do B
     * }
     * 2.循环体嵌套
     * while(条件A){
     *     do A
     *     while(条件B){
     *         do B
     *     }
     * }
     * @author      xiongyijie
     * @version     v1.0
     * @date        2018/9/30 17:29
     */
    public static int[] solution2(int[] A){
        int start = 0, end = A.length-1;
        while(start < end) {
            while(start < end) {
                if ((A[start]&1) == 1) {
                    break;
                }
                start++;
            }

            while(end > start) {
                if ((A[end]&1) == 0) {
                    break;
                }
                end--;
            }

            if(start < end) {
                int tmp = A[start];
                A[start] = A[end];
                A[end] = tmp;
            }
        }
        return A;
    }

    /**
     * 这种写法很好，一层循环体，没有冗余代码，说明思路比较清晰
     * 我称为一步一个脚印写法，为什么，因为每次循环就每个都走一步
     * @author      xiongyijie
     * @version     v1.0
     * @date        2018/9/30 17:36
     */
    public static int[] solution3(int[] A){
        int i =0;
        int j =A.length-1;
        if(A==null)
            return A;
        while(i<=j){
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if (A[i]%2==0)
                i++;

            if (A[j]%2==1)
                j--;
        }
        return A;
    }

    /*这种思维方式不太常见*/
    public static int[] solution4(int[] A){
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }

    public static boolean isOdd(int number){
        return (number & 1) == 1;
    }

    public static void swop(int[] A,int index1,int index2){
        A[index1] ^= A[index2];
        A[index2] ^= A[index1];
        A[index1] ^= A[index2];
    }

}
