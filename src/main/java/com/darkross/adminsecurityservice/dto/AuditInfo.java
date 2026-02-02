package com.darkross.adminsecurityservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditInfo {
    private String ip;
    private String application;
    private String requestId;
}
