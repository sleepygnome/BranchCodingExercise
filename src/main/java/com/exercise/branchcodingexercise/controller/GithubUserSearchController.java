package com.exercise.branchcodingexercise.controller;

import com.exercise.branchcodingexercise.mapper.GithubUserResponseMapper;
import com.exercise.branchcodingexercise.model.GithubUser;
import com.exercise.branchcodingexercise.service.GithubUserSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search/v1/")
@RequiredArgsConstructor
public class GithubUserSearchController {

    private final GithubUserSearchService githubUserSearchService;

    @GetMapping(path = "/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserData(@PathVariable String username) {
        try {
            GithubUser githubUser = githubUserSearchService.getCompleteUserInfo(username);
            return ResponseEntity.ok(GithubUserResponseMapper.toResponse(githubUser));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to fetch user data.");
        }
    }
}