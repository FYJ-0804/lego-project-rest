package com.successchannel.lego.legoprojectrest.controller;

import com.bizcloud.ipaas158492779303185286.auth.extension.AuthConfig;
import com.bizcloud.ipaas158492779303185286.codegen.ApiTestApi;
import com.bizcloud.ipaas158492779303185286.model.APITestDTO1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author Fangyanjie
 * @Date 2020-02-17-22:16
 */
@RestController
public class HelloFunction {

    @RequestMapping(value = "/find")
    public List<APITestDTO1> find(@RequestParam(value = "name"
            , defaultValue = "测试"
            , required = false) String name
    ) {
        init();
        ApiTestApi apiTestApi = new ApiTestApi();

        APITestDTO1 apiTestDTO1 = new APITestDTO1();
        apiTestDTO1.setName(name);

        String msg = apiTestApi.findAPITestUsingPOST(apiTestDTO1).getMessage();
        System.out.println(msg);

        List<APITestDTO1> apiTestDTOs = apiTestApi.findAPITestUsingPOST(apiTestDTO1).getData();
        for (Object o : apiTestDTOs) {
            System.out.println(o);
        }

        return apiTestDTOs;
    }

    private void init() {
        AuthConfig authConfig = new AuthConfig("zGp1JtwgTsRTfCby", "esteMjPwV7EWQwWmbRnPyjnykzDJ4I");
        authConfig.initAuth();
    }

}
