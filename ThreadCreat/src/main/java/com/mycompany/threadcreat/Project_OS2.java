package com.mycompany.threadcreat;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class Project_OS2 extends JFrame implements ActionListener {
    JButton Browse, Start;
    JLabel Dir, files, words, is, are, you, LongestWordFile, ShortestWordFile, Long, Short,subDIR;
    JTextField DirTxt, file1, file2, file3, word1, is1, are1, you1, LongestWordFile1, ShortestWordFile1, Longest, Shortest,
            word2, is2, are2, you2, LongestWordFile2, ShortestWordFile2, word3, is3, are3, you3, LongestWordFile3,
            ShortestWordFile3;
JCheckBox sub;
    JFrame frame;

    private String overallLongest = "";
    private String overallShortest = "";

    public Project_OS2() {
        this.setTitle("THREADS");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);

        Browse = new JButton("Browse");
        Start = new JButton("Start Processing");
        Dir = new JLabel("Directory : ");
        files = new JLabel("#Files");
        words = new JLabel("#Words");
        is = new JLabel("#is");
        are = new JLabel("#are");
        you = new JLabel("#you");
        LongestWordFile = new JLabel("#Longest");
        ShortestWordFile = new JLabel("#Shortest");
        Long = new JLabel("Longest");
        Short = new JLabel("Shortest");
        DirTxt = new JTextField("");
        file1 = new JTextField("");
        file2 = new JTextField("");
        file3 = new JTextField("");
        word1 = new JTextField("");
        is1 = new JTextField("");
        are1 = new JTextField("");
        you1 = new JTextField("");
        LongestWordFile1 = new JTextField("");
        ShortestWordFile1 = new JTextField("");
        Longest = new JTextField("");
        Shortest = new JTextField("");
        word2 = new JTextField("");
        is2 = new JTextField("");
        are2 = new JTextField("");
        you2 = new JTextField("");
        LongestWordFile2 = new JTextField("");
        ShortestWordFile2 = new JTextField("");
        word3 = new JTextField("");
        is3 = new JTextField("");
        are3 = new JTextField("");
        you3 = new JTextField("");
        LongestWordFile3 = new JTextField("");
        ShortestWordFile3 = new JTextField("");
        sub=new JCheckBox();
        subDIR =new JLabel("include subdirectories");

        this.add(Browse);
        Browse.setBounds(630, 30, 130, 30);
        this.add(Dir);
        Dir.setBounds(10, 20, 200, 50);

        this.add(DirTxt);
        DirTxt.setBounds(90, 40, 300, 20);
        this.add(files);
        files.setBounds(80, 100, 200, 50);
        this.add(words);
        words.setBounds(170, 100, 200, 50);
        this.add(is);
        is.setBounds(260, 100, 200, 50);
        this.add(are);
        are.setBounds(350, 100, 200, 50);
        this.add(you);
        you.setBounds(440, 100, 200, 50);
        this.add(LongestWordFile);
        LongestWordFile.setBounds(530, 100, 200, 50);
        this.add(ShortestWordFile);
        ShortestWordFile.setBounds(620, 100, 200, 50);
        this.add(file1);
        file1.setBounds(70, 150, 60, 20);
        this.add(file2);
        file2.setBounds(70, 200, 60, 20);
        this.add(file3);
        file3.setBounds(70, 250, 60, 20);
        this.add(word1);
        word1.setBounds(160, 150, 60, 20);
        this.add(word2);
        word2.setBounds(160, 200, 60, 20);
        this.add(word3);
        word3.setBounds(160, 250, 60, 20);
        this.add(is1);
        is1.setBounds(250, 150, 60, 20);
        this.add(is2);
        is2.setBounds(250, 200, 60, 20);
        this.add(is3);
        is3.setBounds(250, 250, 60, 20);
        this.add(are1);
        are1.setBounds(340, 150, 60, 20);
        this.add(are2);
        are2.setBounds(340, 200, 60, 20);
        this.add(are3);
        are3.setBounds(340, 250, 60, 20);
        this.add(you1);
        you1.setBounds(430, 150, 60, 20);
        this.add(you2);
        you2.setBounds(430, 200, 60, 20);
        this.add(you3);
        you3.setBounds(430, 250, 60, 20);
        this.add(LongestWordFile1);
        LongestWordFile1.setBounds(520, 150, 60, 20);
        this.add(LongestWordFile2);
        LongestWordFile2.setBounds(520, 200, 60, 20);
        this.add(LongestWordFile3);
        LongestWordFile3.setBounds(520, 250, 60, 20);
        this.add(ShortestWordFile1);
        ShortestWordFile1.setBounds(610, 150, 60, 20);
        this.add(ShortestWordFile2);
        ShortestWordFile2.setBounds(610, 200, 60, 20);
        this.add(ShortestWordFile3);
        ShortestWordFile3.setBounds(610, 250, 60, 20);
        this.add(Long);
        Long.setBounds(70, 350, 60, 20);
        this.add(Short);
        Short.setBounds(70, 400, 60, 20);
        this.add(Longest);
        Longest.setBounds(160, 350, 100, 20);
        this.add(Shortest);
        Shortest.setBounds(160, 400, 100, 20);
        this.add(Start);
        Start.setBounds(50, 500, 700, 30);
        this.add(subDIR);
        subDIR.setBounds(110, 70, 150, 20);
   this.add(sub);
        sub.setBounds(50, 70, 30, 20);
        Browse.addActionListener(this);
        Start.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Browse) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = chooser.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                DirTxt.setText(chooser.getSelectedFile().getAbsolutePath());

                // Call a method to populate the file text fields
                populateFileTextFields(chooser.getSelectedFile());
            }
        } else if (e.getSource() == Start) {
            // Start a thread for each file
            startProcessingThreads();

            // Update overall longest and shortest in the EDT
            SwingUtilities.invokeLater(() -> {
                Longest.setText(overallLongest);
                Shortest.setText(overallShortest);
            });
        }
    }

    private void populateFileTextFields(File directory) {
        // Get a list of files in the selected directory
        File[] files = directory.listFiles();

        // Display the first three files in file1, file2, and file3 text fields
        if (files != null && files.length >= 1) {
            file1.setText(files[0].getName());
        }

        if (files != null && files.length >= 2) {
            file2.setText(files[1].getName());
        }

        if (files != null && files.length >= 3) {
            file3.setText(files[2].getName());
        }
    }

    private void startProcessingThreads() {
        // Reset overall longest and shortest before starting threads
        overallLongest = "";
        overallShortest = "";

        // Create a thread for each file and start the threads
        Thread thread1 = createProcessingThread(new File(DirTxt.getText(), file1.getText()), word1, is1, are1, you1, LongestWordFile1, ShortestWordFile1);
        Thread thread2 = createProcessingThread(new File(DirTxt.getText(), file2.getText()), word2, is2, are2, you2, LongestWordFile2, ShortestWordFile2);
        Thread thread3 = createProcessingThread(new File(DirTxt.getText(), file3.getText()), word3, is3, are3, you3, LongestWordFile3, ShortestWordFile3);

        // Wait for all threads to finish before updating overall longest and shortest
        try {
            thread1.start();
            thread2.start();
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    private Thread createProcessingThread(File file, JTextField wordField, JTextField isField, JTextField areField, JTextField youField, JTextField llField, JTextField ssField) {
        // Create a Runnable that performs the processing for each file
        Runnable fileProcessingRunnable = () -> {
            try {
                // Read the file and count the number of words
                int wordCount = countWords(file);
                int isCount = countIs(file);
                int areCount = countAre(file);
                int youCount = countYou(file);
                String llCount = countll(file);
                String ssCount = countss(file);
                System.out.println("File: " + file.getName() + ", Word Count: " + wordCount);

                // Update the UI component within the EDT
                SwingUtilities.invokeLater(() -> {
                    wordField.setText(String.valueOf(wordCount));
                    isField.setText(String.valueOf(isCount));
                    areField.setText(String.valueOf(areCount));
                    youField.setText(String.valueOf(youCount));
                    llField.setText(String.valueOf(llCount));
                    ssField.setText(String.valueOf(ssCount));
                });

                // Update overall longest and shortest
                updateOverallLongestAndShortest(llCount, ssCount);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };

        // Create a Thread for the Runnable
        return new Thread(fileProcessingRunnable);
    }

    private void updateOverallLongestAndShortest(String currentLongest, String currentShortest) {
        if (currentLongest.length() > overallLongest.length()) {
            overallLongest = currentLongest;
        }

        if (currentShortest.length() < overallShortest.length() || overallShortest.isEmpty()) {
            overallShortest = currentShortest;
        }
    }

    private int countWords(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int wordCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            return wordCount;
        }
    }

    private int countIs(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int IsCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals("is")) {
                        IsCount++;
                    }
                }
            }
            return IsCount;
        }
    }

    private int countAre(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int AreCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals("are")) {
                        AreCount++;
                    }
                }
            }
            return AreCount;
        }
    }

    private int countYou(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int YouCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals("you")) {
                        YouCount++;
                    }
                }
            }
            return YouCount;
        }
    }
    private String countll(File file) throws IOException {
        String longest = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() > longest.length()) {
                        longest = word;
                    }
                }
            }
        }
        return longest;
    }

    private String countss(File file) throws IOException {
        String shortest = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (shortest.length() == 0) {
                        shortest = word;
                    } else if (word.length() < shortest.length() && word.length() != 0) {
                        shortest = word;
                    }
                }
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        new Project_OS2();
    }
}