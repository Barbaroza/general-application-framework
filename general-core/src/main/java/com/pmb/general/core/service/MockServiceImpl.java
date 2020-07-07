package com.pmb.general.core.service;

import com.pmb.general.common.domain.DO.ParamConfigDO;
import com.pmb.general.common.interfaces.core.MockService;
import com.pmb.general.common.interfaces.repository.mysql.ConstantMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lvrui
 */
@Service
public class MockServiceImpl implements MockService {
    @Resource
    private ConstantMapper constantMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void mock() {
        List<ParamConfigDO> paramConfTransactional = constantMapper.queryList();
        ParamConfigDO paramConfigDO = new ParamConfigDO();
        paramConfigDO.setParamType("mockType");
        paramConfigDO.setParamKey(1);
        paramConfigDO.setParamValue("mockValue");
        constantMapper.replaceInto(paramConfigDO);
        int a = 1 / 0;
        paramConfigDO.setParamType("mockType2");
        paramConfigDO.setParamKey(2);
        paramConfigDO.setParamValue("mockValue2");
        constantMapper.replaceInto(paramConfigDO);
    }

}
