/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author sawyer
 */
public interface FileFormatStrategy {
    
    List<LinkedHashMap<String, String>> decodeAll(String data);
    
    String encodeAll(List<LinkedHashMap<String, String>> updatedFileContent, boolean useHeader);
    
    String encodeRecord(LinkedHashMap<String, String> newData);
    
}
