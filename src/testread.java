import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class testread {


    public static void main(String[] args) throws FileNotFoundException {
        File lsSchedule = new File("src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner s1 = new Scanner(lsSchedule);
        LSData array[] = new LSData[2976];
        int cntr = 0;
        while (s1.hasNextLine()) {
            String line = s1.nextLine();
            String[] parts = line.split(" ",2);
            array[cntr] = new LSData(parts[0],parts[1]);
            cntr++;
        }
        System.out.printf("%s\n%s\n%s",array[0].toString(), array[1500].toString(),array[2975].toString());
        System.out.println();
        System.out.println((array[0].getStageDayTime().compareTo(array[200].getStageDayTime())));
    }
}