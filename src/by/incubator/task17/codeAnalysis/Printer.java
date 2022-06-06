package by.incubator.task17.codeAnalysis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Printer {
    public static final String IMPLEMENTED_INTERFACES = "Implemented interfaces of the class:";
    public static final String METHODS = "Methods:";
    public static final String METHOD_PARAMETERS = "Parameters:";
    public static final String METHOD_RETURN_TYPE = "Return type:";
    public static final String MODIFIERS = "Modifiers:";
    public static final String FIELDS = "Fields:";
    public static final String ANNOTATIONS = "Annotations:";
    public static final String CONSTRUCTORS = "Constructors:";

    public static void printDashes() {
        System.out.println("------------------------------------------------------");
    }

    public static void printClassName(String className) {
        System.out.println("Classname: " + className);
        printDashes();
    }

    public static void printClassLoaderName(String classLoaderName) {
        System.out.println("Classloader: " + classLoaderName);
        printDashes();
    }

    public static void printInterfaces(Class<?>[] interfaces) {
        System.out.println(IMPLEMENTED_INTERFACES);

        for (Class<?> interfaze : interfaces) {
            System.out.println(interfaze.getName());
            printMethods(interfaze.getMethods());
            System.out.println();
        }

        printDashes();
    }

    public static void printMethods(Method[] methods) {
        System.out.println(METHODS);

        for (Method method : methods) {
            System.out.println(method.getName());

            System.out.println(METHOD_RETURN_TYPE);
            System.out.println(method.getReturnType());

            System.out.println(MODIFIERS);
            printModifiers(CodeAnalyzer.getModifiers(method.getModifiers()));

            System.out.println(METHOD_PARAMETERS);
            System.out.println(CodeAnalyzer.getParameters(method.getParameterTypes()));

            System.out.println();
        }
    }

    public static void printFields(Field[] fields) {
        System.out.println(FIELDS);

        for (Field field : fields) {
            System.out.println(field.getName());
            printParameters(field.getType());
            printModifiers(CodeAnalyzer.getModifiers(field.getModifiers()));
            printAnnotations(field.getAnnotations());
            System.out.println();
        }

        printDashes();
    }

    public static void printAnnotations(Annotation[] annotations) {
        System.out.println(ANNOTATIONS);

        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
    }

    public static void printConstructors(Constructor<?>[] constructors) {
        System.out.println(CONSTRUCTORS);

        for (Constructor<?> constructor : constructors) {
            System.out.println(MODIFIERS);
            printModifiers(CodeAnalyzer.getModifiers(constructor.getModifiers()));

            System.out.println(METHOD_PARAMETERS);
            printParameters(constructor.getParameterTypes());

            System.out.println();
        }

        printDashes();
    }

    private static void printParameters(Class<?>... parameters) {
        for (Class<?> parameter : parameters) {
            System.out.println(parameter.getName());
        }
    }

    private static void printModifiers(String modifiers) {
        System.out.println(modifiers);
    }
}
