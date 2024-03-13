package org.nuzhd.vktesttask.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class Album {

    Long id;
    Long userId;
    String title;

}
