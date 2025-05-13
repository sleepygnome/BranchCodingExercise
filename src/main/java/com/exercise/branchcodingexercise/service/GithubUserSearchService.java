package com.exercise.branchcodingexercise.service;

import com.exercise.branchcodingexercise.model.GithubUser;
import com.exercise.branchcodingexercise.model.GithubUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubUserSearchService {
    private final GithubUserSearchClient userSearchClient;

    public GithubUser getCompleteUserInfo(String username) {
        GithubUser profile = userSearchClient.getUserProfile(username);
        if (profile == null) throw new IllegalStateException("User profile not found");

        GithubUserRepo[] repos = userSearchClient.getUserRepos(username);
        profile.setRepos(Arrays.asList(repos));

        return profile;
    }
}