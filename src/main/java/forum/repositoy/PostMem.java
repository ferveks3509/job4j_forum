package forum.repositoy;

import forum.model.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMem {
    private final Map<Integer, Post> posts = new HashMap<>();
    private AtomicInteger postId = new AtomicInteger(1);

    public PostMem() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String  formatDate = now.format(formatter);
        Post post = Post.of("продаю ладу");
        Post post1 = Post.of("Общение");
        post1.setCreated(formatDate);
        post.setCreated(formatDate);
        post1.setDescription("Природа");
        post.setDescription("Лада 2020 года");
        post.setId(0);
        post1.setId(1);
        post1.addComment("Дождливый день");
        post.addComment("Com1");
        post.addComment("Com2");
        posts.put(0, post);
        posts.put(1, post1);
    }

    public Collection<Post> getAllPosts() {
        return posts.values();
    }

    public void addPost(Post post) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String  formatDate = now.format(formatter);
        post.setCreated(formatDate);
        if (post.getId() == 0) {
            post.setId(postId.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public void deletePostById(int id) {
        posts.remove(id);
    }
}
