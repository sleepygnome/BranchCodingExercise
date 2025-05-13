package com.exercise.branchcodingexercise.dto;

import com.exercise.branchcodingexercise.model.GithubUserRepo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
        "user_name", "display_name", "avatar", "geo_location",
        "email", "url", "created_at", "repos"
})
public class GithubUserResponse implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        @JsonProperty(value = "user_name")
        private String userName;
        @JsonProperty(value = "display_name")
        private String displayName;
        private String avatar;
        @JsonProperty(value = "geo_location")
        private String geoLocation;
        private String email;
        private String url;
        @JsonProperty(value = "created_at")
        private String createdAt;

        private List<GithubUserRepo> repos;
}
