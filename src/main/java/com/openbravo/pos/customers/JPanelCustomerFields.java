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

import com.openbravo.data.gui.Populator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelPopulatable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;

/**
 *
 * @author Beat Luginbühl <lugi@lugipfupf.ch>
 */
public class JPanelCustomerFields extends JPanelPopulatable {
    
    public static String CARD_GENERATE = "GENERATE";

    private ArrayList<JComboBox> combos = new ArrayList<>();

    /**
     * Creates new form JPanelCustomers
     */
    public JPanelCustomerFields() {
        initComponents();

        combos.add(cmbCard);
        combos.add(cmbAccountId);
        combos.add(cmbSearchKey);
        combos.add(cmbFirstName);
        combos.add(cmbTaxCat);
        combos.add(cmbLastName);
        combos.add(cmbCreditLimit);
        combos.add(cmbEmail);
        combos.add(cmbPhone1);
        combos.add(cmbPhone2);
        combos.add(cmbFax);
        combos.add(cmbAddress1);
        combos.add(cmbAddress2);
        combos.add(cmbCity);
        combos.add(cmbRegion);
        combos.add(cmbZip);
        combos.add(cmbCountry);
        combos.add(cmbNotes);
        combos.add(cmbVisible);
    }
    
    @Override
    public HashMap<String, String> getConfig() {
        HashMap<String, String> config = new HashMap<>();

        config.put("card", chkCardGenerate.isSelected() ? CARD_GENERATE : (String) cmbCard.getSelectedItem());
        config.put("taxid", (String) cmbTaxCat.getSelectedItem());
        config.put("notes", (String) cmbNotes.getSelectedItem());
        config.put("visible", (String) cmbVisible.getSelectedItem());
        config.put("firstname", (String) cmbFirstName.getSelectedItem());
        config.put("lastname", (String) cmbLastName.getSelectedItem());
        config.put("email", (String) cmbEmail.getSelectedItem());
        config.put("phone", (String) cmbPhone1.getSelectedItem());
        config.put("phone2", (String) cmbPhone2.getSelectedItem());
        config.put("fax", (String) cmbFax.getSelectedItem());
        config.put("address", (String) cmbAddress1.getSelectedItem());
        config.put("address2", (String) cmbAddress2.getSelectedItem());
        config.put("postal", (String) cmbZip.getSelectedItem());
        config.put("city", (String) cmbCity.getSelectedItem());
        config.put("region", (String) cmbRegion.getSelectedItem());
        config.put("country", (String) cmbCountry.getSelectedItem());
        config.put("searchkey", (String) cmbSearchKey.getSelectedItem());
        config.put("taxid", (String) cmbTaxCat.getSelectedItem());
        config.put("maxdept", (String) cmbCreditLimit.getSelectedItem());
        
        return config;
    }
    
    @Override
    public Populator<ArrayList<String>> getPopulator() {
        return headerList -> {
            for (JComboBox box : this.combos) {
                box.addItem("");
                for (String header : headerList) {
                    box.addItem(header);
                }
                
                if (headerList.contains(box.getName())) {
                    box.setSelectedItem(box.getName());
                }
            }
        };
    }
    
    @Override
    public boolean deactivate() {
        this.combos.stream().forEach((box) -> {
            box.removeAllItems();
        });
        return true;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFields = new javax.swing.JPanel();
        lblCard = new javax.swing.JLabel();
        cmbCard = new javax.swing.JComboBox<>();
        chkCardGenerate = new javax.swing.JCheckBox();
        lblDummy = new javax.swing.JLabel();
        lblAccountId = new javax.swing.JLabel();
        cmbAccountId = new javax.swing.JComboBox<>();
        lblSearchKey = new javax.swing.JLabel();
        cmbSearchKey = new javax.swing.JComboBox<>();
        lblFirstName = new javax.swing.JLabel();
        cmbFirstName = new javax.swing.JComboBox<>();
        lblTaxCat = new javax.swing.JLabel();
        cmbTaxCat = new javax.swing.JComboBox<>();
        lblLastName = new javax.swing.JLabel();
        cmbLastName = new javax.swing.JComboBox<>();
        lblCreditLimit = new javax.swing.JLabel();
        cmbCreditLimit = new javax.swing.JComboBox<>();
        lblEmail = new javax.swing.JLabel();
        cmbEmail = new javax.swing.JComboBox<>();
        lblPhone1 = new javax.swing.JLabel();
        cmbPhone1 = new javax.swing.JComboBox<>();
        lblPhone2 = new javax.swing.JLabel();
        cmbPhone2 = new javax.swing.JComboBox<>();
        lblFax = new javax.swing.JLabel();
        cmbFax = new javax.swing.JComboBox<>();
        lblAddress1 = new javax.swing.JLabel();
        cmbAddress1 = new javax.swing.JComboBox<>();
        lblAddress2 = new javax.swing.JLabel();
        cmbAddress2 = new javax.swing.JComboBox<>();
        lblCity = new javax.swing.JLabel();
        cmbCity = new javax.swing.JComboBox<>();
        lblRegion = new javax.swing.JLabel();
        cmbRegion = new javax.swing.JComboBox<>();
        lblZip = new javax.swing.JLabel();
        cmbZip = new javax.swing.JComboBox<>();
        lblCountry = new javax.swing.JLabel();
        cmbCountry = new javax.swing.JComboBox<>();
        lblNotes = new javax.swing.JLabel();
        cmbNotes = new javax.swing.JComboBox<>();
        lblVisible = new javax.swing.JLabel();
        cmbVisible = new javax.swing.JComboBox<>();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        pnlFields.setLayout(new java.awt.GridLayout(0, 4, 10, 0));

        lblCard.setText(AppLocal.getIntString("label.card")); // NOI18N
        pnlFields.add(lblCard);

        cmbCard.setEnabled(false);
        cmbCard.setName("card"); // NOI18N
        pnlFields.add(cmbCard);

        chkCardGenerate.setSelected(true);
        chkCardGenerate.setText(AppLocal.getIntString("label.generate")); // NOI18N
        chkCardGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCardGenerateActionPerformed(evt);
            }
        });
        pnlFields.add(chkCardGenerate);
        pnlFields.add(lblDummy);

        lblAccountId.setText(AppLocal.getIntString("label.taxid")); // NOI18N
        pnlFields.add(lblAccountId);

        cmbAccountId.setToolTipText("");
        cmbAccountId.setName("id"); // NOI18N
        pnlFields.add(cmbAccountId);

        lblSearchKey.setText(AppLocal.getIntString("label.searchkey")); // NOI18N
        pnlFields.add(lblSearchKey);

        cmbSearchKey.setName("search_key"); // NOI18N
        pnlFields.add(cmbSearchKey);

        lblFirstName.setText(AppLocal.getIntString("label.firstname")); // NOI18N
        pnlFields.add(lblFirstName);

        cmbFirstName.setName("first_name"); // NOI18N
        pnlFields.add(cmbFirstName);

        lblTaxCat.setText(AppLocal.getIntString("label.custtaxcategory")); // NOI18N
        pnlFields.add(lblTaxCat);

        cmbTaxCat.setName("taxcat"); // NOI18N
        pnlFields.add(cmbTaxCat);

        lblLastName.setText(AppLocal.getIntString("label.lastname")); // NOI18N
        pnlFields.add(lblLastName);

        cmbLastName.setName("last_name"); // NOI18N
        pnlFields.add(cmbLastName);

        lblCreditLimit.setText(AppLocal.getIntString("label.maxdebt")); // NOI18N
        pnlFields.add(lblCreditLimit);

        cmbCreditLimit.setName("credit_limit"); // NOI18N
        pnlFields.add(cmbCreditLimit);

        lblEmail.setText(AppLocal.getIntString("label.email")); // NOI18N
        pnlFields.add(lblEmail);

        cmbEmail.setName("email"); // NOI18N
        pnlFields.add(cmbEmail);

        lblPhone1.setText(AppLocal.getIntString("label.phone")); // NOI18N
        pnlFields.add(lblPhone1);

        cmbPhone1.setName("telephone"); // NOI18N
        pnlFields.add(cmbPhone1);

        lblPhone2.setText(AppLocal.getIntString("label.phone2")); // NOI18N
        pnlFields.add(lblPhone2);

        cmbPhone2.setName("mobile"); // NOI18N
        pnlFields.add(cmbPhone2);

        lblFax.setText(AppLocal.getIntString("label.fax")); // NOI18N
        pnlFields.add(lblFax);

        cmbFax.setName("fax"); // NOI18N
        pnlFields.add(cmbFax);

        lblAddress1.setText(AppLocal.getIntString("label.address")); // NOI18N
        pnlFields.add(lblAddress1);

        cmbAddress1.setName("address"); // NOI18N
        pnlFields.add(cmbAddress1);

        lblAddress2.setText(AppLocal.getIntString("label.address2")); // NOI18N
        pnlFields.add(lblAddress2);

        cmbAddress2.setName("address2"); // NOI18N
        pnlFields.add(cmbAddress2);

        lblCity.setText(AppLocal.getIntString("label.city")); // NOI18N
        pnlFields.add(lblCity);

        cmbCity.setName("city"); // NOI18N
        pnlFields.add(cmbCity);

        lblRegion.setText(AppLocal.getIntString("label.region")); // NOI18N
        pnlFields.add(lblRegion);

        cmbRegion.setName("state"); // NOI18N
        pnlFields.add(cmbRegion);

        lblZip.setText(AppLocal.getIntString("label.postal")); // NOI18N
        pnlFields.add(lblZip);

        cmbZip.setName("zip"); // NOI18N
        pnlFields.add(cmbZip);

        lblCountry.setText(AppLocal.getIntString("label.country")); // NOI18N
        pnlFields.add(lblCountry);

        cmbCountry.setName("country"); // NOI18N
        pnlFields.add(cmbCountry);

        lblNotes.setText(AppLocal.getIntString("label.notes")); // NOI18N
        pnlFields.add(lblNotes);

        cmbNotes.setName("comments"); // NOI18N
        pnlFields.add(cmbNotes);

        lblVisible.setText(AppLocal.getIntString("label.visible")); // NOI18N
        pnlFields.add(lblVisible);

        cmbVisible.setName("visible"); // NOI18N
        pnlFields.add(cmbVisible);

        add(pnlFields);
    }// </editor-fold>//GEN-END:initComponents

    private void chkCardGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCardGenerateActionPerformed
        cmbCard.setEnabled(!chkCardGenerate.isSelected());
    }//GEN-LAST:event_chkCardGenerateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkCardGenerate;
    private javax.swing.JComboBox<String> cmbAccountId;
    private javax.swing.JComboBox<String> cmbAddress1;
    private javax.swing.JComboBox<String> cmbAddress2;
    private javax.swing.JComboBox<String> cmbCard;
    private javax.swing.JComboBox<String> cmbCity;
    private javax.swing.JComboBox<String> cmbCountry;
    private javax.swing.JComboBox<String> cmbCreditLimit;
    private javax.swing.JComboBox<String> cmbEmail;
    private javax.swing.JComboBox<String> cmbFax;
    private javax.swing.JComboBox<String> cmbFirstName;
    private javax.swing.JComboBox<String> cmbLastName;
    private javax.swing.JComboBox<String> cmbNotes;
    private javax.swing.JComboBox<String> cmbPhone1;
    private javax.swing.JComboBox<String> cmbPhone2;
    private javax.swing.JComboBox<String> cmbRegion;
    private javax.swing.JComboBox<String> cmbSearchKey;
    private javax.swing.JComboBox<String> cmbTaxCat;
    private javax.swing.JComboBox<String> cmbVisible;
    private javax.swing.JComboBox<String> cmbZip;
    private javax.swing.JLabel lblAccountId;
    private javax.swing.JLabel lblAddress1;
    private javax.swing.JLabel lblAddress2;
    private javax.swing.JLabel lblCard;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblCreditLimit;
    private javax.swing.JLabel lblDummy;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFax;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblPhone2;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblSearchKey;
    private javax.swing.JLabel lblTaxCat;
    private javax.swing.JLabel lblVisible;
    private javax.swing.JLabel lblZip;
    private javax.swing.JPanel pnlFields;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setConfig(HashMap<String, String> config) {
    }

    @Override
    public void saveData(SaveProvider spr) {
    }
}
