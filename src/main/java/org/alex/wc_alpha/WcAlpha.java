package org.alex.wc_alpha;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.concurrent.Callable;

@Command(name = "wc-alpha", mixinStandardHelpOptions = true, version = "wc-alpha 1.0", description = "Prints the sum of words, byte and much more of a file")
class WcAlpha implements Callable<Integer> {
    @Parameters(index = "0", description = "The file whose wc-alpha to calculate.")
    private File file;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            int count = 0;
            while (sc.hasNext()) {
                sc.next();
                count++;
            }
            System.out.printf(String.valueOf(count));
        }
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new WcAlpha()).execute(args);
        System.exit(exitCode);
    }
}
