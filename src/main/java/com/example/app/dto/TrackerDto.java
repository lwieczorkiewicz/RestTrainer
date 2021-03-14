package com.example.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackerDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    //private HttpServletRequest request;

    private String action;

    private LocalDate localDate = LocalDate.now();

}
