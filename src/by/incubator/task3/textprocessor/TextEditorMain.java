package by.incubator.task3.textprocessor;

import java.util.Scanner;

import static by.incubator.task3.textprocessor.TextEditor.*;

public class TextEditorMain {
    public static void main(String[] args) {
        int num;
        String string;
        String str1;
        String str2;
        String str3;
        String str4;
        String helloUser = "Hello, user! How are you?";
        Scanner in = new Scanner(System.in);

        System.out.println("\n\"Hello, user! How are you?\" append \"Fine!\":");
        string = append(helloUser, "Fine!");
        System.out.println(string);

        System.out.println("\n\"Hello, user! How are you?\" insert \"dear\"");
        string = insert(helloUser, "dear",5);
        System.out.println(string);

        System.out.println("\n\"Hello, user! How are you?\" delete '!'");
        string = delete(helloUser, '!');
        System.out.println(string);

        System.out.println("\n\"Hello, user! How are you?\" replace \"user\" with \"programmer\"");
        string = replace("Hello, user! How are you?", "user", "programmer");
        System.out.println(string);

        System.out.print("\nInput string which to reverse: ");
        string = reverse(in.nextLine());
        System.out.println(string);

        System.out.print("\nInput string in which to delete spaces: ");
        string = deleteSpaces();
        System.out.println(string);

        System.out.println("\nOnly uppercase from \"YoU NEveR Be ALONe\":");
        string = leaveUppercase("YoU NEveR Be ALONe");
        System.out.println(string);

        System.out.println("\n\"ahahahah\" to uppecase:");
        string = evenToUppercase("ahahahah");
        System.out.println(string);

        System.out.print("\nInput number of elements in your array: ");
        do {
            num = Integer.parseInt(in.nextLine());
        } while (num <= 0);

        String[] strArray = new String[num];

        for (int i = 0; i < num; i++) {
            System.out.print("Input [" + (i + 1) + "] string: ");
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
