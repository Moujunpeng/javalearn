//package com.mjp.jvm;
//
//import java.lang.reflect.Method;
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//public class JavaMethodAreaOOM {
//
//    public static void main(String[] args) {
//        while (true) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(OOMObject.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                    return proxy.invokeSuper(object, args);
//                }
//            });
//            enhancer.create();
//        }
//    }
//
//    static class OOMObject{}
//
//}
