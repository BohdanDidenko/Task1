package com.epam.task8.task8_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Runner implements Callable<Integer> {
    private static final String PATH_TO_FILE_WITH_RESULT = "src\\com\\epam\\task8\\task8_5\\result";
    private File directory;
    private String word;

    public Runner(File directory, String word) {
        this.directory = directory;
        this.word = word;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter directiry -> ");
            File directory = new File(sc.next());
            System.out.print("Enter keyword -> ");
            String word = sc.next();
            Runner runner = new Runner(directory, word);
            FutureTask<Integer> task = new FutureTask<Integer>(runner);
            new Thread(task).start();
            task.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        printResult();
    }

    @Override
    public Integer call() throws Exception {
        File[] files = directory.listFiles();
        List<Future<Integer>> result = new ArrayList<>();

        for (File file : files)
            if(file.isDirectory()){
                Runner runner = new Runner(file, word);
                FutureTask<Integer> task = new FutureTask <Integer> (runner);
                new Thread(task).start();
            }
            else if(file.toString().endsWith(".txt")){
                search(file, word);
            }
        return 0;
    }

    private void search(File file, String letter){
        String line;
        int count = 0;
        try(Scanner scanner = new Scanner(new FileInputStream(file))){
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.startsWith(letter.toLowerCase()) ||
                            word.startsWith(letter.toUpperCase()))
                        count++;
                }
            }
            if(count != 0)
                addInFileResult(file.getName() + " - " + count + "\n");
        } catch (FileNotFoundException e) {
            System.err.println("Directory search error");
        }
    }

    private void addInFileResult(String word){
        try(FileOutputStream fileOutputStream = new FileOutputStream(PATH_TO_FILE_WITH_RESULT, true)){
            fileOutputStream.write(word.getBytes());
        }
        catch (IOException e){
            System.err.println("Error writing result to file");
        }
    }

    private static void printResult(){
        try(Scanner scanner = new Scanner(new FileInputStream(PATH_TO_FILE_WITH_RESULT))){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.err.println("Error while reading the file");
        }
    }
}
