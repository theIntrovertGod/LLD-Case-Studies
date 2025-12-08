package src.rbac;

import src.rbac.Entities.Resource;
import src.rbac.Entities.SubscriptionGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemGroupDirectory {
    private final Map<String, SubscriptionGroup> groups = new HashMap<>();
    private final Map<String, Resource> resources = new HashMap<>();
    public void addGroup(SubscriptionGroup group) {
        groups.put(group.getId(), group);
    }
    public void addResource(Resource resource) {
        resources.put(resource.getId(), resource);
    }
    public Optional<SubscriptionGroup> findGroup(String id) {
        return Optional.ofNullable(groups.get(id));
    }
    public Optional<Resource> findResource(String id) {
        return Optional.ofNullable(resources.get(id));
    }
}
