package aws.springboot.dto;

import aws.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto= new HelloResponseDto(name,amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // assertj(Junit의)라는 테스트 검증 라이브러리의 검증 메소드이다.
        assertThat(dto.getAmount()).isEqualTo(amount); // 검증하고 싶은 대상을 메소드 인자로 받는다.
    }
}
