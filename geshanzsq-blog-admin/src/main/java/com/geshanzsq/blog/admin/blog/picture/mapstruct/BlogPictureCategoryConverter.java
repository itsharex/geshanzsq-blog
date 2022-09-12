package com.geshanzsq.blog.admin.blog.picture.mapstruct;

import com.geshanzsq.blog.admin.blog.picture.dto.BlogPictureCategoryAddDTO;
import com.geshanzsq.blog.admin.blog.picture.dto.BlogPictureCategoryUpdateDTO;
import com.geshanzsq.blog.admin.blog.picture.po.BlogPictureCategory;
import com.geshanzsq.blog.admin.blog.picture.vo.BlogPictureCategoryVO;
import com.geshanzsq.blog.common.framework.mybatis.page.vo.PageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 图片分类对象转换
 *
 * @author geshanzsq
 * @date 2022/8/24
 */
@Mapper
public interface BlogPictureCategoryConverter {

    BlogPictureCategoryConverter INSTANCE = Mappers.getMapper(BlogPictureCategoryConverter.class);

    PageVO<BlogPictureCategoryVO> convert(PageVO<BlogPictureCategory> pageVO);

    BlogPictureCategoryVO convert(BlogPictureCategory blogPictureCategory);

    BlogPictureCategory convert(BlogPictureCategoryAddDTO addDTO);

    BlogPictureCategory convert(BlogPictureCategoryUpdateDTO updateDTO);

}
