package src.rbac.Entities;

import java.util.HashSet;
import java.util.Set;

public class SubscriptionGroup {
    private final String id, name;
    private final Set<Resource> resources = new HashSet<>();
    public SubscriptionGroup(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
