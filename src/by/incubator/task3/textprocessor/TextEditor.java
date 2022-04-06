package by.incubator.task3.textprocessor;

import java.util.Locale;
import java.util.Scanner;

public class TextEditor {
    private static final char A_CAPITAL = 'A';
    private static final char Z_CAPITAL = 'Z';

    public static String append(String text, String word) {
        return text + word;
    }

    public static String insert(String text, String word, int position) {
        if (position - 1 > text.length() || position < 1) {
            return text;
        }

        return text.substring(0,position - 1) + word + text.substring(position - 1);
    }

    public static String delete(String text, char symbol) {
        int index = text.indexOf(symbol);

        if (index < 0) {
            return text;
        }

        return text.substring(0, index) + text.substring(index + 1);
    }

    public static String replace(String text, String wordToReplace, String newWord) {
        int index = text.indexOf(wordToReplace);
        int lastIndex = index + wordToReplace.length();

        if (index < 0) {
            return text;
        }

        return text.substring(0,index) + newWord + text.substring(lastIndex);
    }

    public static String reverse(String string) {
        StringBuilder temp = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            temp.append(string.charAt(i));
        }

        return temp.toString();
    }

    public static String deleteSpaces() {
        char ch;
        Scanner in = new Scanner(System.in);
        StringBuilder strBuild = new StringBuilder();
        String str = in.nextLine();

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);

            if (ch == '.') {
                break;
            }
            else if (ch != ' ') {
                strBuild.append(ch);
            }
        }


        return strBuild.toString();
    }

    public static String leaveUppercase(String text) {
        char ch;
        StringBuilder strBuild = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);

            if (ch >= A_CAPITAL && ch <= Z_CAPITAL) {
                strBuild.append(ch);
            }
        }

        return strBuild.toString();
    }

    public static String evenToUppercase(String text) {
        char ch;
        StringBuilder strBuild = new StringBuilder();

        for (int i = 1; i < text.length(); i+=2) {
            ch = text.charAt(i);

//            if (ch <= A_CAPITAL || ch >= Z_CAPITAL) {
//                ch -= 32;
//            }

            strBuild.append(ch);
        }

        //return strBuild.toString();
        return strBuild.toString().toUpperCase(Locale.ROOT);
    }

    public static String replaceEmpty(String string) {
        return (string.equals(""))? "String is empty" : string;
    }

}
