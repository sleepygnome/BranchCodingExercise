package com.exercise.branchcodingexercise.service


import com.exercise.branchcodingexercise.model.GithubUser
import com.exercise.branchcodingexercise.model.GithubUserRepo
import org.springframework.web.client.RestClientException
import spock.lang.Specification

class GithubUserSearchServiceSpec extends Specification {
    def mockClient = Mock(GithubUserSearchClient)
    def apiService = new GithubUserSearchService(mockClient)

    def "should return complete user info with profile and repos"() {
        given:
        def user = new GithubUser(userName: "octocat", displayName: "Octo")
        def repos = [new GithubUserRepo(name: "repo1", url: "http://repo1")]
        user.setRepos(repos)

        mockClient.getUserProfile("octocat") >> user
        mockClient.getUserRepos("octocat") >> repos.toArray()

        when:
        def result = apiService.getCompleteUserInfo("octocat")

        then:
        result.userName == "octocat"
        result.repos*.name == ["repo1"]
    }

    def "should throw exception if username is null"() {
        when:
        apiService.getCompleteUserInfo(null)

        then:
        thrown(IllegalStateException)
    }

    def "should propagate error if profile API fails"() {
        given:
        mockClient.getUserProfile("user") >> { throw new RestClientException("fail") }

        when:
        apiService.getCompleteUserInfo("user")

        then:
        thrown(RestClientException)
    }
}
