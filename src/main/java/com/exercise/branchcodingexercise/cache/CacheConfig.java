package com.exercise.branchcodingexercise.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {


    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        CaffeineCache userProfilesCache = new CaffeineCache("githubUser",
                Caffeine.newBuilder()
                        .expireAfterWrite(10, TimeUnit.MINUTES)
                        .maximumSize(1000)
                        .build());

        CaffeineCache userReposCache = new CaffeineCache("userRepos",
                Caffeine.newBuilder()
                        .expireAfterWrite(1, TimeUnit.MINUTES)
                        .maximumSize(1000)
                        .build());

        cacheManager.setCaches(Arrays.asList(userProfilesCache, userReposCache));
        return cacheManager;
    }
}
