//file:noinspection GroovyAssignabilityCheck
package api.dentiste.apidentiste.groovy

import api.dentiste.apidentiste.controller.ConsultationController
import api.dentiste.apidentiste.dto.ConsultationDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.coyote.Response
import org.json.JSON
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowire
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import spock.lang.Specification

@SpringBootTest
@AutoConfigureMockMvc
class ConsultationSpec extends Specification{

   ObjectMapper objectMapper = new ObjectMapper()

    @Autowired
    MockMvc mockMvc

   def "updateConsultation"(){
   given:" definition des variable "
   def url = "http://8081/localhost/api/consultation/updateconsultation"

   ConsultationDto consul = new ConsultationDto()
   consul.setDate(new Date())
   consul.setId(1L)
   def status = new Response();
   status.setStatus(200)

   def jsonRequest = objectMapper.writeValueAsString(consul)

   when:
   def result = mockMvc.perform(put(url)
           .contentType(MediaType.APPLICATION_JSON)
           .content(jsonRequest))
   then:
   result.andExpect(status.getStatus().is(200) as ResultMatcher)
   }



    def "Test de la mise à jour de la consultation"() {
        given:
        def consultationDto = new ConsultationDto(/* initialize your consultation dto here */)

        when:
        def result = mockMvc.perform(put("http://8081/localhost/api/consultation/updateconsultation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(consultationDto))
        )

        then:
        result.andExpect(status().isOk())
        // Ajoutez ici d'autres assertions en fonction de votre logique métier
    }
}
