package com.pmb.general.web.controller;

import com.pmb.general.common.interfaces.core.MockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lvrui
 */
@RestController
public class MockController {
    @Resource
    private MockService mockService;

    @RequestMapping("/mock")
    public String mock() {
        mockService.mock();
        return "mock";
    }
}
