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
import com.openbravo.pos.panels.JPanelCsvImporter;
import com.unicenta.pozapps.forms.AppLocal;

public class CustomersImportPanel extends JPanelCsvImporter {
    JPanelCustomerFields fieldConfigurator;
    
    @Override
    protected void init() {
        super.init();
        
        this.fieldConfigurator = new JPanelCustomerFields();
        this.fieldConfigurator.setComponentOrientation(getComponentOrientation());
        this.container.add(this.fieldConfigurator);
    }

    @Override
    public EditorRecord getEditor() {
        return null;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.CSVCustomerImport");
    }
}
