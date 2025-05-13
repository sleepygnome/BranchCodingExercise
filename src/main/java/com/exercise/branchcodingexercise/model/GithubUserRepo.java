package com.exercise.branchcodingexercise.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class GithubUserRepo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String url;
}