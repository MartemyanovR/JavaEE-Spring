package carsManager.config;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"carsManager.service" , "carsManager.dao"})
@EnableTransactionManagement
public class HibernateConf {
	private static Logger logger = LoggerFactory.getLogger(HibernateConf.class);
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		 LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	     sessionFactory.setDataSource(dataSource());
	     sessionFactory.setPackagesToScan("carManager.model");
	     sessionFactory.setHibernateProperties(hibernateProperties());

	    return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource() {
		Properties properties = new Properties();
		try(InputStream inputStream = HibernateConf.class.getClassLoader().getResourceAsStream("application.properties") ) {	
			properties.load(inputStream);			
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("username");
			String password = properties.getProperty("password");
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
		    dataSource.setUrl(url);
		    dataSource.setUsername(user);
		    dataSource.setPassword(password);
		    return  dataSource;
		} catch(Exception e) {
			logger.error("DBCP DataSource bean cannot be created. " + e);
			return null;
		}	    
	}
	
	@Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "upadte");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return hibernateProperties;
    }
	
	
}
