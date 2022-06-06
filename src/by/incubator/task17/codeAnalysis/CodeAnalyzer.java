package by.incubator.task17.codeAnalysis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CodeAnalyzer {
    public static void analyzeCode(Object o) {
        Class<?> clazz = o.getClass();
        String className = clazz.getName();
        Printer.printClassName(className);

        String classLoaderName = clazz.getClassLoader().toString();
        Printer.printClassLoaderName(classLoaderName);

        Class<?>[] interfaces = clazz.getInterfaces();
        Printer.printInterfaces(interfaces);

        Field[] fields = clazz.getDeclaredFields();
        Printer.printFields(fields);

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Printer.printConstructors(constructors);

        Method[] methods = clazz.getDeclaredMethods();
        Printer.printMethods(methods);

        Annotation[] annotations = clazz.getDeclaredAnnotations();
        Printer.printAnnotations(annotations);
    }

    public static String getModifiers(int modifiers) {
        StringBuilder modifiersStr = new StringBuilder();

        if (Modifier.isAbstract(modifiers)) {
            modifiersStr.append("abstract ");
        }
        if (Modifier.isFinal(modifiers)){
            modifiersStr.append( "final ");
        }
        if (Modifier.isNative(modifiers)){
            modifiersStr.append("native ");
        }

        if (Modifier.isPrivate(modifiers)){
            modifiersStr.append("private ");
        } else if (Modifier.isProtected(modifiers)){
            modifiersStr.append("protected ");
        } else if (Modifier.isPublic(modifiers)){
            modifiersStr.append("public ");
        }

        return modifiersStr.toString();
    }

    public static String getParameters(Class<?>[] parameterTypes) {
        StringBuilder paramInfo = new StringBuilder();

        for (Class<?> parameter : parameterTypes) {
            paramInfo.append(parameter.getTypeName()).append(" ");
        }

        return paramInfo.toString();
    }
}
