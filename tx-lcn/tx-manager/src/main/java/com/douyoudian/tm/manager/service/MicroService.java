package com.douyoudian.tm.manager.service;

import com.douyoudian.tm.model.TxServer;
import com.douyoudian.tm.model.TxState;

/**
 * create by lorne on 2017/11/11
 */
public interface MicroService {

    String  tmKey = "tx-manager";

    TxServer getServer();

    TxState getState();
}
