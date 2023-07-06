import org.junit.jupiter.api.*;

public class SimpleTests {
    @BeforeAll
    static void beforeClassSetup() {
        System.out.println("Preparing test class");
    }

    @BeforeEach
    void prepareTest() {
        System.out.println("@BeforeEach is calling prepareTest()");
    }

    @Test
    void testSimpleTest() {
        System.out.println("Test is running");
    }


    @Test
    void testSimpleTest2() {
        System.out.println("Test 2 is running");
    }

    @AfterEach
    void clearTestData() {
        System.out.println("Clearing up test data");
    }

    @AfterAll
    static void afterClassTearDown() {
        System.out.println("Tear down test class");
    }
}
