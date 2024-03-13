package org.nuzhd.vktesttask.entity;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class Post {
    Long id;
    Long userId;
    String title;
    String body;
}
