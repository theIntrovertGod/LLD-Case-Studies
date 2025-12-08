package src.facebook.entities.Repository;

import src.facebook.entities.Post;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostRepository {
    private static final PostRepository instance = new PostRepository();
    private final Map<String, Post> posts = new ConcurrentHashMap<>();

    public static PostRepository getInstance() {
        return instance;
    }
    private PostRepository() {}

    public Post getPost(String id) {
        return posts.get(id);
    }
    public void savePost(Post post) {
        posts.put(post.getId(), post);
    }
}
