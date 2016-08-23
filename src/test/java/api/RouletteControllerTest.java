package api;

import com.skybet.api.RouletteController;
import com.skybet.service.IRouletteService;
import com.skybet.service.model.BetResult;
import com.skybet.service.model.SingleBet;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Test(groups = {"integration"})
public class RouletteControllerTest
{
    @Mock
    private IRouletteService rouletteService;

    @InjectMocks
    private RouletteController rouletteController;

    private MockMvc mockMvc;

    @BeforeMethod
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(rouletteController).build();
    }

    @Test
    public void handleSingleBet() throws Exception
    {
        when(rouletteService.handleSingleBet(any(SingleBet.class)))
                .thenReturn(new BetResult(true));

        this.mockMvc.perform(get("/bet/single")
                .param("number", "15"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string("{\"winner\":" + true + "}"));

    }
}
