package com.demo.common.payloads.authentication.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * Only will be used as authentication-microservice-to-another-microservice DTO.
 * Please create another POJO for communicating with front-end side
 */
@Data
@SuperBuilder(toBuilder = true)
public class UserRegistrationResponseDTO {
    @JsonProperty("userId")
    private String publicUserId;
    private String username;
}
