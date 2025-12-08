package src.facebook.entities;

import java.util.*;

public class User {
    private final String userId;
    private final String name;
    private final String email;
    private final Set<User> friends = new HashSet<>();
    private final List<Post> posts =  new ArrayList<>();
    public User( String name, String email) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }
    public String getUserId() {
        return userId;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void savePost(Post post) {
        posts.add(post);
    }
}
