package com.starfire.familytree.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starfire.familytree.basic.entity.Dict;
import com.starfire.familytree.vo.PageInfo;

import java.util.Map;

/**
 * <p>
 * 系统字典数据服务类
 * </p>
 *
 * @author luzh
 * @since 2019-03-06
 */
public interface IDictService extends IService<Dict> {

    public PageInfo<Map<String, Object>, Dict> page(PageInfo<Map<String, Object>, Dict> page);

}
