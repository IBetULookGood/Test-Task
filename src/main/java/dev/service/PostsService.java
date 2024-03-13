package dev.service;

import dev.dto.post.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostsService {
    ResponseEntity<List<Post>> getPosts();
    ResponseEntity<Post> getPost(Integer id);
    ResponseEntity<Post> create(Post post);

    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Post> edit(Integer id, Post post);
}
