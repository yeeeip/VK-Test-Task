package org.nuzhd.vktesttask.security.user;

public record AppUserCreateRequest(String username, String password, String role) {
}
