package com.tao.trigger.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/git")
public class GitEventController {

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public void event(@RequestBody String event) {
        System.out.println("event:" + event);
        JSONObject jsonObject = JSON.parseObject(event);
        String before = (String) jsonObject.get("before");
        String after = (String) jsonObject.get("after");
        System.out.println("before:" + before + "\nafter:" + after);
    }
}
