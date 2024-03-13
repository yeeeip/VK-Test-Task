package org.nuzhd.vktesttask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;


@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AuditEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime timestamp;
    String username;
    Boolean success;
    String reason;

}
