package com.geshanzsq.system.user.dto;

import com.geshanzsq.common.framework.mybatis.page.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户分页查询
 *
 * @author geshanzsq
 * @date 2022/3/27
 */
@Data
@ApiModel("用户分页查询")
public class SysUserPageDTO extends PageDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("状态，1 正常，2 停用")
    private Integer status;

    @ApiModelProperty("用户类型，1 后台用户，2 博客用户")
    private Integer userType;

    @ApiModelProperty("开始创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginGmtCreate;

    @ApiModelProperty("结束创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endGmtCreate;

    @ApiModelProperty(value = "用户 id 集合", hidden = true)
    private List<Long> ids;

    @ApiModelProperty(value = "排除用户 id 集合", hidden = true)
    private List<Long> notIds;

}