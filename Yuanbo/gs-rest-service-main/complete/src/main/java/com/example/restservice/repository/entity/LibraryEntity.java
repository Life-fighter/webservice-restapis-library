package com.example.restservice.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: LibraryEntity
 * Package: com.example.restservice.repository.entity
 * Description:
 *
 * @Author Yang, Yuanbo
 * @Create 2023-03-10 9:33 a.m.
 * @Version 1.0
 */

@Setter
@Getter
@Builder
public class LibraryEntity {

    private int id;
    private String name;
    private String address;
    private String zipCode;
    private String phoneNumber;

}
