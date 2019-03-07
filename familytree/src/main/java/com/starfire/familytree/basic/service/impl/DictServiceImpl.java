package com.starfire.familytree.basic.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starfire.familytree.basic.entity.Dict;
import com.starfire.familytree.basic.mapper.DictMapper;
import com.starfire.familytree.basic.service.IDictService;
import com.starfire.familytree.vo.PageInfo;

/**
 * <p>
 *  字典服务实现类
 * </p>
 *
 * @author luzh
 * @since 2019-03-06
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {
	@Override
	public PageInfo<Map<String, Object>, Dict> page(PageInfo<Map<String, Object>, Dict> pageInfo) {
		QueryWrapper<Dict> qw=new QueryWrapper<Dict>();
		Page<Dict> page=pageInfo.toMybatisPlusPage();
		Page<Dict> selectPage = (Page<Dict>) baseMapper.selectPage(page, qw);
		pageInfo.from(selectPage);
		return pageInfo;
	}

}
