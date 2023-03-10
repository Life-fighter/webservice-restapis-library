package com.example.restservice.repository.mapper;

import com.example.restservice.repository.entity.LibraryEntity;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: LibraryMapper
 * Package: com.example.restservice.repository.mapper
 * Description:
 *
 * @Author Yang, Yuanbo
 * @Create 2023-03-10 9:32 a.m.
 * @Version 1.0
 */
public class LibraryRowMapper implements RowMapper<LibraryEntity>{
    @Override
    public LibraryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return LibraryEntity.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .address(rs.getString("address"))
                .zipCode(rs.getString("zip_code"))
                .phoneNumber(rs.getString("phone_number"))
                .build();
    }
}
