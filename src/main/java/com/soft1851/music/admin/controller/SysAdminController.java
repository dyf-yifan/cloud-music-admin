package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.service.SysAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mq_xu
 * @since 2020-04-22
 */
@RestController
@RequestMapping("/sysAdmin")
@Slf4j
public class SysAdminController {
    @Resource
    private SysAdminService sysAdminService;

    /**
     * 登录
     *
     * @return String
     */
    @PostMapping("/login")
    public Map login(@RequestBody LoginDto loginDto) {
        Map<String, Object> map = new TreeMap<>();
        log.info(loginDto.toString());
//        boolean isLogin = sysAdminService.login(loginDto);
//        log.info(String.valueOf(isLogin));
//        if (isLogin) {
//            SysAdmin admin = sysAdminService.getAdmin(loginDto.getName());
//            String token = JwtTokenUtil.getToken(admin.getId(), "admin", new Date(System.currentTimeMillis() + 60L * 1000L));
//            map.put("admin", admin);
//            map.put("token", token);
//        } else {
//            map.put("msg", "登录失败");
//        }
        return map;
    }
}