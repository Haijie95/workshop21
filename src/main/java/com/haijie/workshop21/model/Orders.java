package com.haijie.workshop21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private int id;
    private int employeeId;
    private int customerId;
    private Date orderDate;
    private Date shippedDate;
    private int shopperId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipStateProvince;
    private String shipZipPostalCode;
    private String shipCountryRegion;
    private BigDecimal shippingFee;
    private BigDecimal taxes;
    private String paymentType;
    private Date paidDate;
    private String notes;
    private int taxRate;
    //private int taxStatusId;
    private int statusId;
}
