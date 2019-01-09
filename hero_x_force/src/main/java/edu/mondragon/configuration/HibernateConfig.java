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

package edu.mondragon.configuration;

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

import edu.mondragon.model.Ability;
import edu.mondragon.model.Achievement;
import edu.mondragon.model.Card;
import edu.mondragon.model.Deck;
import edu.mondragon.model.DeckCardMap;
import edu.mondragon.model.Match;
import edu.mondragon.model.Tournament;
import edu.mondragon.model.User;
import edu.mondragon.model.UserAchievementMap;
import edu.mondragon.model.UserCardMap;
import edu.mondragon.model.UserMatchMap;
import edu.mondragon.model.UserTournamentMap;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("edu.mondragon.dao"), @ComponentScan("edu.mondragon.service"), @ComponentScan("edu.mondragon.model") })
public class HibernateConfig {

	/**
	 * @brief Env variable
	 */
	@Autowired
	private Environment env;

	/**
	 * @brief Configuration of data source
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

		Properties hibernateProperties  = new Properties();
		hibernateProperties .put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		hibernateProperties .put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

		factoryBean.setHibernateProperties(hibernateProperties);
		factoryBean.setAnnotatedClasses(Ability.class, Achievement.class, Card.class, Deck.class, DeckCardMap.class, Match.class, Tournament.class, User.class, UserAchievementMap.class, UserCardMap.class, UserMatchMap.class, UserTournamentMap.class);
		
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