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
package com.openbravo.pos.panels;

/**
 *
 * @author Beat Luginbühl <lugi@lugipfupf.ch>
 */
public abstract class JPanelCsvImporter extends JPanelTable2 {
    protected JPanelCSVFileChooser fileChooserPanel;
    
    @Override
    protected void init() {
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
        return true;
    }
}
