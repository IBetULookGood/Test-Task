package dev.dao.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permissions {
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    USERS_READ("users:read"),
    USERS_CREATE("users:create"),
    USERS_UPDATE("users:update"),
    USERS_DELETE("users:delete"),
    POSTS_READ("posts:read"),
    POSTS_CREATE("posts:create"),
    POSTS_UPDATE("posts:update"),
    POSTS_DELETE("posts:delete"),
    ALBUMS_READ("albums:read"),
    ALBUMS_CREATE("albums:create"),
    ALBUMS_UPDATE("albums:update"),
    ALBUMS_DELETE("albums:delete"),
    ;

    private final String permission;
}
