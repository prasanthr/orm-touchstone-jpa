package com.byteclarity.ormtouchstone.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.byteclarity.ormtouchstone.model1.repo.EmployeeRepository;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
public class JpaConfig  {
	
	@Bean
    public DataSource configureDataSource() {
    	//replace this with oracle.jdbc.pool.OracleDataSource    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource; 
	
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()  {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(configureDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.byteclarity.ormtouchstone.model1");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "create");
        //jpaProperties.put(org.hibernate.cfg.Environment.STATEMENT_BATCH_SIZE, AppConstants.BATCH_UPDATE_SIZE);
        //jpaProperties.put(org.hibernate.cfg.Environment.STATEMENT_FETCH_SIZE, "10000");
        jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
        
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
    
    /*@Bean
    public PlatformTransactionManager transactionManager() {
        //return annotationDrivenTransactionManager();
    	JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
         entityManagerFactory().getObject() );
        return transactionManager;
    }*/

    //@Override
    //public PlatformTransactionManager annotationDrivenTransactionManager() {
      //  return new JpaTransactionManager(entityManagerFactoryBean().getObject());
    //}
}
