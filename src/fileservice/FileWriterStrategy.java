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
public interface FileWriterStrategy {

    void saveOrUpdate(List<LinkedHashMap<String, String>> updatedFileContent, boolean useHeader)
            throws IOException;
    
    void addNewRecords(List<LinkedHashMap<String, String>> newData, boolean useHeader)
            throws IOException;
    
    String getFilePath();
    
    FileFormatStrategy getFormatStrategy();
    
    void setFilePath(String filePath);
    
    void setFormatStrategy(FileFormatStrategy formatStrategy);
    
}
