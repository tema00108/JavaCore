package by.incubator.task17.codeAnalysis;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static by.incubator.task17.codeAnalysis.Printer.*;

public class CodeAnalyzer {

    public static final String CLASS_NAME = "Class name:";
    public static final String SUPER_CLASS_NAME = "Super ";
    public static final String IMPLEMENTED_INTERFACES = "Implemented interfaces of the class:";
    public static final String METHOD_PARAMETERS = "Parameters:";
    public static final String METHOD_RETURN_TYPE = "Return type:";
    public static final String METHOD_MODIFIERS = "Method modifiers:";
    public static final String ABSTRACT = "abstract";
    public static final String PUBLIC = "public";
    public static final String TAB = "\t";
    public static final String DOUBLE_TAB = "\t\t";

    public static void analyzeCode(Object o) {
        Class<?> clazz = o.getClass();

        printWithDashes(clazz.getName(), CLASS_NAME);
        printWithDashes(clazz.getSuperclass().getName(), SUPER_CLASS_NAME);

        printInterfaces(clazz);
    }

    private static void printInterfaces(Class<?> clazz) {
        print(IMPLEMENTED_INTERFACES);
        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class interfaze : interfaces) {
            print(interfaze.getName());

            printMethods(interfaze);
        }
    }

    private static void printMethods(Class interfaze) {
        for (Method method : interfaze.getMethods()) {
            printWithIndent(method.getName(), TAB);
            printWithIndent(METHOD_RETURN_TYPE, TAB);
            printWithIndent(method.getReturnType().getName(), DOUBLE_TAB);
            printModifiers(method);
            printTypesParameters(method);
        }
    }

    private static void printTypesParameters(Method method) {
        printWithIndent(METHOD_PARAMETERS, TAB);
        for (Class parameter : method.getParameterTypes()) {
            printWithIndent(parameter.getName(), DOUBLE_TAB);
        }
    }

    private static void printModifiers(Method method) {
        int modifiers = method.getModifiers();

        printWithIndent(METHOD_MODIFIERS, TAB);

        if (Modifier.isAbstract(modifiers)) {
            printWithIndent(ABSTRACT, DOUBLE_TAB);
        }

        if (Modifier.isPublic(modifiers)) {
            printWithIndent(PUBLIC, DOUBLE_TAB);
        }
    }
}
