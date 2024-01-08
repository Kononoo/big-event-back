package com.ronan.config;

/**
 * ClassName: ThreadLocalContext
 * Package: com.ronan.config
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 17:16
 * @Version: v1.0
 */
public class ThreadLocalContext {
   private static final ThreadLocal THREAD_LOCAL= new ThreadLocal();

    /**
     * 获取数据
     * @return
     * @param <T>
     */
   public static <T> T get() {
       return (T) THREAD_LOCAL.get();
   }

    /**
     * 存放线程数据
     * @param object
     * @param <T>
     */
   public static <T> void set(T object) {
       THREAD_LOCAL.set(object);
   }

    /**
     * 释放线程数据
     */
   public static void remove() {
       THREAD_LOCAL.remove();
   }
}
