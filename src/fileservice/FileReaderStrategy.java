/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author sawyer
 */
public interface FileReaderStrategy {

    List<LinkedHashMap<String, String>> getAllRecords() throws IOException;
    
    String getFilePath();
    
    FileFormatStrategy getFormatStrategy();
    
    void setFilePath(String filePath);
    
    void setFormatStrategy(FileFormatStrategy formatStrategy);
    
    
}
