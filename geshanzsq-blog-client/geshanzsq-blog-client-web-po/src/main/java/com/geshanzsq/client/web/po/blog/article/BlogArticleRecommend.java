package com.geshanzsq.client.web.po.blog.article;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章推荐
 *
 * @author geshanzsq
 * @date 2022/8/20
 */
@Data
public class BlogArticleRecommend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推荐 id
     */
    @TableId
    private Long id;

    /**
     * 推荐等级
     */
    private Integer recommendLevel;

    /**
     * 文章 id
     */
    @TableField("fk_article_id")
    private Long articleId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 创建人用户 id
     */
    @TableField("fk_create_user_id")
    private Long createUserId;

    /**
     * 修改时间
     */
    private Date gmtModify;

    /**
     * 修改人用户 id
     */
    @TableField("fk_modify_user_id")
    private Long modifyUserId;
}