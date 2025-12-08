package src.rbac;

import src.rbac.Enums.PERMISSION;
import src.rbac.Enums.ResourceType;
import src.rbac.Enums.Role;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//it will contain all the record of all users and permission and grousp
public class Policy {
    private static final Map<Role, Map<ResourceType, Set<PERMISSION>>> matrix =new HashMap<>();
    static  {
        // OWNER : full access to both General and AI resources
        Set<PERMISSION> all = EnumSet.allOf(PERMISSION.class);
        matrix.put(Role.OWNER, Map.of(ResourceType.GENERAL, all, ResourceType.AI, all));

        // Contributor
        Set<PERMISSION> contributorGenral = EnumSet.of(PERMISSION.READ, PERMISSION.EDIT, PERMISSION.PUSH, PERMISSION.USE_RESOURCE);
        matrix.put(Role.CONTRIBUTOR, Map.of(ResourceType.GENERAL, contributorGenral, ResourceType.AI, EnumSet.noneOf(PERMISSION.class)));

        // AI_DEVELOPER
        Set<PERMISSION> aiDevGen = contributorGenral;
        Set<PERMISSION> aiDev = EnumSet.of(PERMISSION.READ, PERMISSION.EDIT, PERMISSION.PUSH, PERMISSION.USE_RESOURCE, PERMISSION.USE_AI);
        matrix.put(Role.AI_DEVELOPER, Map.of(ResourceType.GENERAL, contributorGenral, ResourceType.AI, aiDev));

        public static boolean allowed(Role role1, ResourceType type1 , PERMISSION perm1) {
            return matrix.getOrDefault(role, Map.of())
                    .getOrDefault(type, Set.of())
                    .contains(perm);
        }
    }
}
