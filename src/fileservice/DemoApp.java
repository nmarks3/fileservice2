package fileservice;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DemoApp {

    public static void main(String[] args) throws IOException {
        FileService fileService
                = new FileService(
                        new TextFileReader("mydata.csv", new CsvFileFormat()),
                        new TextFileWriter("mydata.csv", new CsvFileFormat()));
        
                        //new TextFileReader("src/mydata.txt", new GarageFileFormat()),

        List<LinkedHashMap<String, String>> inData = fileService.getAllRecords();
        System.out.println("Reading done...");
        System.out.println(inData);

        List<LinkedHashMap<String, String>> updatedFileContent
                = new ArrayList<LinkedHashMap<String, String>>();
        LinkedHashMap<String, String> record
                = new LinkedHashMap<String, String>();

        record.put("firstName", "Sally");
        record.put("lastName", "Jones");
        record.put("age", "33");
        updatedFileContent.add(record);

        record = new LinkedHashMap<String, String>();
        record.put("firstName", "Bill");
        record.put("lastName", "Clinton");
        record.put("age", "44");
        updatedFileContent.add(record);

        fileService.recordAddNew(updatedFileContent, false);

        System.out.println("Writing done...");
    }
}
