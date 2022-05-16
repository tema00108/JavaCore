package by.incubator.task18.objectFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class Initializer {
    public static <T> void initialize(T target, String fieldName, Object value) throws NoSuchMethodException, NoSuchFieldException {
        Class<?> targetClass = target.getClass();
        Class<?> valueClass = value.getClass();

        String setterName = getSetterName(fieldName);

        Method setter = targetClass.getDeclaredMethod(setterName,valueClass);
        checkSetterParameters(setter.getParameterTypes());

        try {
            setter.invoke(target, value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static String getSetterName(String fieldName) {
        int length = fieldName.length();

        if (length < 1) {
            throw new IllegalArgumentException("Empty field name.");
        }

        return (length == 1) ? "set" + fieldName.toUpperCase(Locale.ROOT) :
                        "set" + (char) (fieldName.charAt(0) - 32) + fieldName.substring(1);
    }

    private static void checkSetterParameters(Class<?>[] parameters) throws NoSuchMethodException {
        if (parameters.length != 1) {
            throw new NoSuchMethodException("Setter accepts " + parameters.length + " parameters, but it must accept 1");
        }
    }
}
