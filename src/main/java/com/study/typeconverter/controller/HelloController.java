package com.study.typeconverter.controller;

import com.study.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); //문자 타입 조회
        Integer integer = Integer.valueOf(data);//숫자 타입 변경
        System.out.println("integer = " + integer);
        return "v1 ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "v2 ok";
    }

    /**
     * @RequestParam 은 @RequestParam 을 처리하는 ArgumentResolver 인 RequestParamMethodArgumentResolver
     * 에서 ConversionService 를 통해 타입을 변환한다. 부모 클래스와 다양한 외부 클래스를 호출하는 등 복잡한 내부 과정을 거치기 때문에
     * 대략 이렇게 처리되는것으로 이해해도 좋다.
     * IpPortConverter 에 디버그 걸어서 확인해 보자
     */
    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort IP= " + ipPort.getIp());
        System.out.println("ipPort PORT= " + ipPort.getPort());
        return "ipPort OK";
    }
}
