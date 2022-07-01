package task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args)
            throws IOException {

        String dataFile = args[0];

        //MailMerge mm = new MailMerge();

        Reader r = new FileReader(dataFile);
        BufferedReader br = new BufferedReader(r);

        String data = br.readLine();

        while (null != data) {
            data = br.readLine();
           // mm.read(data);
        }

    }
}
