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

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.Populator;
import com.openbravo.pos.forms.JPanelView;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Beat Luginbühl <lugi@lugipfupf.ch>
 */
public abstract class JPanelPopulatable extends JPanel implements JPanelView {
    public abstract Populator getPopulator();
    
    public HashMap<String, String> getConfig() {
        throw new UnsupportedOperationException("This optional method has to be overriden in order to use it");
    }
    
    public void setConfig(HashMap<String, String> config) {
        throw new UnsupportedOperationException("This optional method has to be overriden in order to use it");
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public void activate() throws BasicException {
    }

    @Override
    public JComponent getComponent() {
        return this;
    }
}
