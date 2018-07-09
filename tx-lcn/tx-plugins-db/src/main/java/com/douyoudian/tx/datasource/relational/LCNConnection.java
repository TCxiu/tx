package com.douyoudian.tx.datasource.relational;

import com.douyoudian.tx.datasource.ILCNResource;

import java.sql.Connection;

/**
 * create by lorne on 2017/12/7
 */
public interface LCNConnection extends  Connection,ILCNResource<Connection> {
}
