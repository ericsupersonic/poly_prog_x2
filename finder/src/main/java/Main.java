package com.company;
// https://www.youtube.com/watch?v=ZIQiiG6i09A
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Main {

    static String defDir = Paths.get("src/main/java").toAbsolutePath().toString();
 //соси
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        System.out.println(find(command));
    }

    public static String find(String com) {
        String[] words = com.split(" ");
        boolean deep = false;
        String dir = defDir;

        if (!Objects.equals(words[0], "find")) {
            return null;
        }

        switch (words.length) {
            case 3:
                if (Objects.equals(words[1], "-r")) {
                    deep = true;
                } else {
                    return null;
                }
                break;
            case 4:
                if (Objects.equals(words[1], "-d")) {
                    dir = words[2];
                } else {
                    return null;
                }
                break;
            case 5: //есть все.
                if (Objects.equals(words[1], "-r") && Objects.equals(words[2], "-d")) {
                    deep = true;
                    dir = words[3];
                } else if (Objects.equals(words[3], "-r") && Objects.equals(words[1], "-d")) {
                    deep = true;
                    dir = words[2];
                } else {
                    return null;
                }
                break;
        }

        String filename = words[words.length-1];
        File dirFile = new File(toGlobalPath(dir));

        if (!deep) {
            return searchFile(dirFile, filename);
        } else {
            return deepSearch(dirFile, filename);
        }
    }

    public static String searchFile(File dir, String filename) {
        File file = new File(dir.getAbsolutePath(), filename);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return "File not found";
    }

    public static String deepSearch(File dir, String filename) { //DEEP DARK FANTASY
        File file = new File(dir.getAbsolutePath(), filename);
        if (file.exists()) {
            return file.getAbsolutePath();
        } else {
            File[] deepDirs = dir.listFiles();
            for (File deepDir: deepDirs) {
                if (deepDir.isDirectory()) {
                    return deepSearch(deepDir, filename); //ммм рекурсия... вкусно
                }
            }
        }
        return "File not found";
    }

    public static String toGlobalPath(String path) {
        if (path.contains("C:") || path.contains("D:")) { // D: мое лицо в 3 часа ночи
            return path;
        } else {
            return defDir.concat("\\\\").concat(path);
        }
    }
}
