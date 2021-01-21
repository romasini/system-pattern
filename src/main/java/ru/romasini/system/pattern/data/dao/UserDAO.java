package ru.romasini.system.pattern.data.dao;

import ru.romasini.system.pattern.data.identitymap.UserIM;
import ru.romasini.system.pattern.data.mapper.UserMapper;
import ru.romasini.system.pattern.entities.User;
import ru.romasini.system.pattern.exception.RecordNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    private final Connection connection;
    private Map<Long, User> userMap = new HashMap<>();

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public User findById(Long id) throws SQLException, RecordNotFoundException {
        User result = UserIM.getUser(id);
        if(result != null){
            return result;
        }

        PreparedStatement statement = connection.prepareStatement("SELECT id, name, email FROM users WHERE id = ?;");
        statement.setLong(1, id);
        try(ResultSet resultSet = statement.executeQuery()){
            result = UserMapper.map(resultSet);
            UserIM.addUser(result);
            return result;
        }
    }

    public void insert(User user){

    }
}
