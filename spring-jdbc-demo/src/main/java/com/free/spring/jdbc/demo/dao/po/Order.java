package com.free.spring.jdbc.demo.dao.po;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private Long tid;
    private String reseiveAddress;
    private String buyerName;
    private String buyerPhone;
    private Date creationDate;
}
