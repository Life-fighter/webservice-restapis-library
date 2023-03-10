package com.example.restservice.api;

import com.example.restservice.exception.*;
import com.example.restservice.model.Library;
import com.example.restservice.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: LibraryController
 * Package: com.example.restservice.api
 * Description:
 *
 * @Author Yang, Yuanbo
 * @Create 2023-03-10 10:02 a.m.
 * @Version 1.0
 */

@RestController
@RequestMapping("/montreal")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @GetMapping("/libraries")
    public ResponseEntity <List<Library>> getAllLibraries(@RequestParam (value = "name", defaultValue = "") String name){
        return new ResponseEntity<>(libraryService.getAllLibraries(name), HttpStatus.OK);
    }


    @GetMapping("/libraries/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable int id){
        try {
            return new ResponseEntity<Library>(libraryService.getLibraryById(id), HttpStatus.OK);
        } catch (LibraryNotFoundException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/libraries/library")
    public ResponseEntity<Library> getLibraryByCriteria(@RequestParam(value = "name", defaultValue = "") String name,
                                                        @RequestParam(value = "zipcode", defaultValue = "") String zipCode){
        try {
            return new ResponseEntity<>(libraryService.getLibraryByCriteria(name, zipCode), HttpStatus.OK);
        } catch (LibraryNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (DatabaseException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/libraries")
    public ResponseEntity<Integer> saveLibrary(@RequestBody Library library){
        try{
            return new ResponseEntity<>(libraryService.saveLibrary(library), HttpStatus.CREATED);
        }
        catch (LibraryExistException exc){
            return new ResponseEntity(exc.getMessage(), HttpStatus.CONFLICT);
        }
        catch (DatabaseException ex){
            return new ResponseEntity(ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/libraries/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable int id, @RequestBody Library library){
        try{
            return new ResponseEntity<>(libraryService.updateLibrary(id, library), HttpStatus.OK);
        }
        catch (LibraryNotFoundException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (LibraryExistException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        }

    }


    @DeleteMapping("/libraries/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable int id){
        libraryService.deleteLibrary(id);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }






}
