package pri.jjlouis.leetcode.answer;

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
 */
public class UniqueMorseCodeWords {
    private final static String[] MORSE_CODE = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    private final static char[][] MORSE_CODE_CHAR_ARRAY = new char[MORSE_CODE.length][];
    static {
        for(int i = 0;i < MORSE_CODE.length;i++){
            MORSE_CODE_CHAR_ARRAY[i] = MORSE_CODE[i].toCharArray();
        }
    }

    public static char[] getCode(String str){
        char[] codes = new char[12 * 4];
        if(str == null || str.length() == 0){
            return null;
        }
        char[] chars = str.toCharArray(); // gin ->g
        byte index = 1;
        for(char ch : chars){
            for(char co:MORSE_CODE_CHAR_ARRAY[ch - 97]){
                chars[index++] = co;
            }
        }
        chars[0] = (char)(index - 1);
        return codes;
    }

    public int solution(String[] words){

    }

    public static void main(String[] args) {

    }

}
