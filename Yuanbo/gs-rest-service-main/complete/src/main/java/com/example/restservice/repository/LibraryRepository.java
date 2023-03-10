package com.example.restservice.repository;

import com.example.restservice.exception.DatabaseException;
import com.example.restservice.model.Library;
import com.example.restservice.repository.entity.LibraryEntity;
import com.example.restservice.repository.mapper.LibraryRowMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.restservice.constants.ErrorMessages.DATABASE_EXCEPTION;

/**
 * ClassName: LibraryRepository
 * Package: com.example.restservice.repository
 * Description:
 *
 * @Author Yang, Yuanbo
 * @Create 2023-03-10 9:50 a.m.
 * @Version 1.0
 */

@Repository
public class LibraryRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ModelMapper modelMapper;


    public List<Library> getAllLibraries(String name) {
        List<LibraryEntity> libraryEntities;
        List<Library> libraries = new ArrayList<>();
        if (name == null) {
            libraryEntities = jdbcTemplate.query("select * FROM Library", new LibraryRowMapper());
        } else {
            libraryEntities = jdbcTemplate.query("select * FROM Library where name=?", new LibraryRowMapper(), name);
        }

        for (LibraryEntity libraryEntity : libraryEntities) {
            Library library = modelMapper.map(libraryEntity, Library.class);
            libraries.add(library);
        }
        return libraries;
    }

        public Library getLibraryById ( int id){
            try {
                String sql = "select * from library where id = ?";
                LibraryEntity libraryEntity = jdbcTemplate.queryForObject(sql, new LibraryRowMapper(), id);
                return modelMapper.map(libraryEntity, Library.class);
            } catch (EmptyResultDataAccessException exception) {
                return null;
            }

        }




//    public Book getBookByCriteria(String name, String author) {
//        String sql = "SELECT * FROM Book WHERE name=? and author=?";
//        try{
//            BookEntity entity = jdbcTemplate.queryForObject(sql, new BookRowMapper(), name, author);
//            return modelMapper.map(entity, Book.class);
//        }
//        catch (EmptyResultDataAccessException exception){
//            return null;
//        }
//        catch(Exception e){
//            throw  new DatabaseException(DATABASE_EXCEPTION);
//        }
//    }


        public Library getLibraryByCriteria(String name, String zipCode){
            try {
                String sql = "Select * from Library where name=? and zip_code=?";
                LibraryEntity libraryEntity = jdbcTemplate.queryForObject(sql, new LibraryRowMapper(), name, zipCode);
                return modelMapper.map(libraryEntity, Library.class);
            } catch (EmptyResultDataAccessException exception) {
                return null;
            } catch (Exception e){
                throw new DatabaseException(DATABASE_EXCEPTION);
            }

        }


    public Integer saveLibrary(Library library){
        try {
            String sql = "INSERT INTO Library(name, address, zip_code, phone_number) VALUES(?, ?, ?, ?)";

            jdbcTemplate.update(sql, library.getName(), library.getAddress(), library.getZipCode(), library.getPhoneNumber());

            return jdbcTemplate.queryForObject("SELECT MAX(ID) FROM Library", Integer.class);
        }
        catch (Exception ex){
            throw new DatabaseException(DATABASE_EXCEPTION);
        }
    }


    public void update(int id, Library library) {
        String sql = "UPDATE Library SET name=?, address=?, zip_code=?, phone_number=? WHERE id=?";
        jdbcTemplate.update(sql, library.getName(), library.getAddress(), library.getZipCode(),library.getPhoneNumber(), id);
    }


    public void delete(int id) {
        String sql = "DELETE FROM Library WHERE id=?";
        jdbcTemplate.update(sql, id);
    }








    }
