//package org.example.apigateway.FeignClient;
//
//
//import org.example.apigateway.dto.JwtAuthenticationDto;
//import org.example.apigateway.dto.UserAccountCredentialsDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(
//        value = "authentication-users",
//        url = "http://LOCALHOST:8080/authentication-users/auth/"
//)
//public interface AuthFeignClient {
//
//
//    @PostMapping("/sing_in")
//    public ResponseEntity<JwtAuthenticationDto> singIn(@RequestBody UserAccountCredentialsDto userAccountCredentialsDto);
//}
