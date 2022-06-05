package org.andrea.data;

public enum MusicGenre {
    PSYCHEDELIC_ROCK,
    RAP,
    POP,
    POST_PUNK, getMusicGenre;

    //проверка на то что слово находится в enum'е
    public static boolean isPresent(String data) {

        try {
            Enum.valueOf(MusicGenre.class, data);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
