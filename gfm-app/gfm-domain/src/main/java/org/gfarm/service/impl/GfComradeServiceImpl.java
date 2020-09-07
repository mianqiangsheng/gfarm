package org.gfarm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.gfarm.dto.request.GfComradeDto;
import org.gfarm.entity.GfComrade;
import org.gfarm.mapper.GfComradeMapper;
import org.gfarm.service.GfComradeService;
import org.gfarm.util.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GfComradeServiceImpl implements GfComradeService {

    @Resource
    private GfComradeMapper gfComradeMapper;

    @Override
    public int add(GfComradeDto gfComradeDto) {
        GfComrade gfComrade = new GfComrade();
        BeanUtils.copyPropertiesIgnoreNull(gfComradeDto,gfComrade);
        int i = gfComradeMapper.insert(gfComrade);
        return i;
    }

    @Override
    public IPage<GfComradeDto> pageList(GfComradeDto gfComradeDto, Integer pageNum, Integer pageSize) {

        IPage<GfComrade> page = new Page<>(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
        LambdaQueryWrapper<GfComrade> queryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(gfComradeDto.getMemberId()))
            queryWrapper.like(GfComrade::getMemberId,gfComradeDto.getMemberId());
        if (StringUtils.isNotBlank(gfComradeDto.getDiscordName()))
            queryWrapper.like(GfComrade::getDiscordName,gfComradeDto.getDiscordName());
        if (gfComradeDto.getParade() != null)
            queryWrapper.eq(GfComrade::getParade,gfComradeDto.getParade());
        if (gfComradeDto.getDrinkTea() != null)
            queryWrapper.eq(GfComrade::getDrinkTea,gfComradeDto.getDrinkTea());

        IPage<GfComrade> gfComradeIPage = gfComradeMapper.selectPage(page, queryWrapper);

        IPage<GfComradeDto> gfComradeDtoIPage = gfComradeIPage.convert(GfComrade -> {
            GfComradeDto gfComradeDto1 = new GfComradeDto();
            BeanUtils.copyPropertiesIgnoreNull(GfComrade, gfComradeDto1);
            return gfComradeDto1;
        });

        return gfComradeDtoIPage;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        int i = gfComradeMapper.deleteBatchIds(ids);
        return i;
    }

    @Override
    public int updateByPrimaryKey(GfComradeDto gfComradeDto) {
        GfComrade gfComrade = new GfComrade();
        BeanUtils.copyPropertiesIgnoreNull(gfComradeDto,gfComrade);
        int i = gfComradeMapper.updateByPrimaryKey(gfComrade);
        return i;
    }
}
