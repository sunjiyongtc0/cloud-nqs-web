package com.acsno.pdc.controller;

import com.acsno.pdc.util.IpAddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class t1 {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private HttpServletRequest request;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        String ipaddr=IpAddressUtils.getIpAddr(request);
        System.out.println(ipaddr);
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }
    @PostMapping(value = "/payment/post/nacos/{id}")
    public String getPaymentPost(@PathVariable("id") Integer id)
    {
        String ipaddr=IpAddressUtils.getIpAddr(request);
        System.out.println(ipaddr);
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }
}
