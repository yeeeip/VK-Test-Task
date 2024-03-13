package org.nuzhd.vktesttask.dto.post;

public record PostPatchRequest(Long userId, String title, String body) {
}
