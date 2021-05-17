package space.nov29.cataria.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.nov29.cataria.dto.PostDto;
import space.nov29.cataria.service.PostService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/getAll")
    public ResponseEntity<List<PostDto>> showAllPost() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @PostMapping("/post/create")
    public ResponseEntity createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/post/update")
    public ResponseEntity updatePost(@RequestBody PostDto postDto) {
        postService.updatePost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}