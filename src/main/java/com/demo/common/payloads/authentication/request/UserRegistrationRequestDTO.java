package com.demo.common.payloads.authentication.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * Only will be used as backend-to-authentication-microservice DTO.
 * Please create another POJO for communicating with front-end side
 */
@Data
@Builder
public class UserRegistrationRequestDTO {
    @NotNull(message="Username is required")
    @Size(min=4, max = 255, message = "Must be between 4 and 255 characters")
    private String username;
    @NotNull(message = "Password is required")
    @Size(min = 4, max = 255, message = "Must be between 4 and 255 characters")
    private String password;
    @NotNull(message = "Confirmation Password is required")
    @Size(min = 4, max = 255, message = "Must be between 4 and 255 characters")
    private String rePassword;
}
