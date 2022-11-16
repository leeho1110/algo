package ps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppendAndDeleteTest {

    @Test
    public void test() {
        // given
        AppendAndDelete sut = new AppendAndDelete("zzzzz", "zzzzzzz", 4);

        // when
        String result = sut.check();

        // then
        assertEquals(result, "Yes");
    }

    @Test
    public void test2() {
        // given
        AppendAndDelete sut = new AppendAndDelete("qwerasdf", "qwerbsdf", 6);

        // when
        String result = sut.check();

        // then
        assertEquals(result, "No");
    }

    @Test
    public void test3() {
        // given
        AppendAndDelete sut = new AppendAndDelete(
                "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv",
                "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv", 20);

        // when
        String result = sut.check();

        // then
        assertEquals(result, "Yes");
    }

    @Test
    public void test4() {
        // given
        AppendAndDelete sut = new AppendAndDelete(
                "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv",
                "bsdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv", 100);

        // when
        String result = sut.check();

        // then
        assertEquals(result, "No");
    }
    
}