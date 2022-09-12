package com.geshanzsq.blog.admin.blog.article.mapstruct;

import com.geshanzsq.blog.admin.blog.article.dto.BlogArticleSaveDTO;
import com.geshanzsq.blog.admin.blog.article.dto.BlogArticleUpdateDTO;
import com.geshanzsq.blog.admin.blog.article.po.BlogArticle;
import com.geshanzsq.blog.admin.blog.article.vo.BlogArticleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 文章对象转换
 *
 * @author geshanzsq
 * @date 2022/8/18
 */
@Mapper
public interface BlogArticleConverter {

    BlogArticleConverter INSTANCE = Mappers.getMapper(BlogArticleConverter.class);

    BlogArticleVO convert(BlogArticle blogArticle);

    BlogArticle convert(BlogArticleSaveDTO saveDTO);

    BlogArticle convert(BlogArticleUpdateDTO updateDTO);

}
