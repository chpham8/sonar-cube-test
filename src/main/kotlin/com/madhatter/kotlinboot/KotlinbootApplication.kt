package com.madhatter.kotlinboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.filter.CorsFilter
import org.springframework.core.Ordered

@SpringBootApplication
class KotlinbootApplication {
    @Bean
    fun simpleCorsFilter(): FilterRegistrationBean<CorsFilter> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.allowedOrigins = listOf("http://animal-client-terrific-panther.cfapps.io")
        config.allowedMethods = listOf("*")
        config.allowedHeaders = listOf("*")
        source.registerCorsConfiguration("/**", config)
        val bean = FilterRegistrationBean(CorsFilter(source))
        bean.order = Ordered.HIGHEST_PRECEDENCE
        return bean
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinbootApplication>(*args)
}
