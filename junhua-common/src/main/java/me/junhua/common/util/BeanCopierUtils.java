package me.junhua.common.util;

import lombok.extern.slf4j.Slf4j;
import me.junhua.common.exception.BusinessException;
import me.junhua.common.service.IAction;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class BeanCopierUtils {

    private static final ConcurrentHashMap<String, BeanCopier> mapCaches = new ConcurrentHashMap();

    public BeanCopierUtils() {
    }

    public static <O, T> T copyByClass(O source, Class<T> target) {
        T instance = baseMapper(source, target);
        return instance;
    }

    public static <O, T> T copyByClass(O source, Class<T> target, IAction<T> action) {
        T instance = baseMapper(source, target);
        action.run(instance);
        return instance;
    }

    public static <O, T> T copyByObject(O source, T target) {
        String baseKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier;
        if (!mapCaches.containsKey(baseKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            mapCaches.put(baseKey, copier);
        } else {
            copier = (BeanCopier) mapCaches.get(baseKey);
        }

        copier.copy(source, target, (Converter) null);
        return target;
    }

    public static <O, T> T copyByObject(O source, T target, IAction<T> action) {
        String baseKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier;
        if (!mapCaches.containsKey(baseKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            mapCaches.put(baseKey, copier);
        } else {
            copier = (BeanCopier) mapCaches.get(baseKey);
        }

        copier.copy(source, target, (Converter) null);
        action.run(target);
        return target;
    }

    private static <O, T> T baseMapper(O source, Class<T> target) {
        String baseKey = generateKey(source.getClass(), target);
        BeanCopier copier;
        if (!mapCaches.containsKey(baseKey)) {
            copier = BeanCopier.create(source.getClass(), target, false);
            mapCaches.put(baseKey, copier);
        } else {
            copier = (BeanCopier) mapCaches.get(baseKey);
        }

        Object instance = null;

        try {
            instance = target.getDeclaredConstructor().newInstance();
        } catch (Exception var6) {
            log.error("mapper 创建对象异常" + var6.getMessage());
        }

        copier.copy(source, instance, (Converter) null);
        return (T) instance;
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    public static <T> List<T> deepCopyList(List<T> src) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteOut);
            outputStream.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream inputStream = new ObjectInputStream(byteIn);
            return (List) inputStream.readObject();
        } catch (Exception var5) {
            throw new BusinessException(var5);
        }
    }
}
