/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Shanmu
 * @date Sep 14, 2018 2:32:31 PM
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.sgutti.usermgt.dao")
@PropertySource("classpath:database.properties")
@ComponentScan("com.sgutti.usermgt")
public class JPAConfig {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private Environment env;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>JPAConfig </code>
     */
    public JPAConfig() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
        lcemfb.setDataSource(getDataSource());
        lcemfb.setPackagesToScan("com.sgutti");
        lcemfb.setJpaProperties(jpaProperties());
        return lcemfb;
    }

    @Bean(name = "mapper")
    public Mapper getMapper() {
        List<String> mappingFiles = Arrays.asList("dozerBeanMappings.xml");
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("database.driverClassName"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.username"));
        dataSource.setPassword(env.getProperty("database.password"));
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager() {
        return new JpaTransactionManager(
                getEntityManagerFactoryBean().getObject());
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql",
                env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql",
                env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.id.new_generator_mappings",
                env.getProperty("hibernate.id.new_generator_mappings"));
        properties.put("hibernate.ddl-auto",
                env.getProperty("hibernate.ddl-auto"));
        return properties;
    }
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
