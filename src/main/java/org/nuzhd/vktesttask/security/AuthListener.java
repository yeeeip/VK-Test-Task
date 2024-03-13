package org.nuzhd.vktesttask.security;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.entity.AuditEntry;
import org.nuzhd.vktesttask.repo.AuditEntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class AuthListener implements ApplicationListener<AbstractAuthenticationEvent> {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final AuditEntryRepository auditRepository;

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {

        AuditEntry.AuditEntryBuilder builder = AuditEntry.builder()
                .timestamp(Instant.ofEpochMilli(event.getTimestamp())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime()
                )
                .username(event.getAuthentication().getName());

        if (event instanceof AuthenticationSuccessEvent) {
            builder.success(true);
        }
        if (event instanceof AuthenticationFailureBadCredentialsEvent) {
            builder.success(false).reason("Bad credentials");
        }

        AuditEntry auditEntry = builder.build();

        logger.info(auditEntry.toString());
        auditRepository.save(auditEntry);
    }
}
