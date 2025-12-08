package src.rbac.Entities;

import src.rbac.Enums.Role;

public class RoleAssingment {
    private final String groupId;
    private final Role role;

    public RoleAssingment(String groupId, Role role) {
        this.groupId = groupId;
        this.role = role;
    }
}
