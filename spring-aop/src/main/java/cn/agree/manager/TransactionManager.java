package cn.agree.manager;

import cn.agree.utils.ConnectionUtil;

import java.sql.SQLException;

public class TransactionManager {

    private ConnectionUtil connectionUtil;

    public void setConnectionUtil(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    // 开启事务
    public void beginTransaction() {
        // 从当前线程上获取连接,实现开启事务
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 提交事务
    public void commit() {
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 回滚事务
    public void rollback() {
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 释放连接
    public void release() {
        try {
            // 关闭连接
            connectionUtil.getThreadConnection().close();
            connectionUtil.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
