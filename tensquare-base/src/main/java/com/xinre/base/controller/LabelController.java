package com.xinre.base.controller;

import com.xinre.base.pojo.Label;
import com.xinre.base.service.LabelService;
import com.xinre.common.entity.Result;
import com.xinre.common.entity.StatusCode;
import com.xinre.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xinre
 * @date 2019/1/17 17:21
 */

@CrossOrigin
@Controller
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @Autowired
    private IdWorker idWorker;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(StatusCode.OK, true, "方法 findAll 成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String labelId) {
        return new Result(StatusCode.OK, true, "方法 findById 成功！", labelId);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        //Label label = new Label();
        //label.setId(String.valueOf(idWorker.nextId()));
        label.setCount(5L);
        label.setFans(95L);
        label.setName("java");
        label.setState("1");
        label.setRecommend("1");
        return new Result(StatusCode.OK, true, "方法 save 成功！", label);
    }



}
