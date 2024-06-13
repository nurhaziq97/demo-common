package com.demo.common.payloads.authentication.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * Only will be used as authentication-microservice-to-another-microservice DTO.
 * Please create another POJO for communicating with front-end side
 */
@Data
@SuperBuilder(toBuilder = true)
public class UserLoginResponseDTO {
    private String token;
}
