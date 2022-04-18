package by.incubator.task12.brackets;

import com.sun.xml.internal.fastinfoset.util.CharArrayArray;

import java.util.*;
import java.util.regex.Pattern;

public class Brackets {
    public static void main(String[] args) {

        String check = "(fsd(ddsf(fs(<sdf><sdf>(fsdf[dsf{[]}]dg)fsd()()[][]{}{})g)))";

        System.out.println(areCorrectBrackets(check));
    }

    public static boolean areCorrectBrackets(String input) {

        int bracketIndex;
        char[] inputChars = input.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        List<Character> openBrackets = Arrays.asList('[','{','<','(');
        List<Character> closeBrackets = Arrays.asList(']','}','>',')');

        for (char aChar : inputChars) {
            if (openBrackets.contains(aChar)) {
                stack.add(aChar);
            } else if (closeBrackets.contains(aChar)) {

                bracketIndex = closeBrackets.indexOf(aChar);

                if (openBrackets.get(bracketIndex) != stack.pollLast()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
