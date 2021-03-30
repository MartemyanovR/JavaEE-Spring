package carsManager.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import carsManager.dao.CarDao;
import carsManager.dao.CarDaoImpl;
import carsManager.service.CarService;
import carsManager.service.CarServiceImpl;

@Configuration
@PropertySource({"classpath:connect.properties"})
@EnableTransactionManagement
public class HibernateConf {
	private static Logger logger = LoggerFactory.getLogger(HibernateConf.class);
	
	@Value("${driver}")
	private String driver;
	
	@Value("${url}")
	private String url;
	
	@Value("${userName}")
	private String userName;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		 LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	     sessionFactory.setDataSource(dataSource());
	     sessionFactory.setPackagesToScan("carsManager.model");
	     sessionFactory.setHibernateProperties(hibernateProperties());

	    return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource() {		
		try {				
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
		    dataSource.setUrl(url);
		    dataSource.setUsername(userName);
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
          "hibernate.hbm2ddl.auto", "create-drop");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        return hibernateProperties;
    }
    
    @Bean
    public CarDao carDaoImpl() {return new CarDaoImpl(); }
    @Bean
    public CarService carServiceImpl() {return new CarServiceImpl(); }
	
}
