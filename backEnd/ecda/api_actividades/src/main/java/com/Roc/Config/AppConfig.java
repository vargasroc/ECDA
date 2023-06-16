package com.Roc.Config;

import com.Roc.repository.ActividadRepository;
import com.Roc.repository.ContenidoRepository;
import com.Roc.repository.SemanaRepository;
import com.Roc.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.Roc.repository")
public class AppConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.Roc.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

   /* @Bean
    public ActividadService actividadService(ActividadRepository actividadRepository) {
        return new ActividadServiceImpl(actividadRepository);
    }

    @Bean
    public ContenidoService contenidoService(ContenidoRepository contenidoRepository) {
        return new ContenidoServiceImpl(contenidoRepository);
    }

    @Bean
    public SemanaService semanaService(SemanaRepository semanaRepository) {
        return new SemanaServiceImpl(semanaRepository);
    }
*/
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/apicitas");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
