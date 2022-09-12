package com.geshanzsq.blog.system.dictionary.service.impl;

import com.geshanzsq.blog.common.framework.mybatis.page.vo.PageVO;
import com.geshanzsq.blog.common.framework.web.service.impl.BaseServiceImpl;
import com.geshanzsq.blog.system.dictionary.dto.SysDictionaryDataPageDTO;
import com.geshanzsq.blog.system.dictionary.mapper.SysDictionaryDataMapper;
import com.geshanzsq.blog.system.dictionary.mapstruct.SysDictionaryDataConverter;
import com.geshanzsq.blog.system.dictionary.po.SysDictionaryData;
import com.geshanzsq.blog.system.dictionary.service.SysDictionaryDataService;
import com.geshanzsq.blog.system.dictionary.vo.SysDictionaryDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 字典数据
 *
 * @author geshanzsq
 * @date 2022/6/27
 */
@Service
public class SysDictionaryDataServiceImpl extends BaseServiceImpl<SysDictionaryDataMapper, SysDictionaryData> implements SysDictionaryDataService {

    @Autowired
    private SysDictionaryDataMapper sysDictionaryDataMapper;

    /**
     * 分页列表
     */
    @Override
    public PageVO<SysDictionaryDataVO> pageList(SysDictionaryDataPageDTO pageDTO) {
        PageVO<SysDictionaryData> page = sysDictionaryDataMapper.selectPage(pageDTO);
        return SysDictionaryDataConverter.INSTANCE.convert(page);
    }

    /**
     * 获取最大排序
     * @param dictionaryId 字典 id
     */
    @Override
    public Integer getMaxSortByDictionaryId(Long dictionaryId) {
        return sysDictionaryDataMapper.getMaxSortByDictionaryId(dictionaryId);
    }
}
