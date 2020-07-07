package com.pmb.general.common.interfaces.repository.mysql;

import com.pmb.general.common.domain.DO.ParamConfigDO;

import java.util.List;

/**
 * @author lvrui
 */
public interface ConstantMapper {

    Integer replaceInto(ParamConfigDO update);

    List<ParamConfigDO> queryList();

}
