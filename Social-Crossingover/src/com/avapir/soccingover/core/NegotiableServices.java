package com.avapir.soccingover.core;

/** User: Alpen Ditrix Date: 23.11.13 Time: 20:07 */
public enum NegotiableServices {

    TWITTER, VK, INSTAGRAM;

    public static final NegotiableServices fromInt(int key) {
        switch (key) {
            case 0:
                return TWITTER;
            case 1:
                return VK;
            case 2:
                return INSTAGRAM;
            default:
                throw new IllegalArgumentException("Wrong service key");
        }
    }

}
