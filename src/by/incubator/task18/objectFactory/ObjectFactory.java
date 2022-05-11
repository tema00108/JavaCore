package by.incubator.task18.objectFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {
    public static <T> T create(Class<T> clazz) {
        T object = null;

        try {
            Constructor<T> constructor = clazz.getConstructor();
            object = constructor.newInstance();

        } catch (NoSuchMethodException |
                InvocationTargetException |
                InstantiationException |
                IllegalAccessException e) {
            e.printStackTrace();
        }

        return object;
    }
}
