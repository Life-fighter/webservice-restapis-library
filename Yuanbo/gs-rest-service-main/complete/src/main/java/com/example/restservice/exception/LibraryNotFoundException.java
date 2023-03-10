package com.example.restservice.exception;

/**
 * ClassName: LibraryNotFoundException
 * Package: com.example.restservice.exception
 * Description:
 *
 * @Author Yang, Yuanbo
 * @Create 2023-03-10 11:22 a.m.
 * @Version 1.0
 */
public class LibraryNotFoundException extends RuntimeException {
    public LibraryNotFoundException(String message) {
        super(message);
    }
}
