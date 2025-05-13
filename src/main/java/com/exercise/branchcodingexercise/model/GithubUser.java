package com.exercise.branchcodingexercise.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class GithubUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "login")
    private String userName;
    @JsonProperty(value = "name")
    private String displayName;
    @JsonProperty(value = "avatar_url")
    private String avatar;
    @JsonProperty(value = "location")
    private String geoLocation;
    private String email;
    private String url;
    @JsonProperty(value = "created_at")
    private String createdAt;

    private List<GithubUserRepo> repos;
}