package lecture30.module.model;

import java.util.List;

public class User {
    //уникальный идентификатор
    private int id;
    private String fullName;
    //должен быть уникальным, не null
    private String login;
    //должен быть уникальным и содержать символ '@'
    private String email;
    //не меньше 18
    private int age;
    //подписки
    private List<User> subscriptions;
    //является ли данный пользователь автором (у пользователя должно быть 1 или более публикаций)
    private Boolean isAuthor;
    //может ли пользователь модерировать статьи
    private Boolean isModerator;
    //0 если пользователь не "автор"
    private List<User> followers;
}
