package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {
    @Autowired
    MessageSource ms;

    @Test
    void helloMessage() {
        String result = ms.getMessage("hello", null, null);
        assertThat(result).isEqualTo("hello");
    }

    @Test
    void helloMessage2() {
        String result = ms.getMessage("no", null, "default",null);
        assertThat(result).isEqualTo("default");
    }

    @Test
    void notFoundMessageCode() {
        assertThatThrownBy(()-> ms.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    void argumentMessage() {
        String message = ms.getMessage("hello.name", new Object[]{"SPRING"}, null);
        assertThat(message).isEqualTo("hello SPRING");
    }

    @Test
    void defaultLang() {
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("hello");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("hello");
    }
}
