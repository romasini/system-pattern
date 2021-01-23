package ru.romasini.system.pattern.data.dao;

import ru.romasini.system.pattern.data.identitymap.TicketIM;
import ru.romasini.system.pattern.data.mapper.TicketMapper;
import ru.romasini.system.pattern.entities.Ticket;
import ru.romasini.system.pattern.exception.RecordNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO {
    private final Connection connection;
    private UserDAO userDAO;

    public TicketDAO(Connection connection, UserDAO userDAO) {
        this.connection = connection;
        this.userDAO = userDAO;
    }

    public Ticket findById(Long id) throws SQLException, RecordNotFoundException {
        Ticket result = TicketIM.getTicket(id);
        if(result != null){
            return result;
        }

        PreparedStatement statement = connection.prepareStatement("SELECT id, concert_name, user_id FROM tickets WHERE id = ?;");
        statement.setLong(1, id);
        try(ResultSet resultSet = statement.executeQuery()){
            result = TicketMapper.map(resultSet, userDAO);
            TicketIM.addTicket(result);
            return result;
        }
    }
}
