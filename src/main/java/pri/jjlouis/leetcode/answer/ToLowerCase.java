package pri.jjlouis.leetcode.answer;

/**
 * @Author : xiongyijie
 * @Time : 2018/9/30 16:02
 * @Function:
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 */
public class ToLowerCase {

    public static void main(String[] args) {
        Common.print("Hello",solution("Hello"));
        Common.print("here",solution("here"));
        Common.print("LOVELY",solution("LOVELY"));
        Common.print(null,solution(null));
        Common.print("",solution(""));
        Common.print("2342QqqcV",solution("2342QqqcV"));
    }

    public static String solution(String str) {
        if(str == null){
            return null;
        }
        char[] chars = str.toCharArray();
        int ASciiCode = 65;
        int ZSciiCode = 90;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] >= ASciiCode && chars[i] <= ZSciiCode){
                chars[i] +=32;
            }
        }
        return new String(chars).toLowerCase();
    }
}
