package com.douyoudian.tm.api.service.impl;

import com.douyoudian.tm.api.service.ApiModelService;
import com.douyoudian.tm.manager.ModelInfoManager;
import com.douyoudian.tm.model.ModelInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by lorne on 2017/11/13
 */
@Service
public class ApiModelServiceImpl implements ApiModelService {


    @Override
    public List<ModelInfo> onlines() {
        return ModelInfoManager.getInstance().getOnlines();
    }


}
