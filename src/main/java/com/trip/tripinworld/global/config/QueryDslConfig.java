package com.trip.tripinworld.global.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {
    private final EntityManager entitymanager;

    @Bean
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(entitymanager);
    }
}
