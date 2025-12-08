package src.facebook.entities.Services;

import src.facebook.entities.Repository.UserRepository;
import src.facebook.entities.User;

public class UserService {
    private final UserRepository userRepository = UserRepository.getInstance();

    public User saveUser(String email, String name) {
        User user = new User(name, email);
        userRepository.saveUser(user);
        return user;
    }

    public void addFriend (String userId1, String userId2) {
        User user1 = userRepository.getUser(userId1);
        User user2 = userRepository.getUser(userId2);

        user2.addFriend(user1);
        user1.addFriend(user2);
    }

    public User getUser(String userId) {
        return userRepository.getUser(userId);
    }
}
