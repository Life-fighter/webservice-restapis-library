package com.example.restservice.service;

import com.example.restservice.exception.LibraryExistException;
import com.example.restservice.exception.LibraryNotFoundException;
import com.example.restservice.model.Library;
import com.example.restservice.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.restservice.constants.ErrorMessages.*;

/**
 * ClassName: LibraryService
 * Package: com.example.restservice.service
 * Description:
 *
 * @Author Yang, Yuanbo
 * @Create 2023-03-10 9:58 a.m.
 * @Version 1.0
 */

@Repository
public class LibraryService {

   @Autowired
   LibraryRepository repository;




   public List<Library> getAllLibraries(String name){

      if(name.isEmpty()){
         return repository.getAllLibraries(null);
      }

      return repository.getAllLibraries(name);


   }

   public Library getLibraryById(int id){
      Library libraryFound = repository.getLibraryById(id);
      if(libraryFound == null){
          throw new LibraryNotFoundException(String.format(NO_LIBRARY_FOUND_ID, id));
      }

      return libraryFound;
   }


   public Library getLibraryByCriteria(String name, String zipCode){

    Library libraryFound= repository.getLibraryByCriteria(name, zipCode);
    if(libraryFound == null){
       throw new LibraryNotFoundException(String.format(NO_LIBRARY_FOUND_NAME_ZIPCODE, name, zipCode));
    }
      return libraryFound;
   }



    public Integer saveLibrary(Library library){
        Library libraryFound =repository.getLibraryByCriteria(library.getName(), library.getZipCode());
        if(libraryFound != null){
            throw new LibraryExistException(String.format(LIBRARY_EXIST_NAME_ZIPCODE, library.getName(),  library.getZipCode()));
        }
        return repository.saveLibrary(library);
    }



    public Library updateLibrary(int id, Library library){
        //validateID
        Library libraryFoundById = repository.getLibraryById(id);
        if(libraryFoundById == null){
            throw new LibraryNotFoundException(String.format(NO_LIBRARY_FOUND_ID, id));
        }
        //validate if library exists
        Library libraryFoundByCriteria =repository.getLibraryByCriteria(library.getName(), library.getZipCode());
        if(libraryFoundByCriteria != null){
            throw new LibraryExistException(String.format(LIBRARY_EXIST_NAME_ZIPCODE, library.getName(),  library.getZipCode()));
        }
        repository.update(id, library);
        return library;

    }

    public void deleteLibrary(int id){
        repository.delete(id);
    }






}
