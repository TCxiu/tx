package com.douyoudian.tm.api.service.impl;


import com.douyoudian.tm.api.service.ApiTxManagerService;
import com.douyoudian.tm.compensate.model.TransactionCompensateMsg;
import com.douyoudian.tm.compensate.service.CompensateService;
import com.douyoudian.tm.config.ConfigReader;
import com.douyoudian.tm.manager.service.MicroService;
import com.douyoudian.tm.manager.service.TxManagerSenderService;
import com.douyoudian.tm.manager.service.TxManagerService;
import com.douyoudian.tm.model.TxServer;
import com.douyoudian.tm.model.TxState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/7/1.
 */
@Service
public class ApiTxManagerServiceImpl implements ApiTxManagerService {


    @Autowired
    private TxManagerService managerService;

    @Autowired
    private MicroService eurekaService;

    @Autowired
    private CompensateService compensateService;


    @Autowired
    private TxManagerSenderService txManagerSenderService;

    @Autowired
    private ConfigReader configReader;


    @Override
    public TxServer getServer() {
        return eurekaService.getServer();
    }


    @Override
    public int cleanNotifyTransaction(String groupId, String taskId) {
        return managerService.cleanNotifyTransaction(groupId,taskId);
    }


    @Override
    public boolean sendCompensateMsg(long currentTime, String groupId, String model, String address, String uniqueKey, String className, String methodStr, String data, int time,int startError) {
        TransactionCompensateMsg transactionCompensateMsg = new TransactionCompensateMsg(currentTime, groupId, model, address, uniqueKey, className, methodStr, data, time, 0,startError);
        return compensateService.saveCompensateMsg(transactionCompensateMsg);
    }

    @Override
    public String sendMsg(String model,String msg) {
        return txManagerSenderService.sendMsg(model, msg, configReader.getTransactionNettyDelayTime());
    }


    @Override
    public TxState getState() {
        return eurekaService.getState();
    }
}
