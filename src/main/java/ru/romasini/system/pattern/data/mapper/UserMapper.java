package ru.romasini.system.pattern.data.mapper;


import ru.romasini.system.pattern.entities.User;
import ru.romasini.system.pattern.exception.RecordNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User map(ResultSet resultSet) throws SQLException, RecordNotFoundException {
        while (resultSet.next()){
            User user = new User(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("email"));
            return user;
        }
        throw new RecordNotFoundException("User not found");
    }
}
