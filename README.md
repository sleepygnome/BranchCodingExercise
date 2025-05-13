Decisions: 
    -added caching on calls to github to return faster and help mitigate rate limiting (for this example)
    -set different TTL based on the call 
        - profile should change less frequently than repos
        - ttl values based on the length of this exercise

To run:
    open terminal and execute from project directory:
        ./gradlew bootrun

    GET http://localhost:8080/search/v1/user/{username}

To add:
    given I had about an hour of free time to get this done, it is missing things like: 
    - OAuth2 for my controller
    - more robust testing (typically I follow TDD, but not in this exercise, due to time)
    - multi instance caching implementation (Redis, etc)
    - swagger for api documentation and testing