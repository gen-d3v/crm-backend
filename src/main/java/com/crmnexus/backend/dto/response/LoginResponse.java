package com.crmnexus.backend.dto.response;

import com.crmnexus.backend.enums.Role;

public record LoginResponse (Long userId, String username, Role role) {
}
