package com.pmb.general.repository.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;

/**
 * @author lvrui
 */
@Configuration
public class TransactionConfiguration implements TransactionManagementConfigurer {

    @Resource
    @Qualifier("mysqlTransactionManager")
    private PlatformTransactionManager mysqlTransactionManager;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return mysqlTransactionManager;
    }
}
