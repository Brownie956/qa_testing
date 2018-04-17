package ui.tests;

import org.junit.jupiter.api.*;
import ui.helpers.page_objects.WikiHomePage;
import ui.helpers.users.WikiHomeUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WikiHomeTest implements BaseTest {

    private WikiHomeUser user;

    @BeforeAll
    public void setUp() {
        this.user = new WikiHomeUser();
    }

    @AfterAll
    public void tearDown(){
        user.tearDown();
    }

    @BeforeEach
    void before() {
        user.navigate_to(WikiHomePage.URL);
    }

    @Test
    void test_home_page_loads_correctly() {
        user.navigate_to(WikiHomePage.URL);
        assertEquals("Wikipedia, the free encyclopedia", user.views_page_title());
    }

    @Test
    void test_home_page_contents_link() {
        user.navigate_to(WikiHomePage.URL);
        user.clicks_wiki_home_menu_contents();
        assertEquals("Portal:Contents - Wikipedia", user.views_page_title());
    }
}
