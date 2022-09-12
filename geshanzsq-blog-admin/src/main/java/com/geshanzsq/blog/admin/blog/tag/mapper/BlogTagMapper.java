package com.geshanzsq.blog.admin.blog.tag.mapper;

import com.geshanzsq.blog.admin.blog.tag.dto.BlogTagPageDTO;
import com.geshanzsq.blog.admin.blog.tag.po.BlogTag;
import com.geshanzsq.blog.admin.blog.tag.vo.BlogTagVO;
import com.geshanzsq.blog.common.framework.mybatis.page.vo.PageVO;
import com.geshanzsq.blog.common.framework.mybatis.plugin.query.LambdaQueryWrapperPlus;
import com.geshanzsq.blog.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 博客标签
 *
 * @author geshanzsq
 * @date 2022/8/16
 */
@Mapper
public interface BlogTagMapper extends BaseMapperPlus<BlogTag> {

    /**
     * 分页
     */
    default PageVO<BlogTag> selectPage(BlogTagPageDTO pageDTO) {
        return selectPage(pageDTO, new LambdaQueryWrapperPlus<BlogTag>()
                .likeIf(BlogTag::getTagName, pageDTO.getTagName())
                .eqIf(BlogTag::getStatus, pageDTO.getStatus())
                .orderByAsc(BlogTag::getSort, BlogTag::getId)
        );
    }

    /**
     * 获取最大排序
     */
    Integer getMaxSort();

    /**
     * 获取标签
     * @param articleIds 文章 id 集合
     * @return
     */
    List<BlogTagVO> selectListByArticleIds(@Param("articleIds") List<Long> articleIds);
}
