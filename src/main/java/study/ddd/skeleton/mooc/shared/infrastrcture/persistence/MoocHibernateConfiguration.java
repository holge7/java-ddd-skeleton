package study.ddd.skeleton.mooc.shared.infrastrcture.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import study.ddd.skeleton.shared.infrastructure.config.Parameter;
import study.ddd.skeleton.shared.infrastructure.config.ParameterNotExist;
import study.ddd.skeleton.shared.infrastructure.hibernate.HibernateConfigurationFactory;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class MoocHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter config;
    private final String CONTEXT_NAME = "mooc";

    public MoocHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("mooc-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("mooc-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("mooc-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
//    TODO: descomentar y usar esto
        return factory.dataSource(
            config.get("MOOC_DATABASE_HOST"),
            config.getInt("MOOC_DATABASE_PORT"),
            config.get("MOOC_DATABASE_NAME"),
            config.get("MOOC_DATABASE_USER"),
            config.get("MOOC_DATABASE_PASSWORD"),
            config.get("MOOC_DATABASE_SCHEMA")
        );
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/ddd"); // 'ddd' es el nombre de la base de datos
//        dataSource.setUsername("admin");
//        dataSource.setPassword("admin");
//        dataSource.setSchema("public");
//        return dataSource;
    }
}