package forum.service;

import forum.model.Post;
import forum.repositoy.PostMem;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostService {

    private final PostMem postMem;

    public PostService(PostMem postMem) {
        this.postMem = postMem;
    }

    public Collection<Post> getAllPost() {
        return postMem.getAllPosts();
    }

    public void addPost(Post post) {
        postMem.addPost(post);
    }

    public Post findPostById(int id) {
        return postMem.findPostById(id);
    }
}
