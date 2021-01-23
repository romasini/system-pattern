package ru.romasini.system.pattern;

import ru.romasini.system.pattern.data.dao.TicketDAO;
import ru.romasini.system.pattern.data.dao.UserDAO;
import ru.romasini.system.pattern.data.identitymap.TicketIM;
import ru.romasini.system.pattern.data.identitymap.UserIM;
import ru.romasini.system.pattern.entities.Ticket;
import ru.romasini.system.pattern.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:db-example.sqlite3");
            UserDAO userDAO = new UserDAO(connection);
            User user = userDAO.findById(3l);
            System.out.println(user);
            System.out.println(UserIM.getUser(3l));
            TicketDAO ticketDAO = new TicketDAO(connection, userDAO);
            Ticket ticket = ticketDAO.findById(10l);
            System.out.println(ticket);

            Ticket ticket1 = ticketDAO.findById(10l);
            Ticket ticket2 = TicketIM.getTicket(10l);
            System.out.println(ticket1.equals(ticket2));

        } catch (Exception e) {
            System.out.println("Ошибка подключения к базе!");
            e.printStackTrace();
        }finally {
            try {
                if(connection!=null) {connection.close();}
                System.out.println("Подключения к базе закрыто!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
