/*
 * Copyright (C) 2016 Beat Luginbühl <lugi@lugipfupf.ch>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.openbravo.pos.imports;

import com.csvreader.CsvReader;
import com.openbravo.pos.panels.JPanelCSVFileChooser;
import com.openbravo.pos.panels.JPanelPopulatable;
import com.openbravo.pos.panels.JPanelTable2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beat Luginbühl <lugi@lugipfupf.ch>
 */
public abstract class JPanelCsvImporter extends JPanelTable2 {
    protected JPanelCSVFileChooser fileChooserPanel;
    protected JPanelPopulatable fieldConfigurator;
    protected JPanelPopulatable itemList;
    
    private CsvReader csvReader;
    private String csvFileName;
    private char csvDelimiter;
    private char csvQuote;
    private String[] csvHeaders;
    
    @Override
    protected void init() {
    }
    
    @Override
    public void activate() {
        startNavigation();
    }
    
    @Override
    protected void startNavigation() {
        this.fileChooserPanel = new JPanelCSVFileChooser(this);
        this.fileChooserPanel.setComponentOrientation(getComponentOrientation());
        this.toolbar.add(this.fileChooserPanel);
    }        
    
    @Override
    public boolean deactivate() {
        this.fieldConfigurator.deactivate();
        this.fileChooserPanel.deactivate();
        this.itemList.deactivate();
        return true;
    }
    
    public void readCsvMetaData(String csvFileName, char delimiter, char quote) throws FileNotFoundException {
        this.csvFileName = csvFileName;
        this.csvDelimiter = delimiter;
        this.csvQuote = quote;
        
        initCsvReader();
        
        try {
            this.csvReader.readHeaders();
            String[] headers = this.csvReader.getHeaders();
            
            int recordCount = 0;
            while (this.csvReader.skipRecord()) {
                recordCount++;
            }
            ArrayList<String> headerList = new ArrayList<>();
            headerList.addAll(Arrays.asList(headers));
            
            this.fileChooserPanel.getPopulator().populate(recordCount);
            this.fieldConfigurator.getPopulator().populate(headerList);
            
            this.csvReader.close();
        } catch (IOException ex) {
            Logger.getLogger(JPanelCsvImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readCsvData() throws FileNotFoundException {
        initCsvReader();

        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        
        try {
            this.csvReader.readHeaders();
            while (this.csvReader.readRecord()) {
                data.add(this.readCsvLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(JPanelCsvImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.itemList.setConfig(this.fieldConfigurator.getConfig());
        this.itemList.getPopulator().populate(data);
    }
    
    private void initCsvReader() throws FileNotFoundException {
        if (this.csvFileName == null) {
            throw new ImportException("No csv metadata present");
        }
        
        this.csvReader = new CsvReader(this.csvFileName, this.csvDelimiter, Charset.forName("UTF-8"));
        this.csvReader.setTextQualifier(this.csvQuote);
    }
    
    private HashMap<String, String> readCsvLine() throws IOException {
        HashMap<String, String> data = new HashMap<>();
        
        if (this.csvHeaders == null) {
            this.csvHeaders = this.csvReader.getHeaders();
        }
        String[] values = this.csvReader.getValues();
        
        for (int i = 0; i < csvHeaders.length; i++) {
            data.put(csvHeaders[i], values[i]);
        }
        
        return data;
    }
}
