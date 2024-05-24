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

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            if (byte_count) {
                System.out.println(file.length());
            }
            if (line_count) {
                int count = 0;
                while (sc.hasNextLine()) {
                    sc.nextLine();
                    count++;
                }
                System.out.println(count);
            }
            if (word_count) {
                int count = 0;
                while (sc.hasNext()) {
                    sc.next();
                    count++;
                }
                System.out.println(count);
            }
            if (character_count) {
                int count = 0;
                while (sc.hasNext()) {
                    sc.next();
                    count += sc.next().length();
                }
                System.out.println(count);
            }
        }
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new WcAlpha()).execute(args);
        System.exit(exitCode);
    }
}
