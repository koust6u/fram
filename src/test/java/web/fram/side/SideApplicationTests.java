package web.fram.side;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SideApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertThatCode(() -> SideApplication.main(new String[]{}))
                .doesNotThrowAnyException();
    }
}
