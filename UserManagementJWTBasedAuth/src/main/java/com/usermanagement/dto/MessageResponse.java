package com.usermanagement.dto;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {

    private String message;
    private LocalDateTime timeStamp;


}
