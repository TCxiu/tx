package com.douyoudian.tx.aop.service.impl;

import com.douyoudian.tx.annotation.TxTransaction;
import com.douyoudian.tx.aop.bean.TxTransactionInfo;
import com.douyoudian.tx.aop.bean.TxTransactionLocal;
import com.douyoudian.tx.aop.service.AspectBeforeService;
import com.douyoudian.tx.aop.service.TransactionServer;
import com.douyoudian.tx.aop.service.TransactionServerFactoryService;
import com.douyoudian.tx.model.TransactionInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by lorne on 2017/7/1.
 */
@Service
public class AspectBeforeServiceImpl implements AspectBeforeService {

    @Autowired
    private TransactionServerFactoryService transactionServerFactoryService;


    private Logger logger = LoggerFactory.getLogger(AspectBeforeServiceImpl.class);


    public Object around(String groupId, ProceedingJoinPoint point) throws Throwable {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> clazz = point.getTarget().getClass();
        Object[] args = point.getArgs();
        Method thisMethod = clazz.getMethod(method.getName(), method.getParameterTypes());

        TxTransaction transaction = thisMethod.getAnnotation(TxTransaction.class);

        TxTransactionLocal txTransactionLocal = TxTransactionLocal.current();

        logger.debug("around--> groupId-> " +groupId+",txTransactionLocal->"+txTransactionLocal);

        TransactionInvocation invocation = new TransactionInvocation(clazz, thisMethod.getName(), thisMethod.toString(), args, method.getParameterTypes());

        TxTransactionInfo info = new TxTransactionInfo(transaction,txTransactionLocal,invocation,groupId);

        TransactionServer server = transactionServerFactoryService.createTransactionServer(info);

        return server.execute(point, info);
    }
}
