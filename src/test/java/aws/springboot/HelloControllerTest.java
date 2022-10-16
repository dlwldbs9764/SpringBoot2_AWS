package aws.springboot;


import aws.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // SpringRunner라는 스프링 실행자를 사용합니다.
@WebMvcTest(controllers = HelloController.class) // 선언할 경우 @Controller, @ControllerAdvice
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입 받습니다.
    private MockMvc mvc; // 웹 API를 테스트할 때 사용하고, 스프링 MVC 테스트의 시작점입니다.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 합니다.
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증합니다. HTTP Header의 Status를 검증(200,400,500)
                .andExpect(content().string(hello)); // Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증합니다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name= "hello";
        int amount=1000;

        mvc.perform(get("/hello/dto")
                .param("name",name) // API 테스트할 때 사용될 요청 파라미터를 설정한다. (String값만 허용됨)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name",is(name))) // JSON 응답값을 필드별로 검증할 수 있는 메소드다.
                .andExpect((ResultMatcher) jsonPath("$.amount",is(amount))); // $를 기준으로 필드명 명시 -> $.name, $.amount
    }
}
