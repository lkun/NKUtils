package com.nk.common.utils.mapper;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.github.jsonzou.jmockdata.TypeReference;
import com.nk.common.utils.model.domain.Address;
import com.nk.common.utils.model.domain.Order;
import com.nk.common.utils.model.domain.User;
import com.nk.common.utils.vo.UserVo;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ModelMapperUtilTest {

    @Test
    public void convertList() {
        List<User> mockUserList = JMockData.mock(new TypeReference<List<User>>() {
        });
        List<UserVo> convertList = ModelMapperUtil.convertList(mockUserList, UserVo.class);
        System.out.println(convertList.get(0).getId());
    }

    @Test
    public void convertBean() {
        User mockUser = JMockData.mock(User.class , new MockConfig()
                .dateRange("2019-03-01" , "2019-03-30"));

        UserVo userVo = ModelMapperUtil.convertBean(mockUser, UserVo.class);
        System.out.println(userVo);
    }

    @Test
    public void test() {
        //方法1
        //数据库实体对象User
        User user = JMockData.mock(User.class , new MockConfig()
                .dateRange("2019-03-01" , "2019-03-30"));

        //需要转换成对外的实体对象UserVo
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUserName(user.getUsername());
        Address address1 = new Address();
        address1.setId(user.getAddress().getId());
        address1.setCity(user.getAddress().getCity());
        userVo.setAddress(address1);
        Order order1 = new Order();
        order1.setId(user.getOrders().get(0).getId());
        order1.setTraceNo(user.getOrders().get(0).getTraceNo());
        order1.setCreateAt(user.getOrders().get(0).getCreateAt());
        order1.setUpdateAt(user.getOrders().get(0).getUpdateAt());
        userVo.setOrders(Arrays.asList(order1));
        System.out.println(userVo);
        //方法2
        UserVo userVo1 = ModelMapperUtil.convertBean(user, UserVo.class);
        System.out.println(userVo1);
    }

}