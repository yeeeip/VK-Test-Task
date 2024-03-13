package org.nuzhd.vktesttask.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class Company {

    String name;
    String catchPhrase;
    String bs;

}
