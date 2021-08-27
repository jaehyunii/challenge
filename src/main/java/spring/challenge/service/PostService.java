package spring.challenge.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.challenge.dto.PostListResponse;
import spring.challenge.dto.PostRequest;
import spring.challenge.entity.Post;
import spring.challenge.entity.User;
import spring.challenge.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public String register(PostRequest request, User user) {
        postRepository.save(Post.builder()
                .postTitle(request.getPostTitle())
                .postContent(request.getPostContent())
                .user(user)
                .build());
        return "Success";
    }

    public List<PostListResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostListResponse> postList = new ArrayList<>();

        for (Post p : posts) {
            PostListResponse post = new PostListResponse();
            post.setPostId(p.getSeq());
            post.setPostTitle(p.getPostTitle());
            post.setPostContent(p.getPostContent());
            post.setUserName(p.getUser().getUserName());
            postList.add(post);
        }
        return postList;
    }

    public String postUpdate(Long postId, PostRequest request) {
        Optional<Post> post = postRepository.findById(postId);
        request.updateEntity(post.get());
        postRepository.save(post.get());
        return "Success";
    }

    public String postDelete(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        postRepository.delete(post.get());
        return "Success";
    }
}
