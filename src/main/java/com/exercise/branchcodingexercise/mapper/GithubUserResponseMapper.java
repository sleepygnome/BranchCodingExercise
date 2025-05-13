package com.exercise.branchcodingexercise.mapper;

import com.exercise.branchcodingexercise.dto.GithubUserResponse;
import com.exercise.branchcodingexercise.model.GithubUser;

public class GithubUserResponseMapper {
    public static GithubUserResponse toResponse(GithubUser user) {
        if (user == null) return null;

        return new GithubUserResponse(
                user.getUserName(),
                user.getDisplayName(),
                user.getAvatar(),
                user.getGeoLocation(),
                user.getEmail(),
                user.getUrl(),
                user.getCreatedAt(),
                user.getRepos()
        );
    }
}
