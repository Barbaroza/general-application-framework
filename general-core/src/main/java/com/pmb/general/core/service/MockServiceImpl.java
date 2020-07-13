package com.pmb.general.core.service;

import com.pmb.general.common.domain.DO.ParamConfigDO;
import com.pmb.general.common.interfaces.core.MockService;
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
    private RepositoryFacadeService repositoryFacadeService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void mock() {
        List<ParamConfigDO> paramConfTransactional = repositoryFacadeService.getConstantMapper().queryList();
        ParamConfigDO paramConfigDO = new ParamConfigDO();
        paramConfigDO.setParamType("mockType");
        paramConfigDO.setParamKey(1);
        paramConfigDO.setParamValue("mockValue");
        repositoryFacadeService.getConstantMapper().replaceInto(paramConfigDO);
        int a = 1 / 0;
        paramConfigDO.setParamType("mockType2");
        paramConfigDO.setParamKey(2);
        paramConfigDO.setParamValue("mockValue2");
        repositoryFacadeService.getConstantMapper().replaceInto(paramConfigDO);
    }

}
