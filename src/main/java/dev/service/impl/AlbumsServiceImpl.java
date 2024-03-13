package dev.service.impl;

import dev.dto.album.Album;
import dev.service.AlbumsService;
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
public class AlbumsServiceImpl implements AlbumsService {

    private final WebClient client;

    public AlbumsServiceImpl() {
        this.client = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/albums/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, "IBetULookGood")
                .build();
    }

    @Override
    @Cacheable("albums")
    public ResponseEntity<List<Album>> getAlbums() {
        ResponseEntity<Album[]> response = client.get()
                .retrieve()
                .toEntity(Album[].class)
                .block();
        return new ResponseEntity<>(Arrays.stream(Objects.requireNonNull(Objects.requireNonNull(response).getBody())).toList(), response.getStatusCode());

    }

    @Override
    @Cacheable("albums")
    public ResponseEntity<Album> getAlbum(Integer id) {
        return client.get()
                .uri(id.toString())
                .retrieve()
                .toEntity(Album.class)
                .block();
    }


    @Override
    @CachePut("albums")
    public ResponseEntity<Album> create(Album al) {
        return client.post()
                .body(BodyInserters.fromValue(al))
                .retrieve()
                .toEntity(Album.class)
                .block();
    }

    @Override
    @CachePut("albums")
    public ResponseEntity<Void> delete(Integer id) {
        return client.method(HttpMethod.DELETE)
                .uri(id.toString())
                .retrieve()
                .toEntity(Void.class)
                .block();
    }

    @Override
    @CachePut("albums")
    public ResponseEntity<Album> edit(Integer id, Album album) {
        return client.put()
                .uri(id.toString())
                .body(BodyInserters.fromValue(album))
                .retrieve()
                .toEntity(Album.class)
                .block();
    }
}
