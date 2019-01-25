package com.xinre.base.controller;

import com.xinre.base.pojo.Label;
import com.xinre.base.service.LabelService;
import com.xinre.common.entity.Result;
import com.xinre.common.entity.StatusCode;
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

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(StatusCode.OK, true, "方法 save 成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable(name = "id") String labelId) {
        labelService.deleteById(labelId);
        return new Result(StatusCode.OK, true, "方法 deleteById 成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result updateById(@PathVariable(name = "id") String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(StatusCode.OK, true, "方法 updateById 成功！");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(StatusCode.OK, true, "方法 findAll 成功！", labelService.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String labelId) {
        return new Result(StatusCode.OK, true, "方法 findById 成功！", labelService.findById(labelId));
    }


}
