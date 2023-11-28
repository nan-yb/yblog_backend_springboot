package com.yblog.sample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "SomeTest", description = "SwaggerTest")
@RestController
public class SomeTestController {
    @Operation(summary = "SwaggerTest API", description = "Swagger 적용 테스트")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "success", description = "성공"),
            @ApiResponse(responseCode = "fail")})
    @GetMapping(path="/swagger")
    public String someAPI(){
        return "Swagger test입니다.";
    }
}