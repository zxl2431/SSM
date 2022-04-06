import cn.agree.service.IProxyProducer;
import cn.agree.service.impl.Producer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Consumer {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        // producer.saleProduct(1000f);
        // producer.afterService(500f);

        /**
         * 动态代理：
         * 	 特点：字节码随用随创建，随用随加载
         * 	 分类：基于接口的动态代理，基于子类的动态代理
         * 	 作用：不修改源码的基础上对方法增强
         * 	 基于接口的动态代理：
         * 		提供者是：JDK官方
         * 		使用要求：被代理类最少实现一个接口。
         * 		涉及的类：Proxy
         * 		创建代理对象的方法：newProxyInstance
         * 		方法的参数：
         * 			ClassLoader：类加载器。用于加载代理对象的字节码的。和被代理对象使用相同的类加载器。固定写法。
         * 			Class[]：字节码数组。用于给代理对象提供方法。和被代理对象具有相同的方法。和被代理对象实现相同的接口，就会具有相同的方法。固定写法
         * 			InvocationHanlder：要增强的方法。此处是一个接口，我们需要提供它的实现类。通常写的是匿名内部类。
         * 							  增强的代码谁用谁写。
         *
         */

        IProxyProducer proxyProducer = (IProxyProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        // 1.获取参数
                        Float money = (Float) args[0];
                        // 2.判断当前方法是销售还是售后
                        if ("saleProduct".equals(method.getName())) {
                            rtValue = method.invoke(producer, money*0.75f);
                            System.out.println("saleProduct方法加强了,收了手续费");
                        }
                        if ("afterService".equals(method.getName())) {
                            rtValue = method.invoke(producer, money*0.75f);
                        }
                        return rtValue;
                    }
                });

        proxyProducer.saleProduct(1000f);
        proxyProducer.afterService(500f);

    }
}
