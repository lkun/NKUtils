package com.nk.common.utils.vo;


import com.nk.common.utils.model.domain.Address;
import com.nk.common.utils.model.domain.Order;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private long id;

    private String userName;

    private Address address;

    private List<Order> orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
