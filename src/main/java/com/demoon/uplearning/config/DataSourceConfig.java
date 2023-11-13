package com.demoon.uplearning.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("jpaDataSourceProperties")
    @ConfigurationProperties("app.datasource.jpa")
    public DataSourceProperties jpaDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("jpaDataSource")
    public DataSource jpaDataSource(@Qualifier("jpaDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().type(MysqlDataSource.class).build();
    }

    @Bean("flowableDataSourceProperties")
    @ConfigurationProperties("app.datasource.flowable")
    public DataSourceProperties flowableDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("flowableDataSource")
    @Primary
    public DataSource flowableDataSource(@Qualifier("flowableDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().type(MysqlDataSource.class).build();
    }
}
