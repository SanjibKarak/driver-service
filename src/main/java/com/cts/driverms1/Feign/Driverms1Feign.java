package com.cts.driverms1.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.cts.driverms1.Entity.JwtResponse;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="authorization-service",url="http://localhost:8084")

public interface Driverms1Feign {
    @GetMapping("/api/auth/validate")
    public JwtResponse verifyToken(@RequestHeader(name="authorization",required=true) String token);
}
