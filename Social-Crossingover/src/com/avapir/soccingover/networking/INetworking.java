package com.avapir.soccingover.networking;

import com.avapir.soccingover.models.Post;

import java.util.List;

/** User: Alpen Ditrix Date: 10.11.13 Time: 16:10 */
public interface INetworking {

    /**
     * Логинится через API, возможно получает какие-то временные ключи (идентификаторы сессии), по которым потом нужно
     * запрашивать ленту
     *
     * @param login    логин
     * @param password пароль
     */
    public void login(String login, String password);

    /** @return список из фиксированного числа постов или за фиксированное время. Это надо потом как-нибудь решить */
    public List<Post> getRecentPosts();


}
