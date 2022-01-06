package forum.service;

import forum.model.Post;
import forum.store.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Collection<Post> getAllPost() {
        List<Post> rsl = new ArrayList<>();
        postRepository.findAll().forEach(rsl::add);
        return rsl;
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public Post findPostById(int id) {
        return postRepository.findById(id).get();
    }
}
