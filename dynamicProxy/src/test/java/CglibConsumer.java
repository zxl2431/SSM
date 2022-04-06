import cn.agree.service.impl.CglibProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibConsumer {

    public static void main(String[] args) {
        CglibProducer cglibProducer = new CglibProducer();

        /**
         * 动态代理：
         * 	 特点：字节码随用随创建，随用随加载
         * 	 分类：基于接口的动态代理，基于子类的动态代理
         * 	 作用：不修改源码的基础上对方法增强
         * 	 基于子类的动态代理
         * 		提供者是：第三方cglib包，在使用时需要先导包(maven工程导入坐标即可)
         * 		使用要求：被代理类不能是最终类，不能被final修饰
         * 		涉及的类：Enhancer
         * 		创建代理对象的方法：create
         * 		方法的参数：
         * 			Class：字节码。被代理对象的字节码。可以创建被代理对象的子类，还可以获取被代理对象的类加载器。
         * 			Callback：增强的代码。谁用谁写。通常都是写一个接口的实现类或者匿名内部类。
         * 					 我们在使用时一般都是使用Callback接口的子接口：MethodInterceptor
         */

        CglibProducer cglibProducerProxy = (CglibProducer) Enhancer.create(cglibProducer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * 方法的参数：
             * 	前3个和基于接口中方法的参数含义一样。
             * 	MethodProxy methodProxy：当前执行方法的代理对象。
             * 方法的返回值：
             * 	和被代理对象中方法有相同的返回值
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object rtValue = null;

                Float money = (Float) objects[0];
                if ("saleProduct".equals(method.getName())) {
                    rtValue = method.invoke(cglibProducer, money*0.5f);
                    System.out.println("saleProduct方法加强了...");
                }
                if ("afterService".equals(method.getName())) {
                    rtValue = method.invoke(cglibProducer, money*0.8f);
                }
                return rtValue;
            }
        });

        cglibProducerProxy.saleProduct(2000f);
        cglibProducerProxy.afterService(1000f);
    }
}
