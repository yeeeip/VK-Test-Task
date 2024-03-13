package org.nuzhd.vktesttask.entity;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class User {

    Long id;
    String name;
    String username;
    String email;
    Address address;
    String phone;
    String website;
    Company company;
}
