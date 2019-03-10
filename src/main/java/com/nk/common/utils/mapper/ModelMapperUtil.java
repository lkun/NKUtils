package com.nk.common.utils.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author LK
 */
public class ModelMapperUtil {
    private static final Logger logger = LoggerFactory.getLogger(ModelMapperUtil.class);
    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * List<Source> to List<Target>
     *
     * @param sourceList 源数据
     * @param t          目标对象
     * @param <S>        源对象泛型
     * @param <T>        目标对象泛型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertList(List<S> sourceList, Class<T> t) {
        List<T> targetList = new ArrayList<>();
        if (Objects.isNull(sourceList) || sourceList.isEmpty()) {
            return targetList;
        }
        targetList = sourceList.stream().map(source -> {
            try {
                return (T) modelMapper.map(source, t.newInstance().getClass());
            } catch (InstantiationException e) {
                logger.error("实例化出错：", e);
            } catch (IllegalAccessException e) {
                logger.error("反射参数不合法：", e);
            }

            return null;
        }).collect(Collectors.toList());

        return targetList;
    }

    /**
     * 转成bean
     *
     * @param s 源
     * @param tClass 目标
     * @param <S>    泛型
     * @param <T>    泛型
     * @return 返回bean
     */
    public static <S, T> T convertBean(S s, Class<T> tClass) {
        if (Objects.isNull(s)) {
            return null;
        }

        return modelMapper.map(s, tClass);
    }
}
