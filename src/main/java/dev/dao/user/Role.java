package dev.dao.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Role {
    ROLE_ADMIN(
            Set.of(
                    Permissions.ADMIN_DELETE,
                    Permissions.ADMIN_CREATE,
                    Permissions.ADMIN_UPDATE,
                    Permissions.ADMIN_READ
            )
    ),
    ROLE_USERS(
            Set.of(
                    Permissions.USERS_DELETE,
                    Permissions.USERS_CREATE,
                    Permissions.USERS_UPDATE,
                    Permissions.USERS_READ
            )
    ),
    ROLE_POSTS(
            Set.of(
                    Permissions.POSTS_CREATE,
                    Permissions.POSTS_DELETE,
                    Permissions.POSTS_UPDATE,
                    Permissions.POSTS_READ
            )
    ),
    ROLE_ALBUMS(
            Set.of(
                    Permissions.ALBUMS_CREATE,
                    Permissions.ALBUMS_DELETE,
                    Permissions.ALBUMS_UPDATE,
                    Permissions.ALBUMS_READ
            )
    )
    ;

    private final Set<Permissions> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority(this.name()));
        return authorities;
    }
}
