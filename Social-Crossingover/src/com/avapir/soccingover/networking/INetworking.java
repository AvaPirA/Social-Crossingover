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
    public String login(String login, String password);

    /** @return список из фиксированного числа постов или за фиксированное время. Это надо потом как-нибудь решить */
    public List<Post> getRecentPosts();


//    public static void parse() {
//
//        String xml = "<resp><status>good</status><msg>hi</msg></resp>";
//
//        XPathFactory xpathFactory = XPathFactory.newInstance();
//        XPath xpath = xpathFactory.newXPath();
//
//        InputSource source = new InputSource(new StringReader(xml));
//
//        String status = "";
//        String msg = "";
//        try {
//            status = (String) xpath.evaluate("/resp/status", source,XPathConstants.STRING);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("status=" + status);
//        System.out.println("Message=" + msg);
//
//
//    }

}
