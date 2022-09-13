package com.markurion.tus_java_ondrive_helper;

public class ConsoleColors {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED = "\u001B[31m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN = "\u001B[32m";
    public static final String GREEN_BACKGROUND	= "\u001B[42m";
    public static final String YELLOW = "\u001B[33m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE	= "\u001B[34m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE = "\u001B[35m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN	= "\u001B[36m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE = "\u001B[37m";
    public static final String WHITE_BACKGROUND	= "\u001B[47m";

    public static void consolePrintln(String color, String text){
        System.out.println(color + text + ANSI_RESET);
    }

    public static void main(){
        System.out.println("This is an presentation of colors in java console ... good to know this exist.");
        consolePrintln(BLACK, "This should be black.");
        consolePrintln(BLACK_BACKGROUND, "This should be black background;");
        consolePrintln(RED, "This should be red.");
        consolePrintln(RED_BACKGROUND, "This should be red background");
        consolePrintln(GREEN, "This should be green");
        consolePrintln(GREEN_BACKGROUND, "This should be green background");
        consolePrintln(YELLOW, "This should be yellow");
        consolePrintln(YELLOW_BACKGROUND, "This should be yellow background");
        consolePrintln(BLUE, "This should be blue");
        consolePrintln(BLUE_BACKGROUND, "This should be blue background");
        consolePrintln(PURPLE, "This should be purple background");
        consolePrintln(PURPLE_BACKGROUND, "This should be purple background");
        consolePrintln(CYAN, "This should be cyan");
        consolePrintln(CYAN_BACKGROUND, "This should be cyan background");
        consolePrintln(WHITE, "This should be white");
        consolePrintln(WHITE_BACKGROUND, "This should be white background");
    }
}