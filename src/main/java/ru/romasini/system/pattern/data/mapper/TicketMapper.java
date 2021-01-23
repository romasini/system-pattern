package ru.romasini.system.pattern.data.mapper;

import ru.romasini.system.pattern.data.dao.UserDAO;
import ru.romasini.system.pattern.entities.Ticket;
import ru.romasini.system.pattern.exception.RecordNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper {

    public static Ticket map(ResultSet resultSet, UserDAO userDAO) throws SQLException, RecordNotFoundException {
        while (resultSet.next()){
            Ticket ticket = new Ticket(resultSet.getLong("id"), resultSet.getString("concert_name"), userDAO.findById(resultSet.getLong("user_id")));
            return ticket;
        }
        throw new RecordNotFoundException("Ticket not found");
    }

}
