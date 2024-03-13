package org.nuzhd.vktesttask.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.security.repo.AppUserRepository;
import org.nuzhd.vktesttask.security.service.AppUserService;
import org.nuzhd.vktesttask.security.user.AppUser;
import org.nuzhd.vktesttask.security.user.AppUserCreateRequest;
import org.nuzhd.vktesttask.security.user.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder encoder;

    @Override
    public AppUser createUser(AppUserCreateRequest appUserCreateRequest) {

        AppUser createdUser = AppUser.builder()
                .username(appUserCreateRequest.username())
                .password(encoder.encode(appUserCreateRequest.password()))
                .role(UserRole.valueOf(appUserCreateRequest.role()))
                .build();

        return appUserRepository.save(createdUser);
    }

}
