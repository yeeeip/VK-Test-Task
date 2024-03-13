package org.nuzhd.vktesttask.controller;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.security.service.AppUserService;
import org.nuzhd.vktesttask.security.user.AppUser;
import org.nuzhd.vktesttask.security.user.AppUserCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AppUserService appUserService;

    @PostMapping("/addUser")
    public ResponseEntity<AppUser> addUser(AppUserCreateRequest appUserCreateRequest) {
        AppUser savedUser = appUserService.createUser(appUserCreateRequest);

        return ResponseEntity
                .ok(savedUser);
    }

}
