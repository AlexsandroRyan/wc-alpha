package org.alex.wc_alpha;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.concurrent.Callable;

@Command(name = "wc-alpha", mixinStandardHelpOptions = true, version = "wc-alpha 1.0", description = "Prints the sum of words, byte and much more of a file")
class WcAlpha implements Callable<Integer> {
    @Parameters(index = "0", description = "The file whose wc-alpha to calculate.")
    private File file;

    @Option(names = "-c", description = "Outputs the number of bytes in a file")
    boolean byte_count;

    @Option(names = "-l", description = "Outputs the number of lines in a file")
    boolean line_count;

    @Option(names = "-w", description = "Outputs the number of words in a file")
    boolean word_count;

    @Option(names = "-m", description = "Outputs the number of characters in a file")
    boolean character_count;

    public long countBytes(File file) {
        return file.length();
    }

    public long countLines(File file) throws Exception {
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            long count = 0;
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
            return count;
        }
    }

    public long countWords(File file) throws Exception {
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            long count = 0;
            while (sc.hasNext()) {
                sc.next();
                count++;
            }
            return count;
        }
    }

    public long countCharacters(File file) throws Exception {
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            long count = 0;
            while (sc.hasNextLine()) {
                String answer = sc.nextLine();
                count += answer.length();
            }
            sc.close();
            return count;
        }
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            if (byte_count) {
                System.out.println(countBytes(file) + " " + file.getName());
            }
            if (line_count) {
                System.out.println(countLines(file) + " " + file.getName());
            }
            if (word_count) {
                System.out.println(countWords(file) + " " + file.getName());
            }
            if (character_count) {
                System.out.println(countCharacters(file) + " " + file.getName());
            }
            if (!byte_count && !line_count && !word_count && !character_count) {
                System.out.println(
                        countLines(file) + " " + countWords(file) + " " + countCharacters(file) + " " + file.getName());
            }
        }
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new WcAlpha()).execute(args);
        System.exit(exitCode);
    }
}
