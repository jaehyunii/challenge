package spring.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.challenge.entity.Post;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class PostRequest {
    private String postTitle;
    private String postContent;
    private String userId;

    public void updateEntity(Post post) {
        post.setPostTitle(this.postTitle);
        post.setPostContent(this.postContent);
    }
}
