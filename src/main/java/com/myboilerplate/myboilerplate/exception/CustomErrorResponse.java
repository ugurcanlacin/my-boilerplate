package com.myboilerplate.myboilerplate.exception;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myboilerplate.myboilerplate.config.JsonDateDeserializer;
import com.myboilerplate.myboilerplate.config.JsonDateSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomErrorResponse {
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDateTime timestamp;
    private int status;
    private String message;
}

