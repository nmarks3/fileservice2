/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author sawyer
 */
public class TextFileWriter implements FileWriterStrategy {
    private FileFormatStrategy formatStrategy;
    private String filePath;
    
    public TextFileWriter() {
        
    }
    
    public TextFileWriter(String filePath, FileFormatStrategy formatStrategy) {
        this.filePath = filePath;
        this.formatStrategy = formatStrategy;
    }

    @Override
    public void saveOrUpdate(List<LinkedHashMap<String, String>> updatedFileContent, boolean useHeader) throws IOException {
        final boolean append = false;
        
        File file = new File(filePath);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
        
        String rawData = formatStrategy.encodeAll(updatedFileContent, useHeader);
        
        out.print(rawData);
        out.close();
    }

    @Override
    public void addNewRecords(List<LinkedHashMap<String, String>> newData, boolean useHeader) throws IOException {
        final boolean append = true;
        
        File file = new File(filePath);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
        
        String rawData = formatStrategy.encodeAll(newData, useHeader);
        
        out.print(rawData);
        out.close();
        
        
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public FileFormatStrategy getFormatStrategy() {
        return formatStrategy;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void setFormatStrategy(FileFormatStrategy formatStrategy) {
        this.formatStrategy = formatStrategy;
    }
    
}
