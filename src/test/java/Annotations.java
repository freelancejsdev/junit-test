import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Annotations
{
    @BeforeAll
    public static void setUp()
    {
        System.out.println("executed before all the tests");
    }

   @BeforeEach
    public void beforeEach()
    {
        System.out.println("executed before each test");
    }

    @AfterEach
    public void afterEach()
    {
        System.out.println("executed after each test");
    }
    @Test
    @Order(1)
   public void register()
   {
       System.out.println("Register new user");
   }
    @Test
    @Order(2)
    public void login()
    {
        System.out.println("Login with registered user");
    }

    @Test
    @Order(3)
    public void logout()
    {
        System.out.println("Logout");
    }

    @AfterAll
    public static void tearDown()
    {
        System.out.println("executed after all the tests");
    }
}
