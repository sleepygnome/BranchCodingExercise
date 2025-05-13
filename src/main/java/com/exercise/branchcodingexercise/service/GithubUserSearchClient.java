package com.exercise.branchcodingexercise.service;

import com.exercise.branchcodingexercise.model.GithubUser;
import com.exercise.branchcodingexercise.model.GithubUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GithubUserSearchClient {
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String BASE_GITHUB_USERS_URL = "https://api.github.com/users/";
    private static final String GITHUB_USER_REPO_URL = "/repos";


    @Cacheable("githubUser")
    public GithubUser getUserProfile(String username) {
        if (username == null) throw new IllegalArgumentException("Username must not be null");

        log.info("Fetching user profile for {}", username);
        return restTemplate.getForObject(BASE_GITHUB_USERS_URL + username, GithubUser.class);
    }

    @Cacheable("userRepos")
    public GithubUserRepo[] getUserRepos(String username) {
        if (username == null) throw new IllegalArgumentException("Username must not be null");

        log.info("Fetching repos for {}", username);
        return restTemplate.getForObject(BASE_GITHUB_USERS_URL + username + GITHUB_USER_REPO_URL, GithubUserRepo[].class);
    }
}
