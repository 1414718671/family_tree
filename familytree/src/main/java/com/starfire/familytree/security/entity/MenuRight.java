package com.starfire.familytree.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author luzh
 * @since 2019-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("security_menu_right")
public class MenuRight implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime createTime;

    private String creater;

    private LocalDateTime updateTime;

    private String updater;

    private Boolean valid;

    private String code;

    private String name;

    private Long menuId;


}
