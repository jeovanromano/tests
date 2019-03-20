/**
 * 
 */
package br.com.bb.bonus.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.bb.Application;
import br.com.bb.bonus.matchers.MyMatchers;

/**
 * @author Jeovan Romano
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BonusTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
    public void listByCategoryAlimentosMyMatcher() throws Exception {
        mockMvc.perform(get("/product/listByCategory/1"))
        .andExpect(status().isOk())
    		.andExpect(jsonPath("$", hasSize(2)))
	        .andExpect(jsonPath("$[0].id", MyMatchers.myIsInt(1)))
	        .andExpect(jsonPath("$[0].name", MyMatchers.myIsString("Arroz")))
	        .andExpect(jsonPath("$[1].id",  MyMatchers.myIsInt(2)))
	        .andExpect(jsonPath("$[1].name", MyMatchers.myIsString("Feijão")));
    }
	
	@Test
    public void findByLetterCategoryMedicamento() throws Exception {
        mockMvc.perform(get("/category/findByLetter/e"))
        	.andExpect(status().isOk())
	        .andExpect(jsonPath("$.id", is(5)))
	        .andExpect(jsonPath("$.name", is("Medicamentos")));
    }
	
	
}
