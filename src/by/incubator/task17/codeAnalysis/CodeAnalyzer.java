package by.incubator.task17.codeAnalysis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static by.incubator.task17.codeAnalysis.Printer.*;

public class CodeAnalyzer {

    public static final String CLASS_NAME = "Class name:";
    public static final String SUPER = "Super ";
    public static final String IMPLEMENTED_INTERFACES = "Implemented interfaces of the class:";
    public static final String METHODS = "Methods:";
    public static final String METHOD_PARAMETERS = "Parameters:";
    public static final String METHOD_RETURN_TYPE = "Return type:";
    public static final String MODIFIERS = "Modifiers:";
    public static final String HIERARCHY = "Hierarchy of superclasses:";
    public static final String FIELDS = "Fields:";
    public static final String ANNOTATIONS = "Annotations:";
    public static final String CONSTRUCTORS = "Constructors:";
    public static final String STATIC = "static";
    public static final String ABSTRACT = "abstract";
    public static final String FINAL = "final";
    public static final String PUBLIC = "public";
    public static final String PROTECTED = "protected";
    public static final String DEFAULT = "default";
    public static final String PRIVATE = "private";

    public static void analyzeCode(Object o) {
        Class<?> clazz = o.getClass();

        print(CLASS_NAME, clazz.getName(), true);
        print(SUPER + CLASS_NAME, clazz.getSuperclass().getName(),true);

        printInterfaces(clazz.getInterfaces());
        
        printHierarchy(clazz);

        printFields(clazz.getDeclaredFields());

        printConstructors(clazz.getConstructors());

        printMethods(clazz.getDeclaredMethods());

        printAnnotations(clazz.getAnnotations());
    }

    private static void printConstructors(Constructor<?>[] constructors) {
        print(CONSTRUCTORS);

        for (Constructor<?> constructor : constructors) {
            Printer.print(MODIFIERS, 1);
            printModifiers(constructor.getModifiers());

            Printer.print(METHOD_PARAMETERS, 1);
            printParameters(true, constructor.getParameterTypes());

            System.out.println();
        }

        printDashes();
    }

    private static void printFields(Field... fields) {
        print(FIELDS);

        for (Field field : fields) {
            print(field.getName(), 1);
            printParameters(false, field.getType());
            printModifiers(field.getModifiers());

            printAnnotations(field.getAnnotations());

            System.out.println();
        }

        printDashes();
    }

    private static void printHierarchy(Class<?> clazz) {
        print(HIERARCHY);
        while (clazz != null) {
            print(clazz.getName());
            clazz = clazz.getSuperclass();
        }

        printDashes();
    }

    private static void printInterfaces(Class<?>... interfaces) {
        print(IMPLEMENTED_INTERFACES);

        for (Class<?> interfaze : interfaces) {
            print(interfaze.getName());

            printMethods(interfaze.getMethods());

            System.out.println();
        }

        printDashes();
    }

    private static void printMethods(Method[] methods) {
        print(METHODS);

        for (Method method : methods) {
            Printer.print(method.getName(), 1);

            Printer.print(METHOD_RETURN_TYPE, 1);
            Printer.print(method.getReturnType().getName(), 2);

            Printer.print(MODIFIERS, 1);
            printModifiers(method.getModifiers());

            Printer.print(METHOD_PARAMETERS, 1);
            printParameters(false, method.getParameterTypes());

            System.out.println();
        }
    }

    private static void printAnnotations(Annotation[] annotations) {
        print(ANNOTATIONS,1);

        for (Annotation annotation : annotations) {
            print(annotation.toString(), 2);
        }
    }

    private static void printParameters(boolean withAnnotations, Class<?>... parameters) {
        for (Class<?> parameter : parameters) {
            Printer.print(parameter.getName(), 2);

            if (withAnnotations) {
                printAnnotations(parameter.getDeclaredAnnotations());
            }
        }
    }

    private static void printModifiers(int modifiers) {
        if (Modifier.isAbstract(modifiers)) {
            Printer.print(ABSTRACT, 2);
        }

        if (Modifier.isFinal(modifiers)) {
            Printer.print(FINAL, 2);
        }

        if (Modifier.isPublic(modifiers)) {
            Printer.print(PUBLIC, 2);
        }

        if (Modifier.isProtected(modifiers)) {
            Printer.print(PROTECTED, 2);
        }

        if (Modifier.isPrivate(modifiers)) {
            Printer.print(PRIVATE, 2);
        }

        if (Modifier.isStatic(modifiers)) {
            Printer.print(STATIC, 2);
        }
    }
}
