package com.bob.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class HikariCPDataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String jdbcURL;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @RefreshScope
    public DataSource hikariDataSource() throws SQLException {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(jdbcURL);
        //hikariDataSource.setMaximumPoolSize();


        return hikariDataSource;
    }
}
