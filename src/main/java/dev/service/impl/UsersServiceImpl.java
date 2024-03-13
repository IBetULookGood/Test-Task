package dev.service.impl;
import dev.dao.user.User;
import dev.service.UsersService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UsersServiceImpl implements UsersService {
    private final WebClient client;

    public UsersServiceImpl() {
        this.client = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/users/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, "IBetULookGood")
                .build();
    }


    @Override
    @Cacheable("users")
    public ResponseEntity<List<User>> getUsers() {
        ResponseEntity<User[]> response = client.get()
                .retrieve()
                .toEntity(User[].class)
                .block();
        return new ResponseEntity<>(Arrays.stream(Objects.requireNonNull(Objects.requireNonNull(response).getBody())).toList(), response.getStatusCode());
    }

    @Override
    @Cacheable("users")
    public ResponseEntity<User> getUserById(Integer id) {
        return client.get()
                .uri(id.toString())
                .retrieve()
                .toEntity(User.class)
                .block();
    }

    @Override
    @CachePut("users")
    public ResponseEntity<User> create(User user) {
        return client.post()
                .body(BodyInserters.fromValue(user))
                .retrieve()
                .toEntity(User.class)
                .block();
    }

    @Override
    @CachePut("users")
    public ResponseEntity<Void> delete(Integer id) {
        return client.method(HttpMethod.DELETE)
                .uri(id.toString())
                .retrieve()
                .toEntity(Void.class)
                .block();
    }

    @Override
    @CachePut("users")
    public ResponseEntity<User> edit(Integer id, User user) {
        return client.put()
                .uri(id.toString())
                .body(BodyInserters.fromValue(user))
                .retrieve()
                .toEntity(User.class)
                .block();
    }
}
