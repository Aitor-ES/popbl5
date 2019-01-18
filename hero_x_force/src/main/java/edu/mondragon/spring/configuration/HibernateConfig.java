/**
 * @file HibernateConfig.java
 * @brief Hibernate configuration class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.spring.configuration
 */

package edu.mondragon.spring.configuration;

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

import edu.mondragon.ability.Ability;
import edu.mondragon.achievement.Achievement;
import edu.mondragon.card.Card;
import edu.mondragon.deck.Deck;
import edu.mondragon.deckcardmap.DeckCardMap;
import edu.mondragon.match.Match;
import edu.mondragon.tournament.Tournament;
import edu.mondragon.user.User;
import edu.mondragon.userachievementmap.UserAchievementMap;
import edu.mondragon.usercardmap.UserCardMap;
import edu.mondragon.usertournamentmap.UserTournamentMap;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("edu.mondragon.ability"),
		@ComponentScan("edu.mondragon.achievement"),
		@ComponentScan("edu.mondragon.card"),
		@ComponentScan("edu.mondragon.deck"),
		@ComponentScan("edu.mondragon.deckcardmap"),
		@ComponentScan("edu.mondragon.email"),
		@ComponentScan("edu.mondragon.match"),
		@ComponentScan("edu.mondragon.tournament"),
		@ComponentScan("edu.mondragon.user"),
		@ComponentScan("edu.mondragon.userachievementmap"),
		@ComponentScan("edu.mondragon.usercardmap"),
		@ComponentScan("edu.mondragon.usertournamentmap") })
public class HibernateConfig {

	/**
	 * @brief Env Interface representing the environment in which the current application is running
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
	 * @brief This method gets FactoryBean that creates a Hibernate SessionFactory
	 * @return LocalSessionFactoryBean
	 */
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.put("hibernate.enable_lazy_load_no_trans", env.getProperty("hibernate.enable_lazy_load_no_trans"));

		factoryBean.setHibernateProperties(hibernateProperties);
		factoryBean.setAnnotatedClasses(User.class, Achievement.class, UserAchievementMap.class,
				Ability.class, Card.class, UserCardMap.class,
				Deck.class,	DeckCardMap.class,
				Tournament.class, UserTournamentMap.class,
				Match.class);

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