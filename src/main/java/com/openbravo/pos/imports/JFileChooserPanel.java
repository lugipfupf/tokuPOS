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

import com.openbravo.pos.forms.AppLocal;

public class JFileChooserPanel extends javax.swing.JPanel {

    /**
     *
     */
    public JFileChooserPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFile = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        btnFile = new javax.swing.JButton();

        setLayout(null);

        lblFile.setText(AppLocal.getIntString("label.csvfile")); // NOI18N
        lblFile.setPreferredSize(new java.awt.Dimension(80, 36));
        add(lblFile);
        lblFile.setBounds(0, 0, 80, 36);

        txtFile.setLocation(new java.awt.Point(80, 0));
        txtFile.setPreferredSize(new java.awt.Dimension(14, 30));
        add(txtFile);
        txtFile.setBounds(80, 0, 480, 36);

        btnFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/fileopen.png"))); // NOI18N
        btnFile.setPreferredSize(new java.awt.Dimension(64, 32));
        add(btnFile);
        btnFile.setBounds(560, 0, 64, 36);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFile;
    private javax.swing.JLabel lblFile;
    private javax.swing.JTextField txtFile;
    // End of variables declaration//GEN-END:variables
}
