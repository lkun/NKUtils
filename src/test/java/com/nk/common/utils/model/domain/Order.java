package com.nk.common.utils.model.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Order {

    private long id;

    private int traceNo;

    private Date createAt;

    private Date updateAt;
}
