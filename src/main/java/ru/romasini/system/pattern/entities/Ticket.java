package ru.romasini.system.pattern.entities;

public class Ticket {
    private Long id;
    private String concertName;
    private User user;

    public Ticket() {
    }

    public Ticket(Long id, String concertName, User user) {
        this.id = id;
        this.concertName = concertName;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + concertName + '\'' +
                ", user=" + user +
                '}';
    }
}
