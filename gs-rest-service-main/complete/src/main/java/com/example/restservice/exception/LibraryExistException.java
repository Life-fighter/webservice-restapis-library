package com.example.restservice.exception;

/**
 * ClassName: LibraryExistException
 * Package: com.example.restservice.exception
 * Description:
 *
 * @Author Yang, Yuanbo
 * @Create 2023-03-10 11:27 a.m.
 * @Version 1.0
 */
public class LibraryExistException extends RuntimeException {
    public LibraryExistException(String message) {
        super(message);
    }
}
