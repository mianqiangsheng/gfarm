package org.gfarm.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OauthResource {

    @RequestMapping(value = "/get", name = "样例方法-条件查询", method = RequestMethod.GET)
    public ResponseEntity<String> oauth() {

        return ResponseEntity.ok("my.oauth");
    }
}
