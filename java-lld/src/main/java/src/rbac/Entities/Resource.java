package src.rbac.Entities;

import src.rbac.Enums.ResourceType;

public class Resource {
    private final String id, name;
    private final ResourceType type;

    public Resource(String id, String name, ResourceType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
