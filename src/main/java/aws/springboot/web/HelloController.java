package aws.springboot.web;

import aws.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
public class HelloController {
    @GetMapping("/hello") // /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가진게 되었다. (ex localhost:8080/hello)
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, // 외부에서 API로 넘긴 파라미터를 가져온다.
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }

}

