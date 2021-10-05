import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Study {

    @Test
    void 요구사항1() {
        Assertions.assertThat("1,2").contains("1,2".split(","));
        //Assertions.assertThat("1.2").("1,2".split(","));

    }
}
