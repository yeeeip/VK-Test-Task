package org.nuzhd.vktesttask.dto.user;

import org.nuzhd.vktesttask.entity.Address;
import org.nuzhd.vktesttask.entity.Company;

public record UserUpdateRequest(String name, String username, String email, Address address, String phone,
                                String website, Company company) {
}
