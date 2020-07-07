package com.pmb.general.common.domain.DO;

import lombok.Data;

/**
 * @author lvrui
 */
@Data
public class ParamConfigDO {
    private Long id;
    private String paramType;
    private Integer paramKey;
    private String paramValue;
}
