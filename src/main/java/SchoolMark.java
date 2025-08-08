import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Роман Лотоцький on 26.01.2017.
 */
public class SchoolMark {
    String name;
    List<Integer> listMarks = new ArrayList<Integer>();
    List<Grades> gradesList = new ArrayList<Grades>();

    public void readAndParseText() {
        try(BufferedReader in = new BufferedReader(new FileReader(
                    "D:\\intellij\\upwork\\src\\main\\resources\\data.txt"
            ))){
            String str;
            while ((str = in.readLine()) != null){
                process(str);
            }
        } catch (IOException e1){
            System.out.println(e1);
        }
    }

    private void process(String str) {
            if (Character.isLetter(str.charAt(0))) {
                name = str;
            } else if (Character.isDigit(str.charAt(0))) {
                Scanner scanner = new Scanner(str);
                listMarks = new ArrayList<>();
                while (scanner.hasNext()) {
                    listMarks.add(Integer.parseInt(scanner.next()));
                }
                gradesList.add(new Grades(name, listMarks));
            }
    }
}
