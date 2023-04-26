package io.github.navpil.esoteric.collections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class MutableClassHelper {

    private static final Set<Class<?>> immutableTypes;

    static {
        // Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE
        immutableTypes = new HashSet<>();
        immutableTypes.add(Boolean.class);
        immutableTypes.add(Character.class);
        immutableTypes.add(Byte.class);
        immutableTypes.add(Short.class);
        immutableTypes.add(Integer.class);
        immutableTypes.add(Long.class);
        immutableTypes.add(Float.class);
        immutableTypes.add(Double.class);
        immutableTypes.add(Void.class);
        immutableTypes.add(String.class);
    }

    public static boolean isMutableClass(Class<?> t) {
        if (immutableTypes.contains(t)) {
            return false;
        }
        Set<Class<?>> viewedClasses = new HashSet<>();
        return innerIsMutableClass(t, viewedClasses);
    }

    private static boolean innerIsMutableClass(Class<?> t, Set<Class<?>> viewedClasses) {
        //Avoid circular dependencies
        if (viewedClasses.contains(t)) {
            return false;
        }
        viewedClasses.add(t);

        Field[] declaredFields = t.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!Modifier.isFinal(declaredField.getModifiers())) {
                return true;
            }
            //Field is final, now check whether we can mutate the class itself
            Class<?> type = declaredField.getType();
            if (type.isPrimitive() || immutableTypes.contains(type)) {
                continue;
            }
            if (type.isArray() || type.isInterface()) {
                //Arrays are mutable, with interfaces we can never be sure
                return true;
            }
            if (innerIsMutableClass(type, viewedClasses)) {
                return true;
            }
        }
        return false;
    }

}
