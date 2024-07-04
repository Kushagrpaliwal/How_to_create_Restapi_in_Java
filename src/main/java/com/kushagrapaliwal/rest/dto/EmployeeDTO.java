package com.kushagrapaliwal.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;

    @JsonProperty("date_of_joining")
    private LocalDate dateOfJoining;

    @JsonProperty("is_active")
    private boolean isActive;
}
