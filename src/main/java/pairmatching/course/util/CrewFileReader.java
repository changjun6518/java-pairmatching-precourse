package pairmatching.course.util;

import pairmatching.crew.Crew;
import pairmatching.crew.Crews;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CrewFileReader {
    static List<String> crewsString = new ArrayList<>();

    public static Crews readCrews(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(filePath)
            );
            String str;
            Crews crews = new Crews();
            while ((str = bufferedReader.readLine()) != null) {
                crewsString.add(str);
                crews.add(str);
            }
            bufferedReader.close();
            return crews;
        } catch (Exception e) {
            throw new IllegalArgumentException("제대로 파일을 읽어올 수 없습니다!");
        }
    }
}
