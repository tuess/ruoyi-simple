package com.huaxin.project.system.controller;

import com.huaxin.common.utils.StringUtils;
import com.huaxin.framework.security.RegisterBody;
import com.huaxin.framework.security.service.SysRegisterService;
import com.huaxin.framework.web.controller.BaseController;
import com.huaxin.framework.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册验证
 *
 * @author ruoyi
 */
@RestController
public class SysRegisterController extends BaseController {

    // 注册是否开启
    @Value("${ruoyi.registerEnable}")
    private Boolean registerEnable;

    @Autowired
    private SysRegisterService registerService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user) {
        if (!registerEnable) {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
