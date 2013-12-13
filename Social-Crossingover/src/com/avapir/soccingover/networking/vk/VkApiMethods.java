package com.avapir.soccingover.networking.vk;

/** User: Alpen Ditrix Date: 10.11.13 Time: 16:23 */
public class VkApiMethods {

    public static final CharSequence URL            = "https://api.vk.com/model/";
    public static final CharSequence API_VERSION    = "5.4";
    /* API SECRET KEYS */
    public static final CharSequence APPLICATION_ID = "3987330";
    public static final CharSequence SECURITY_KEY   = "W0Sv1fcXgnFQYz6e67V9";

    /**
     * @return wall.get url
     */
    public String wallGet(int owner_id, int offset, int count, String filter) {
        final String wallFormat = "wall.get?owner_id=%s&offset=%s&count=%s&filter=%s";
        return new StringBuilder(URL).append(String.format(wallFormat, owner_id, offset, count, filter))
                                     .append(API_VERSION)
                                     .toString();
    }

    public String authorization(String login, String password) {
        return "хуеблядь";
    }

}
