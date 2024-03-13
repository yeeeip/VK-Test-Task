package org.nuzhd.vktesttask.security.service;

import org.nuzhd.vktesttask.security.user.AppUser;
import org.nuzhd.vktesttask.security.user.AppUserCreateRequest;

public interface AppUserService {

    AppUser createUser(AppUserCreateRequest appUserCreateRequest);

}
