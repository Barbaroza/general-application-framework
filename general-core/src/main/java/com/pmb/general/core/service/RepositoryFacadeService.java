package com.pmb.general.core.service;

import com.pmb.general.common.interfaces.repository.mysql.ConstantMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lvrui
 */
@Service
public class RepositoryFacadeService {
    @Resource
    private ConstantMapper constantMapper;

    public ConstantMapper getConstantMapper() {
        return constantMapper;
    }
}
