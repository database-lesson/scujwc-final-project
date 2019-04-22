package com.lesson.database.finalproject.controller;

import com.lesson.database.finalproject.controller.base.BaseFinalProjectController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: database-lesson-final-project
 * @description: Hello
 * @author: Vaskka
 * @create: 2019/4/22 9:41 AM
 **/


@Api(description = "Hello")
@Controller
@RequestMapping(value = "/hello")
public class Hello extends BaseFinalProjectController{

    @ApiOperation(value = "获取生物知识点" ,  notes="指定分页获取生物知识点")
    @ResponseBody
    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }


}