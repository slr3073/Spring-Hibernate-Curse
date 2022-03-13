package doremi;

import doremi.services.ArticleService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArticleService articleService;

    @Test
    public void testGetActivites() throws Exception{
        // given: un objet MockMvc qui simulate des échanges MVC
        // when: on simule du requête HTTP de type GET vers "/articles"
        // then: la requête est acceptée (status OK) et la vue "articles" est rendue
        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("articles"))
                .andExpect(content().string(Matchers.containsString("<h2>Liste des Articles</h2>")))
                .andExpect(content().string(Matchers.containsString(articleService.findAllArticles().get(0).getTitle())))
                .andDo(print());
    }


}

