package com.example.restservice.model;

import lombok.*;

/**
 * ClassName: Library
 * Package: com.example.restservice.model
 * Description:
 *
 * @Author Yang, Yuanbo
 * @Create 2023-03-10 9:29 a.m.
 * @Version 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Library {
    private String name;
    private String address;
    private String zipCode;
    private String phoneNumber;

}
