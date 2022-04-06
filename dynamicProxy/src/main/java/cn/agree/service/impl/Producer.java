package cn.agree.service.impl;

import cn.agree.service.IProxyProducer;

public class Producer implements IProxyProducer {

    /*
    *  销售商品
    *
    * */
    @Override
    public void saleProduct(Float money) {
        System.out.println("销售商品,金额是:"+money);
    }

    @Override
    public void afterService(Float money) {
        System.out.println("提供售后服务,金额是:"+money);
    }
}
