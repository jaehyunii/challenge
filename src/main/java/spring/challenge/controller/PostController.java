package spring.challenge.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.challenge.dto.PostRequest;
import spring.challenge.entity.User;
import spring.challenge.service.PostService;
import spring.challenge.service.UserService;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody PostRequest request) {
        log.info("title = {}, contents = {}, userId = {}", request.getPostTitle(), request.getPostContent(), request.getUserId());
        Optional<User> user = userService.getUserFromUserId(request.getUserId());
        if(postService.register(request, user.get()).equals("Success")){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity postList() {
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @PatchMapping("/{postId}")
    public ResponseEntity postUpdate(@PathVariable Long postId, @RequestBody PostRequest request){
        log.info("postId = {}", postId);
        log.info("update title = {}, update contents = {}", request.getPostTitle(), request.getPostContent());
        if(postService.postUpdate(postId, request).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity postDelete(@PathVariable Long postId){
        log.info("postId = {}", postId);
        if(postService.postDelete(postId).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
