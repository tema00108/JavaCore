package by.incubator.task18.objectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BadInitializer extends Initializer {

    public static <T> void initialize(T target, String fieldName, Object value) throws NoSuchFieldException {
        Class<?> targetClass = target.getClass();

        Field field = targetClass.getDeclaredField(fieldName);
        field.setAccessible(true);

        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
