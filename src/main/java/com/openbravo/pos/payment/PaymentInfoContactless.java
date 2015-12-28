/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.payment;

/**
 *
 * @author highway
 */
public class PaymentInfoContactless extends PaymentInfo {
    private String m_transactionId;
    private double m_total;
    
    public PaymentInfoContactless(String transactionId, double total) {
        m_transactionId = transactionId;
        m_total = total;
    }

    @Override
    public String getName() {
        return "contactless";
    }

    @Override
    public double getTotal() {
        return m_total;
    }

    @Override
    public PaymentInfo copyPayment() {
        PaymentInfo pi = new PaymentInfoContactless(m_transactionId, m_total);
        
        return pi;
    }

    @Override
    public String getTransactionID() {
        return m_transactionId;
    }

    @Override
    public double getPaid() {
        return 0.0;
    }

    @Override
    public double getChange() {
        return 0.0;
    }

    @Override
    public double getTendered() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCardName() {
        return "contactless";
    }
    
}
