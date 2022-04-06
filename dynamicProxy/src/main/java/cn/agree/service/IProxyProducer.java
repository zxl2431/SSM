package cn.agree.service;


/*
*  一个代理类的接口
*  代理商
* */
public interface IProxyProducer {

    /*
    *  销售商品
    * */
    public void saleProduct(Float money);

    /*
    *  售后服务
    *
    * */
    public void afterService(Float money);

}
