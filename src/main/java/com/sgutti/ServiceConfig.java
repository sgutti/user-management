/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sgutti.usermgt.UserService;
import com.sgutti.usermgt.UserServicePojo;

/**
 * @author Shanmu
 * @date Sep 15, 2018 11:30:25 PM
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.sgutti")
@ComponentScan("com.ecurve")
public class ServiceConfig {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>ServiceConfig</code>
     */
    public ServiceConfig() {
        super();
    }
    // ---------------------------------------------------------- Public Methods

    /**
     * @return
     */
    @Bean
    public UserService getUserService() {
        return new UserServicePojo();
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
