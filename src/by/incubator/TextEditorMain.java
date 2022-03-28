package by.incubator;

import java.io.Serializable;
import java.io.StringReader;
import java.util.Scanner;

import static by.incubator.TextEditor.*;

public class TextEditorMain {
    public static void main(String[] args) {
        char ch;
        int num;
        String string;
        String str1;
        String str2;
        String str3;
        String str4;
        Scanner in = new Scanner(System.in);

        String strAppend = append("Hello, user! How are you?", "Fine!");
        String strInsert = insert("Hello, user! How are you?", "dear", 7);
        String strDelete = delete("Hello, user! How are you?", '!');
        String strReplace = replace("Hello, user! How are you?", "user", "programmer");

        System.out.println(strAppend);
        System.out.println(strInsert);
        System.out.println(strDelete);
        System.out.println(strReplace);

        string = reverse(in.nextLine());
        System.out.println(string);

        System.out.println(deleteSpaces());

        string = leaveUppercase("YoU NEveR Be ALONe");
        System.out.println(string);

        string = evenToUppercase("ahahahah");
        System.out.println(string);

        System.out.print("Input number of elements in your array: ");
        do {
            num = Integer.parseInt(in.nextLine());
        } while (num <= 0);

        String[] strArray = new String[num];

        for (int i = 0; i < num; i++) {
            System.out.print("Input your string: ");
            string = replaceEmpty(in.nextLine());
            strArray[i] = string;
        }

        for (String str:
             strArray) {
            System.out.println(str);
        }

        str1 = "Java";
        str2 = "JAVA";
        str3 = "C#";
        str4 = "Java";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));
        System.out.println(str2.equals(str3));
        System.out.println(str2.equals(str4));
        System.out.println(str3.equals(str4));

        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println(str1 == str4);

        str1 = "JavaJava";
        System.out.println(str1.substring(4) == str4);

        System.out.println(str1 == null);

        str1 = null;
        System.out.println(str1 == null);
    }
}
