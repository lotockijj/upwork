import org.junit.Test;

/**
 * Created by Роман Лотоцький on 26.01.2017.
 */
public class SchoolMarkTest {
    @Test
    public void readAndParseText() throws Exception {
        SchoolMark schoolMark = new SchoolMark();
        schoolMark.readAndParseText();
        for (Grades grades : schoolMark.gradesList) {
            System.out.println(grades);
        }
    }

}