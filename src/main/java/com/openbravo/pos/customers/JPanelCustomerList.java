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
package com.openbravo.pos.customers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.Populator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelPopulatable;
import com.openbravo.pos.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Beat Luginbühl <lugi@lugipfupf.ch>
 */
public class JPanelCustomerList extends JPanelPopulatable {
    private final CustomerListModel model = new CustomerListModel();
    private HashMap<String, String> config;

    /**
     * Creates new form JPanelItemList
     */
    public JPanelCustomerList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        tblData.setModel(model);
        jScrollPane1.setViewportView(tblData);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    
    @Override
    public Populator<ArrayList<HashMap<String, String>>> getPopulator() {
        return (ArrayList<HashMap<String, String>> data) -> {
            if (this.config == null) {
                throw new IllegalStateException("No config has been set. Don't know how to treat data.");
            }
            
            ArrayList<CustomerListItem> customers = new ArrayList<>();
            
            data.forEach((HashMap<String, String> record) -> {
                CustomerInfoExt cust = new CustomerInfoExt(null);
                
                String card = this.config.get("card").equals("GENERATE") ? "c" + StringUtils.getCardNumber() : record.get(this.config.get("card"));
                
                cust.setCard(card);
                cust.setSearchkey(card);
                cust.setFirstname(record.get(this.config.get("firstname")));
                cust.setLastname(record.get(this.config.get("lastname")));
                cust.setName(record.get(this.config.get("firstname")) + " " + record.get(this.config.get("lastname")));
                cust.setTaxid(record.get(this.config.get("taxid")));
                cust.setNotes(record.get(this.config.get("notes")));
                cust.setVisible(true);
                cust.setEmail(record.get(this.config.get("email")));
                cust.setPhone(record.get(this.config.get("phone")));
                cust.setPhone2(record.get(this.config.get("phone2")));
                cust.setFax(record.get(this.config.get("fax")));
                cust.setAddress(record.get(this.config.get("address")));
                cust.setAddress2(record.get(this.config.get("address2")));
                cust.setPostal(record.get(this.config.get("postal")));
                cust.setCity(record.get(this.config.get("city")));
                cust.setCountry(record.get(this.config.get("country")));
                cust.setRegion(record.get(this.config.get("region")));
                
                Double maxDept = 0d;
                if (record.get(this.config.get("maxdept")) != null && record.get(this.config.get("maxdept")).length() > 0) {
                    try {
                        maxDept = Double.valueOf(record.get(this.config.get("maxdept")));
                    } catch (NumberFormatException ex) {
                        Logger.getLogger(JPanelCustomerList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                cust.setMaxdebt(maxDept);
                
                boolean isExisting = false;
                boolean doImport = !isExisting;
                
                customers.add(new CustomerListItem(cust, isExisting, doImport));
            });
            
            this.model.setData(customers);
        };
    }
    
    @Override
    public HashMap<String, String> getConfig() {
        return null;
    }

    @Override
    public void setConfig(HashMap<String, String> config) {
        this.config = config;
    }

    @Override
    public boolean deactivate() {
        return this.model.clearData();
    }

    @Override
    public void saveData(SaveProvider spr) {
        this.model.getData().forEach((CustomerListItem item) -> {
            Object[] customer = new Object[24];
            try {
                if (item.doImport) {
                    CustomerInfoExt custInfoExt = item.getCustomer();
                    
                    customer[0] = custInfoExt.getId() == null ? UUID.randomUUID().toString() : custInfoExt.getId();
                    customer[1] = custInfoExt.getTaxid();
                    customer[2] = custInfoExt.getSearchkey();
                    customer[3] = custInfoExt.getName();
                    customer[4] = custInfoExt.getNotes();
                    customer[5] = custInfoExt.isVisible();
                    customer[6] = custInfoExt.getCard();
                    customer[7] = custInfoExt.getMaxdebt();
                    customer[8] = null;
                    customer[9] = null;

                    customer[10] = custInfoExt.getFirstname();
                    customer[11] = custInfoExt.getLastname();
                    customer[12] = custInfoExt.getEmail();
                    customer[13] = custInfoExt.getPhone();
                    customer[14] = custInfoExt.getPhone2();
                    customer[15] = custInfoExt.getFax();

                    customer[16] = custInfoExt.getAddress();
                    customer[17] = custInfoExt.getAddress2();
                    customer[18] = custInfoExt.getPostal();
                    customer[19] = custInfoExt.getCity();
                    customer[20] = custInfoExt.getRegion();
                    customer[21] = custInfoExt.getCountry();

                    customer[22] = null;
                    customer[23] = null;
                    
                    if (item.isExisting()) {
                        spr.updateData(customer);
                    } else {
                        spr.insertData(customer);
                    }
                }
            } catch (BasicException ex) {
                Logger.getLogger(JPanelCustomerList.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables

    private class CustomerListModel extends AbstractTableModel {
        private ArrayList<CustomerListItem> customerList = new ArrayList<>();
        private final HashMap<Integer, String> colNames = new HashMap<>();
        private final HashMap<Integer, Class> colTypes = new HashMap<>();
        
        public CustomerListModel() {
            colNames.put(0, AppLocal.getIntString("label.import"));
            colNames.put(1, AppLocal.getIntString("label.entry_exists"));
            colNames.put(2, AppLocal.getIntString("label.card"));
            colNames.put(3, AppLocal.getIntString("label.firstname"));
            colNames.put(4, AppLocal.getIntString("label.lastname"));
            colNames.put(5, AppLocal.getIntString("label.address"));
            colNames.put(6, AppLocal.getIntString("label.city"));
            colNames.put(7, AppLocal.getIntString("label.email"));
            
            colTypes.put(0, Boolean.class);
            colTypes.put(1, Boolean.class);
            colTypes.put(2, String.class);
            colTypes.put(3, String.class);
            colTypes.put(4, String.class);
            colTypes.put(5, String.class);
            colTypes.put(6, String.class);
            colTypes.put(7, String.class);
        }
        
        public void setData(ArrayList<CustomerListItem> customers) {
            this.customerList = customers;
            
            fireTableDataChanged();
        }
        
        public ArrayList<CustomerListItem> getData() {
            return this.customerList;
        }

        @Override
        public String getColumnName(int column) {
            return this.colNames.get(column);
        }
        
        @Override
        public Class<?> getColumnClass(int col) {
            return this.colTypes.get(col);
        }
        
        @Override
        public int getRowCount() {
            return customerList.size();
        }

        @Override
        public int getColumnCount() {
            return colNames.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            CustomerListItem customer = this.customerList.get(rowIndex);
            
            switch (columnIndex) {
                case 0:
                    return customer.getDoImport();
                case 1:
                    return customer.isExisting();
                case 2:
                    return customer.getCustomer().getCard();
                case 3:
                    return customer.getCustomer().getFirstname();
                case 4:
                    return customer.getCustomer().getLastname();
                case 5:
                    return customer.getCustomer().getAddress();
                case 6:
                    return customer.getCustomer().getCity();
                case 7:
                    return customer.getCustomer().getEmail();
            }
            
            return null;
        }
        
        public boolean clearData() {
            this.customerList.clear();
            fireTableDataChanged();
            return this.getRowCount() == 0;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return true;
            }
            
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            this.customerList.get(rowIndex).setDoImport((Boolean) aValue);
        }
    }
    
    private class CustomerListItem {
        private CustomerInfoExt customer;
        private boolean isExisting = false;
        private boolean doImport = true;

        public CustomerListItem(CustomerInfoExt customerInfoExt, boolean isExisting, boolean doImport) {
            this.customer = customerInfoExt;
            this.isExisting = isExisting;
            this.doImport = doImport;
        }
        
        public CustomerInfoExt getCustomer() {
            return customer;
        }

        public boolean isExisting() {
            return isExisting;
        }
        
        public void setDoImport(boolean doIt) {
            this.doImport = doIt;
        }
        
        public boolean getDoImport() {
            return this.doImport;
        }
    }
}
