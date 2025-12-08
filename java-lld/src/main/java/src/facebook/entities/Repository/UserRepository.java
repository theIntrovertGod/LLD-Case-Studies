package src.facebook.entities.Repository;

import src.facebook.entities.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private static final UserRepository INSTANCE = new UserRepository();
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private UserRepository() {}
    public static UserRepository getInstance() {
        return INSTANCE;
    }
    public void saveUser(User user) {
        users.put(user.getUserId(),user);
    }
    public User getUser(String userId) {
        return users.get(userId);
    }


}
