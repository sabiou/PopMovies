package xyz.godi.popularmovies.utils;

public class Utils {

    // url utils
    public static String generateThumbnail(String thumbKey) {
        return ConstantsUtils.YOUTUBE_THUMB__URL.concat(thumbKey).concat("/hqdefault.jpg");
    }

}