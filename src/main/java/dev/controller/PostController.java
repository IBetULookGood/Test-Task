package dev.controller;

import dev.dto.post.Post;
import dev.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    @Autowired
    private PostsService service;

    @PostMapping("/")
    public ResponseEntity<Post> create(@RequestBody Post post){
        var createdPost = service.create(post);
        return new ResponseEntity<>(createdPost.getBody(), createdPost.getStatusCode());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id ){
        return service.getPost(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getPosts(){
        return service.getPosts();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> editUser(@PathVariable Integer id, @PathVariable Post post){
        return service.edit(id, post);
    }
}
