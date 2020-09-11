package org.gfarm.resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.gfarm.dto.request.GfComradeDto;
import org.gfarm.dto.request.GfTestDto;
import org.gfarm.service.GfComradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/fuji/comrade")
@Validated
public class GfComradeResource {

    @Resource
    private GfComradeService gfComradeService;

    @RequestMapping(value = "/add", name = "战友信息-插入记录", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_MEDIUM')")
    public ResponseEntity<String> add(@RequestBody GfComradeDto gfComradeDto) {

        int insert = gfComradeService.add(gfComradeDto);

        return ResponseEntity.ok("插入成功");
    }

    @RequestMapping(value = "/list", name = "战友信息-条件查询", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    public ResponseEntity<IPage<GfComradeDto>> list(@RequestBody GfComradeDto gfComradeDto, Integer pageNum, Integer pageSize) {

        IPage<GfComradeDto> gfComradeDtoIPage = gfComradeService.pageList(gfComradeDto, pageNum, pageSize);

        return ResponseEntity.ok(gfComradeDtoIPage);
    }

    @RequestMapping(value = "/delete", name = "战友信息-删除", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody List<Integer> ids) {

        int i = gfComradeService.deleteByIds(ids);

        return ResponseEntity.ok("删除成功");
    }

    @RequestMapping(value = "/update", name = "战友信息-更新", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> update(@RequestBody GfComradeDto gfComradeDto) {

        int i = gfComradeService.updateByPrimaryKey(gfComradeDto);

        return ResponseEntity.ok("更新成功");
    }

}
