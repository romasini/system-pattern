package ru.romasini.system.pattern.data.identitymap;

import ru.romasini.system.pattern.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserIM {
    private Map<Long, User> userMap = new HashMap<>();
    private static UserIM instance;

    private UserIM() {
    }

    public static UserIM getInstance() {
        if(instance == null){
            instance = new UserIM();
        }
        return instance;
    }

    public static User getUser(Long id){
        return getInstance().userMap.get(id);
    }

    public static void addUser(User user){
        getInstance().userMap.put(user.getId(), user);
    }
}
