import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Study {

    // String 클래스에 대한 학습 테스트 START
    @Test
    void 요구사항1() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");

    }

    @Test
    void 요구사항2() {
        String str = "(1,2)";
        str = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        assertThat(str).isEqualTo("1,2");
    }

    @DisplayName("문자열의 특정 위치를 가져온다. 값을 벗어날 시 StringOutOfBoundsException 발생")
    @Test
    void 요구사항3() {
        Assertions.assertThatThrownBy(() -> {
            String abc = "abc";
            abc.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
    // String 클래스에 대한 학습 테스트 END


    // set Collection에 대한 학습 테스터 START
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void 요구사항_1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 요구사항_2(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 요구사항_3(int input, boolean bol) {
        assertThat(numbers.contains(input)).isEqualTo(bol);
    }
    // set Collection에 대한 학습 테스터 END
}
