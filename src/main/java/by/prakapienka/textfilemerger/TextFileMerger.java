package by.prakapienka.textfilemerger;

import java.io.*;

public class TextFileMerger {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: input_file_path1 input_file_path2 output_file_path");
            return;
        }
        File inputFile1 = new File(args[0]);
        File inputFile2 = new File(args[1]);
        File outputFile = new File(args[2]);

        if (!inputFile1.isFile() || !inputFile2.isFile()) {
            System.out.println("Usage: input_file_path1 input_file_path2 output_file_path");
        }

        try (BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
             BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            boolean flag1 = true;
            boolean flag2 = true;
            while (flag1 || flag2) {
                if (reader1.ready()) {
                    String line1 = reader1.readLine();
                    writer.write(line1 + System.lineSeparator());
                } else {
                    flag1 = false;
                }
                if (reader2.ready()) {
                    String line2 = reader2.readLine();
                    writer.write(line2 + System.lineSeparator());
                } else {
                    flag2 = false;
                }
            }
        } catch (IOException e) {
            System.err.println("Error while processing the files.");
        }
    }

}

//test path d:\test\input1.txt
//test path d:\test\input2.txt
//test path d:\test\output.txt
