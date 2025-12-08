package src.facebook.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Group {
    private String id;
    private String name;
    private String description;
    private User admin;
    private Set<User> user = new HashSet<User>();
    public Group() {

    }
    public Group(String name, String description, User admin) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.admin = admin;
    }
    public void addUser(User user) {
        this.user.add(user);
    }
    public void removeUser(User user) {
        this.user.remove(user);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
