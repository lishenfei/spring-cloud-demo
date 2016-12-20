package com.lsf.demo.spring.cloud.ui.service;

import com.lsf.demo.spring.cloud.ui.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 调用 Person Service 的断路器
 */
@Service
public class PersonHystrixService {

    @Autowired
    PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave") //1 本方法调用失败时，调用后备方法fallbackSave
    public List<Person> save(String name) {
        return personService.save(name);
    }

    public List<Person> fallbackSave(String name) {
        List<Person> list = new ArrayList<>();
        Person p = new Person(name + "没有保存成功，Person Service 故障");
        list.add(p);
        return list;
    }
}
