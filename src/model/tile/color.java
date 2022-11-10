package model.tile;

public class color {
    public static final String RESET = "\u001B[0m";
    public static String FONT_BLACK = "\u001B[30m"; //검정색
    public static String FONT_RED = "\u001B[31m"; //빨강색
    public static String FONT_YELLOW = "\u001B[33m"; //노랑색
    public static String FONT_BLUE = "\u001B[34m"; //파랑색


    public static String yellow(String content) {
        return FONT_YELLOW + content + RESET;
    }
    public static String blue(String content) {
        return FONT_BLUE + content + RESET;
    }
    public static String black(String content) {
        return FONT_BLACK + content + RESET;
    }
    public static String red(String content) {
        return FONT_RED + content + RESET;
    }
}
