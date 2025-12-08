package src.facebook.entities.Services;

import src.facebook.entities.Post;
import src.facebook.entities.Repository.PostRepository;
import src.facebook.entities.User;

public class PostService {
    private final PostRepository postRepository = PostRepository.getInstance();

    public Post create(User user, String text) {
        Post post = new Post(user, text);
        postRepository.savePost(post);
        user.savePost(post);
        return post;
    }

    public
}
