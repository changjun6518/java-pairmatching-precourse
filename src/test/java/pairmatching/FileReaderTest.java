package pairmatching;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReaderTest {
    @Test
    public void readFileTest() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("./src/main/resources/backend-crew.md")
        );
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        bufferedReader.close();
    }

    @Test
    public void fileToCrewList() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("./src/main/resources/frontend-crew.md")
        );
        String str;
        ArrayList<String> crews = new ArrayList<>();
        while ((str = bufferedReader.readLine()) != null) {
            crews.add(str);
        }
        bufferedReader.close();

        System.out.println(Arrays.toString(crews.toArray()));
    }
}
