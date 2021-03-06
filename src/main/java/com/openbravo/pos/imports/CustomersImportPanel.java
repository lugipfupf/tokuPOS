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

import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.customers.DataLogicCustomers;
import com.openbravo.pos.customers.JPanelCustomerFields;
import com.openbravo.pos.customers.JPanelCustomerList;
import com.unicenta.pozapps.forms.AppLocal;

public class CustomersImportPanel extends JPanelCsvImporter {
    @Override
    protected void init() {
        DataLogicCustomers dlCustomers = (DataLogicCustomers) app.getBean("com.openbravo.pos.customers.DataLogicCustomers");
        this.tableDef = dlCustomers.getTableCustomers();
        
        this.spr = new SaveProvider(this.tableDef, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23});
        
        this.fieldConfigurator = new JPanelCustomerFields();
        this.fieldConfigurator.setComponentOrientation(getComponentOrientation());
        this.itemList = new JPanelCustomerList();
        this.itemList.setComponentOrientation(getComponentOrientation());
        this.container.add(this.fieldConfigurator, java.awt.BorderLayout.CENTER);
        this.container.add(this.itemList, java.awt.BorderLayout.SOUTH);
    }

    @Override
    public EditorRecord getEditor() {
        return null;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.CSVCustomerImport");
    }
    
    @Override
    public void saveData() {
            this.itemList.saveData(this.spr);
    }
}
