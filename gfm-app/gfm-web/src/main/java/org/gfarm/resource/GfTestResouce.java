package org.gfarm.resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.gfarm.dto.request.GfTestDto;
import org.gfarm.service.GfTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/fuji")
@Validated
public class GfTestResouce {

    @Resource
    private GfTestService gfTestService;

    @RequestMapping(value = "/test/add", name = "样例方法-插入记录", method = RequestMethod.POST)
    public ResponseEntity<String> insert(@RequestBody GfTestDto gfTestDto) {

        int insert = gfTestService.insert(gfTestDto);

        return ResponseEntity.ok("插入成功");
    }

    @RequestMapping(value = "/test/list", name = "样例方法-条件查询", method = RequestMethod.POST)
    public ResponseEntity<IPage<GfTestDto>> list(@RequestBody GfTestDto gfTestDto, Integer pageNum, Integer pageSize) {

        IPage<GfTestDto> gfTestDtoIPage = gfTestService.pageList(gfTestDto, pageNum, pageSize);

        return ResponseEntity.ok(gfTestDtoIPage);
    }

    @RequestMapping(value = "/test/get", name = "样例方法-条件查询", method = RequestMethod.GET)
    public ResponseEntity<String> get() {

        return ResponseEntity.ok("success");
    }

    @RequestMapping(value = "/picture/get", name = "样例方法-条件查询", method = RequestMethod.GET)
    public ResponseEntity<Integer> get(Integer integer) {

        return ResponseEntity.ok(integer);
    }

}
