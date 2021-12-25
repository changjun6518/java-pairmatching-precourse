package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewFileReader {
    public static List<String> readCrewList(String filePath) {
        List<String> crewList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                crewList.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crewList;
    }
}
