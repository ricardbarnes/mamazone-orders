package cat.vonblum.mamazone.orders.consumer.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource

@Configuration
class SpringConsumerDatabaseConfig {

    @Bean
    fun driverManagerDataSource(
        @Value("\${spring.datasource.url}") url: String,
        @Value("\${spring.datasource.username}") username: String,
        @Value("\${spring.datasource.password}") password: String
    ): DriverManagerDataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.postgresql.Driver")
        dataSource.url = url
        dataSource.username = username
        dataSource.password = password
        return dataSource
    }

    @Bean
    fun jdbcTemplate(driverManagerDataSource: DriverManagerDataSource): JdbcTemplate {
        return JdbcTemplate(driverManagerDataSource)
    }

}