package asciimirror;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        List<String> lines = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("File not found!");
        } else {
            try {
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                }
            } catch (IOException e) {
                System.out.println("File not found!");
            }
        }
        var maxLengthOpt = lines.stream().map(String::length).max(Integer::compareTo);
        if (maxLengthOpt.isPresent()) {
            int maxLength = maxLengthOpt.get();
            for (String line : lines) {
                System.out.print(line);
                System.out.print(" ".repeat(maxLength - line.length()));
                System.out.print(" | ");
                System.out.print(" ".repeat(maxLength - line.length()));
                System.out.print(reverseLine(line));
                System.out.println();
            }
        }
    }

    private static String reverseLine(String line) {
        List<Character> characters = new ArrayList<>();
        line.chars().forEach(c -> {
            switch (c) {
                case '<' : characters.add('>'); break;
                case '>' : characters.add('<'); break;
                case '[' : characters.add(']'); break;
                case ']' : characters.add('['); break;
                case '{' : characters.add('}'); break;
                case '}' : characters.add('{'); break;
                case '(' : characters.add(')'); break;
                case ')' : characters.add('('); break;
                case '/' : characters.add('\\'); break;
                case '\\' : characters.add('/'); break;
                default : characters.add((char) c);

            }
        });
        Collections.reverse(characters);
        return characters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}