package com.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplate {

    private String className;
    private String uri;
    private Object data;
    private LocalDateTime timeStamp;

}
