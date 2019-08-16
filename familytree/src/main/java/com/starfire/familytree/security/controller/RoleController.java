package com.starfire.familytree.security.controller;

import com.starfire.familytree.response.Response;
import com.starfire.familytree.security.entity.Role;
import com.starfire.familytree.security.service.IRoleService;
import com.starfire.familytree.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

/**
 * <p>
 * 角色操作控制器
 * </p>
 *
 * @author luzh
 * @since 2019-03-03
 */
@Controller
@RequestMapping("/security/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;

	@RequestMapping("/add")
	public String add() {
		
		return "/security/role/add";
	}
	@RequestMapping("/page")
	public String page(Model model,PageInfo<Map<String,Object>, Role> page) {
		PageInfo<Map<String,Object>,Role> pageInfo = roleService.page(page);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("roles", pageInfo.getResult());
		return "/security/role/list";
	}
	/**
	 * 新增或修改
	 *
	 * @param role
	 * @return
	 * @author luzh
	 */
	@RequestMapping("/addOrUpdate")
	public String addOrUpdateRole(Model model,@Valid Role role) {
		roleService.saveOrUpdate(role);
		model.addAttribute("role", role);
		return "/security/role/add";

	}

	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 * @author luzh
	 */
	@GetMapping("/delete")
	public Response<String> deleteRole(Long id) {
		boolean flag = roleService.removeById(id);
		Response<String> response = new Response<String>();
		if (!flag) {
			return response.failure();
		}
		return response.success();

	}

	/**
	 * 分页
	 *
	 * @param page
	 * @return
	 * @author luzh
	 */
//	@RequestMapping("/page")
	public Response<PageInfo<Map<String, Object>, Role>> page(@RequestBody PageInfo<Map<String, Object>, Role> page) {
		PageInfo<Map<String, Object>, Role> pageInfo = roleService.page(page);
		Response<PageInfo<Map<String, Object>, Role>> response = new Response<PageInfo<Map<String, Object>, Role>>();
		return response.success(pageInfo);

	}
}
