package test_work;

import org.junit.Assert;
import org.junit.Test;

public class BracketsTest {
	@Test(expected = NullPointerException.class)
    public void testNull() {
        Brackets.checkBrackets(null);
    }

    @Test
    public void testAbsent() {
        Assert.assertTrue(Brackets.checkBrackets(""));
        Assert.assertTrue(Brackets.checkBrackets("foo"));
    }

    @Test
    public void testCorrect() {
        Assert.assertTrue(Brackets.checkBrackets("(foo)"));
        Assert.assertTrue(Brackets.checkBrackets("(foo[bar])"));
        Assert.assertTrue(Brackets.checkBrackets("(foo[bar]){foobar}"));
    }

    @Test
    public void testUnclosed() {
        Assert.assertFalse(Brackets.checkBrackets("(foo"));
        Assert.assertFalse(Brackets.checkBrackets("foo)"));
        Assert.assertFalse(Brackets.checkBrackets("(foo[bar]"));
    }

    @Test
    public void testUnpaired() {
        Assert.assertFalse(Brackets.checkBrackets("(foo}"));
        Assert.assertFalse(Brackets.checkBrackets("(foo[bar})"));
    }

}
