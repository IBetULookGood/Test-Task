package dev.controller;

import dev.dto.album.Album;
import dev.service.AlbumsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumsController {

    @Autowired
    private AlbumsService service;

    @PostMapping("/")
    public ResponseEntity<Album> create(@RequestBody Album album){
        var createdAlbum = service.create(album);
        return new ResponseEntity<>(createdAlbum.getBody(), createdAlbum.getStatusCode());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbum(@PathVariable Integer id){
        return service.getAlbum(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Album>> getAlbums(){
        return service.getAlbums();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> editUser(@PathVariable Integer id, @PathVariable Album album){
        return service.edit(id, album);
    }
}
