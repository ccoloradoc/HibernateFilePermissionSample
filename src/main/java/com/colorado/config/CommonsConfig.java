package com.colorado.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by colorado on 12/03/17.
 */
@Configuration
@EnableJpaRepositories("com.colorado.repository")
public class CommonsConfig {

}
