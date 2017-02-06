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

import com.openbravo.data.gui.Populator;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.imports.JPanelCsvImporter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JPanelCSVFileChooser extends JPanelPopulatable {

    private static final String FILE_FILTER_DESCRIPTION = "CSV Files *.csv";
    private static final String FILE_FILTER = "csv";
    private static final char CSV_DEFAULT_DELIMITER = ',';
    private static final char CSV_DEFAULT_QUOTE = '"';

    private final JPanelCsvImporter csvImporter;
    private final JFileChooser fileChooser;

    /**
     *
     */
    public JPanelCSVFileChooser(JPanelCsvImporter importer) {
        this.csvImporter = importer;

        initComponents();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(FILE_FILTER_DESCRIPTION, FILE_FILTER);

        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileFilter(filter);
        this.fileChooser.setMultiSelectionEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblFile = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        btnFile = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblConfig = new javax.swing.JLabel();
        lblDelim = new javax.swing.JLabel();
        txtDelim = new javax.swing.JTextField();
        lblQuote = new javax.swing.JLabel();
        txtQuote = new javax.swing.JTextField();
        lblRecordsFound = new javax.swing.JLabel();
        txtRecordsFound = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(186, 84));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        lblFile.setText(AppLocal.getIntString("label.csvfile")); // NOI18N
        lblFile.setPreferredSize(new java.awt.Dimension(80, 16));
        lblFile.setRequestFocusEnabled(false);
        jPanel1.add(lblFile);

        txtFile.setPreferredSize(new java.awt.Dimension(400, 30));
        txtFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFileActionPerformed(evt);
            }
        });
        jPanel1.add(txtFile);

        btnFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/fileopen.png"))); // NOI18N
        btnFile.setToolTipText(AppLocal.getIntString("label.csvfile")); // NOI18N
        btnFile.setMargin(new java.awt.Insets(8, 2, 8, 2));
        btnFile.setPreferredSize(new java.awt.Dimension(52, 40));
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });
        jPanel1.add(btnFile);

        btnRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        btnRead.setToolTipText(AppLocal.getIntString("label.csv")); // NOI18N
        btnRead.setEnabled(false);
        btnRead.setMargin(new java.awt.Insets(8, 2, 8, 2));
        btnRead.setPreferredSize(new java.awt.Dimension(52, 40));
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });
        jPanel1.add(btnRead);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/filesave.png"))); // NOI18N
        btnSave.setToolTipText(AppLocal.getIntString("Button.Save")); // NOI18N
        btnSave.setEnabled(false);
        btnSave.setMargin(new java.awt.Insets(8, 2, 8, 2));
        btnSave.setPreferredSize(new java.awt.Dimension(52, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        jPanel3.add(jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        lblConfig.setText(AppLocal.getIntString("label.options")); // NOI18N
        lblConfig.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel2.add(lblConfig);

        lblDelim.setText(AppLocal.getIntString("label.csvdelimit")); // NOI18N
        jPanel2.add(lblDelim);

        txtDelim.setText(String.valueOf(CSV_DEFAULT_DELIMITER));
        txtDelim.setPreferredSize(new java.awt.Dimension(32, 28));
        txtDelim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDelimKeyTypedHandler(evt);
            }
        });
        jPanel2.add(txtDelim);

        lblQuote.setText(AppLocal.getIntString("label.csvquote")); // NOI18N
        jPanel2.add(lblQuote);

        txtQuote.setText(String.valueOf(CSV_DEFAULT_QUOTE));
        txtQuote.setPreferredSize(new java.awt.Dimension(32, 28));
        txtQuote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuoteKeyTypedHandler(evt);
            }
        });
        jPanel2.add(txtQuote);

        lblRecordsFound.setText(AppLocal.getIntString("label.csvrecordsfound")); // NOI18N
        jPanel2.add(lblRecordsFound);

        txtRecordsFound.setEditable(false);
        txtRecordsFound.setBackground(new java.awt.Color(204, 204, 204));
        txtRecordsFound.setToolTipText("");
        txtRecordsFound.setPreferredSize(new java.awt.Dimension(60, 28));
        jPanel2.add(txtRecordsFound);

        jPanel3.add(jPanel2);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {
            this.csvImporter.readCsvData();
            this.btnSave.setEnabled(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JPanelCSVFileChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.txtFile.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
        
        this.readCsvMetaData();
    }//GEN-LAST:event_btnFileActionPerformed

    private void txtDelimKeyTypedHandler(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDelimKeyTypedHandler
        if (txtDelim.getText().length() > 0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDelimKeyTypedHandler

    private void txtQuoteKeyTypedHandler(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuoteKeyTypedHandler
        if (txtQuote.getText().length() > 0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuoteKeyTypedHandler

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFileActionPerformed
        this.readCsvMetaData();
    }//GEN-LAST:event_txtFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblConfig;
    private javax.swing.JLabel lblDelim;
    private javax.swing.JLabel lblFile;
    private javax.swing.JLabel lblQuote;
    private javax.swing.JLabel lblRecordsFound;
    private javax.swing.JTextField txtDelim;
    private javax.swing.JTextField txtFile;
    private javax.swing.JTextField txtQuote;
    private javax.swing.JTextField txtRecordsFound;
    // End of variables declaration//GEN-END:variables

    @Override
    public Populator<Integer> getPopulator() {
        return recordCount -> this.txtRecordsFound.setText(String.valueOf(recordCount));
    }
    
    @Override
    public boolean deactivate() {
        this.txtFile.setText("");
        this.txtRecordsFound.setText("");
        return true;
    }
    
    private void readCsvMetaData() {
        if (this.txtFile.getText().length() > 0) {
            try {
                if (this.txtDelim.getText().length() < 1) {
                    this.txtDelim.setText(String.valueOf(CSV_DEFAULT_DELIMITER));
                }
                if (this.txtQuote.getText().length() < 1) {
                    this.txtQuote.setText(String.valueOf(CSV_DEFAULT_QUOTE));
                }

                this.csvImporter.readCsvMetaData(this.txtFile.getText(), this.txtDelim.getText().charAt(0), this.txtQuote.getText().charAt(0));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JPanelCSVFileChooser.class.getName()).log(
                        Level.WARNING, "{0}: {1}", new Object[]{ex.getMessage(), this.txtFile.getText()}
                );
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        AppLocal.getIntString("label.error.filenotfound.title"), JOptionPane.ERROR_MESSAGE);
            }

            this.btnRead.setEnabled(true);
            this.btnSave.setEnabled(false);
        }
    }

    @Override
    public HashMap<String, String> getConfig() {
        return null;
    }

    @Override
    public void setConfig(HashMap<String, String> config) {
    }
}
