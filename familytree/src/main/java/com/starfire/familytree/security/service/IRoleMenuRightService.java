package com.starfire.familytree.security.service;

import com.starfire.familytree.security.entity.RoleMenuRight;
import com.starfire.familytree.security.entity.RoleMenuRight;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luzh
 * @since 2019-03-03
 */
public interface IRoleMenuRightService extends IService<RoleMenuRight> {
	public PageInfo<Map<String, Object>, RoleMenuRight> page(PageInfo<Map<String, Object>, RoleMenuRight> pageInfo);
}
