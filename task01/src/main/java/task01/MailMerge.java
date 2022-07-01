package task01;

import java.util.LinkedList;

public class MailMerge {

    private LinkedList<String> dataSet = new LinkedList<String>(); 

    public void read(String data) {

        if ((null == data) || (data.trim().length() <= 0))
            return;

        String[] fields = data.split(",");
        String first_name = removeQuotes(fields[0]);
        String last_name = removeQuotes(fields[1]);
        String address = removeQuotes(fields[2]);
        String years = removeQuotes(fields[3]);  
        System.out.println(fields); 
    }


    private String removeQuotes(String s) {
        return s.replaceAll(" , ", " ");
    }

    public LinkedList<String> getDataSet() {
        return dataSet;
    }

    
}
