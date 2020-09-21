package BST;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
    // 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
    public static void readFile(String filename, ArrayList<String> words) throws Exception {
        if (filename == null || words == null) {
            throw new Exception("Invalid filename or word list!");
        }
        Scanner scanner;
        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream));
                scanner.useLocale(Locale.ENGLISH);
            }
        } catch(Exception ex) {
            System.out.println("Cannot open file: " + filename);
        }
    }

    private void parseFile(Scanner scanner, List<String> words) {
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i ++;
                }
            }
        }
    }

    private int firstCharacterIndex(String contents, int idx) {

    }

}
