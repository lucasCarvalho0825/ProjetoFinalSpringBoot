package compvb.projeto.pagametoserver.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eventos-ms")
public interface EventoClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/pagamento/{id}")
    void eventopagamento(@PathVariable Integer id);
}
