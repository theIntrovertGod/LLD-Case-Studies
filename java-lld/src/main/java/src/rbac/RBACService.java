package src.rbac;

import src.rbac.Entities.SubscriptionGroup;
import src.rbac.Entities.User;
import src.rbac.Enums.PERMISSION;

public class RBACService {
    private final InMemGroupDirectory directory;
    public RBACService(InMemGroupDirectory directory) {
        this.directory = directory;
    }
    // API
    public boolean can(User user, String groupId, String reourceId, PERMISSION perm {
        SubscriptionGroup group =
    }
}
