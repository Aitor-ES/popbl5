/**
 * @file HibernateApplicationConfiguration.java
 * @brief Hibernate configuration file
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.configuration
 */

package edu.mondragon.test.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import edu.mondragon.test.entity.TestEntity;

@Configuration
@PropertySource("classpath:db_test.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("edu.mondragon.test.entity") })
public class HibernateTestConfig {

	/**
	 * @brief Env variable
	 */
	@Autowired
	private Environment env;

	/**
	 * @brief Configuration of data source, the access to the data base
	 * @return DataSource
	 */
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}

	/**
	 * @brief This method gets the session factory
	 * @return LocalSessionFactoryBean
	 */
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

		factoryBean.setHibernateProperties(hibernateProperties);
		factoryBean.setAnnotatedClasses(TestEntity.class);

		return factoryBean;
	}

	/**
	 * @brief This method manages the hibernate transactions
	 * @return HibernateTransactionManager
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}