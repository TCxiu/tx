package com.douyoudian.tx.compensate.service;


import com.douyoudian.tx.compensate.model.CompensateInfo;
import com.douyoudian.tx.model.TransactionInvocation;

/**
 * create by lorne on 2017/11/11
 */
public interface CompensateService {


    void saveLocal(CompensateInfo compensateInfo);

    boolean invoke(TransactionInvocation invocation, String groupId, int startState);

}
