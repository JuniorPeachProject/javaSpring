package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @GetMapping("/hi-1")
    public String hiV1(HttpServletRequest request) {
        String data = request.getParameter("data");
        Integer number = Integer.valueOf(data);
        return "ok";
    }

    @GetMapping("/hi-2")
    public String hiV2(@RequestParam Integer data) {
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort = " + ipPort);
        return "ok";
    }
}
