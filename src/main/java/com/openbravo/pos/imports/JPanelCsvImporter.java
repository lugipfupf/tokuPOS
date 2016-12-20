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
import com.openbravo.pos.customers.CustomerInfoExt;
import com.openbravo.pos.customers.DataLogicCustomers;
import com.openbravo.pos.customers.JPanelCustomerFields;
import com.openbravo.pos.panels.JPanelCSVFileChooser;
import com.openbravo.pos.panels.JPanelPopulatable;
import com.openbravo.pos.panels.JPanelTable2;
import com.unicenta.pozapps.forms.AppLocal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        this.csvReader = new CsvReader(csvFileName);
        this.csvReader.setDelimiter(delimiter);
        this.csvReader.setTextQualifier(quote);
        
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
        } catch (IOException ex) {
            Logger.getLogger(JPanelCsvImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readCsvData() throws FileNotFoundException {
        if (this.csvReader == null) {
            throw new ImportException("No csv etadata present");
        }
        
        this.itemList.getPopulator().populate(new ArrayList<CustomerInfoExt>());
    }
}
