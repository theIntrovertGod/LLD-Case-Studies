package src.rbac.Entities;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String id, email;
//    private final
    private final Set<RoleAssingment> assignments = new HashSet<>();
    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }
}
