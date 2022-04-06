package cn.agree.service.impl;

public class CglibProducer {

    /*
     *  销售商品
     *
     * */
    public void saleProduct(Float money) {
        System.out.println("Cglib销售商品,金额是:"+money);
    }

    public void afterService(Float money) {
        System.out.println("Cglib提供售后服务,金额是:"+money);
    }
}
