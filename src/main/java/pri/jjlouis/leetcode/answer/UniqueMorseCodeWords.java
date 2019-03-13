package pri.jjlouis.leetcode.answer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : xiongyijie
 * @Time : 2018/9/30 20:13
 * @Function:
 *
 *International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 *
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * There are 2 different transformations, "--...-." and "--...--.".
 *
 *
 * Note:
 *
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 * 研究下Hash算法
 *
 * int a = 100  10进制表示
 * int a = 0144 8进制表示
 * int a = 0x100F 16进制表示
 */
public class UniqueMorseCodeWords {
    private final static String[] MORSE_CODE = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public static String getCode(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        char[] chars = str.toCharArray(); // gin ->g
        for(int i = 0;i < chars.length;i++){
            buffer.append(MORSE_CODE[chars[i] - 97]);
        }
        return buffer.toString();
    }

    public int solution(String[] words){
        Set<String> set = new HashSet<>();
        for(String word : words){
            set.add(getCode(word));
        }
        return set.size();
    }

    public static void main(String[] args) {

    }

}
