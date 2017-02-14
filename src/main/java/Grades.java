import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Роман Лотоцький on 26.01.2017.
 */
public class Grades {

    String name;
    List<Integer> listGrades;
    int len;
    Double average;
    double median;


    public Grades(String name, List<Integer> listGrades) {
        this.name = name;
        this.listGrades = listGrades;
        len = listGrades.size();
        average = getAverage();
        median = getMedian();
    }

    private Double getAverage(){
        double sum = 0;
        for (int i:listGrades) {
            sum += i;
        }
        sum = sum/listGrades.size();
        return Double.parseDouble(new DecimalFormat("#.##").format(sum).replace(",", "."));//Math.round(sum, 2);
    }

    private double getMedian(){
        double median = 0;
        List<Double> copy = new ArrayList<>();
        for (int i: listGrades) {
            copy.add((double)i);
        }
        Collections.sort(copy);
        if(copy.size() % 2 == 0){
            median = (copy.get(copy.size()/2 - 1) +
                    copy.get(copy.size()/2)) / 2;
        } else {
            median = copy.get(copy.size()/2);
        }
        return median;
    }

    @Override
    public String toString() {
        return name + " " + listGrades + "\n" +
                "Name:" + "\t" + name + "\n" +
                "Length:" + "\t" + len + "\n" +
                "Average:" + "\t" + average + "\n" +
                "Median:" + "\t" + median + "\n" +
                "Maximum:" + "\t" + Collections.max(listGrades) + "\n" +
                "Minimum:" + "\t" + Collections.min(listGrades) + "\n";
    }
/*Alice [87, 99, 96, 99, 86, 96, 77, 95, 70, 88]
    Name:    Alice
    Length:  10
    Average: 89.30
    Median:  91.5
    Maximum: 99
    Mininum: 70*/
}
