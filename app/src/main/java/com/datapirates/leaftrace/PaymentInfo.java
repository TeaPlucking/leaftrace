package com.datapirates.leaftrace;

public class PaymentInfo {

        private String pluckersId;
        private double bonus;
        private double payment;

        public PaymentInfo(String pluckersId, double bonus, double payment) {
            this.pluckersId = pluckersId;
            this.bonus = bonus;
            this.payment = payment;
        }

        public String getPluckersId() {
            return pluckersId;
        }

        public double getBonus() {
            return bonus;
        }

        public double getPayment() {
            return payment;
        }
    }


