package com.lsf.demo.spring.cloud.ui.service;

import com.lsf.demo.spring.cloud.ui.domain.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 使用 Feign 调用 Person 服务
 */
@FeignClient("person")
public interface PersonService {

    /**
     * 使用 Feign，只需要在接口中声明方法接口调用 Person 服务的 REST 服务
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Person> save(@RequestBody String name);
}
