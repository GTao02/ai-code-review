package com.tao.trigger.http;

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
    }

}
