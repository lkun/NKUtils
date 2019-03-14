package com.nk.common.utils.replace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringReplaceUtilsTest {

    @Test
    public void formatV2() {
        String text = "{place} is a good place, what do you think {user}?";
        Map<String, Object> map = new HashMap<>();
        map.put("place", "广州");
        map.put("user", "kunlv");
        String formatV2 = StringReplaceUtils.replaceMatch(text, map);
        System.out.println(formatV2);
    }

    @Test
    public void batchFormatV2() {
        String text = "{place} is a good place, what do you think {user}?";
        Map<String, Object> map = new HashMap<>();
        map.put("place", "广州");
        map.put("user", "kunlv");
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);
        List<String> batchFormatV2 = StringReplaceUtils.batchFormatV2(text, list);
        System.out.println(batchFormatV2);
    }

    @Test
    public void formatReplace() {
        String text = "{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": 30,\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"userId\": @userId#,\n" +
                "      \"username\": \"@userName#\",\n" +
                "      \"password\": \"@password#\",\n" +
                "      \"nickName\": \"@nickName#\",\n" +
                "      \"avatar\": null,\n" +
                "      \"sex\": \"@sex#\",\n" +
                "      \"phone\": \"@phone#\",\n" +
                "      \"email\": null,\n" +
                "      \"emailVerified\": null,\n" +
                "      \"personId\": null,\n" +
                "      \"personType\": null,\n" +
                "      \"state\": 0,\n" +
                "      \"createTime\": \"@createTime#\",\n" +
                "      \"updateTime\": \"@updateTime#\",\n" +
                "      \"roleId\": 1,\n" +
                "      \"roleName\": \"@roleName#\",\n" +
                "      \"roles\": [\n" +
                "        {\n" +
                "          \"roleId\": @roleId#,\n" +
                "          \"roleName\": \"@roleName#\",\n" +
                "          \"comments\": null,\n" +
                "          \"isDelete\": null,\n" +
                "          \"createTime\": null,\n" +
                "          \"updateTime\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Map<String, Object> map = new HashMap<>();
        map.put("userId" , 123);
        map.put("userName", "吕坤");
        map.put("password", "123456");
        map.put("nickName", "超级管理员");
        map.put("sex", "男");
        map.put("phone", "18825121658");
        map.put("createTime", "2019-03-14 23:20:00");
        map.put("updateTime", "2019-03-14 23:21:00");
        map.put("roleId"  ,1);
        map.put("roleName", "超级管理员");


        String formatV2 = StringReplaceUtils.replaceMatch(text, map);

        System.out.println(formatV2);
    }
}