package ecommerce.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import ecommerce.challenge.dto.EmailCepResponse;
import ecommerce.challenge.dto.EmailResponse;
import ecommerce.challenge.dto.EnderecoResponse;
import ecommerce.challenge.model.Endereco;
import ecommerce.challenge.repository.EnderecoRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/getCep/{cep}")
    public Endereco getCep(@PathVariable("cep") String cep) throws Exception {
            
        URL url = new URL("http://viacep.com.br/ws/"+cep+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        
        String enderecoAux = "";
        StringBuilder jsonCep = new StringBuilder();
        while ((enderecoAux = br.readLine()) != null) {
            jsonCep.append(enderecoAux);
        }

        ObjectMapper mapper = new ObjectMapper();
        EnderecoResponse enderecoDto = mapper.readValue(jsonCep.toString(), EnderecoResponse.class);

        Endereco endereco = enderecoDto.converter();

        return endereco;
    }

    @PostMapping("/cep")
    public void setEnderecoComEmail(@RequestBody EmailCepResponse emailCepResponse) throws Exception{

        enderecoRepository.setEnderecoComEmail(enderecoRepository.getIdClienteComEmail(emailCepResponse.getEmail()), getCep(emailCepResponse.getCep()));

    }

    @PostMapping("/email")
    public List<Endereco> getClienteEnderecos(@RequestBody EmailResponse emailResponse) throws Exception {
        
        String email = emailResponse.getEmail();

        int id = enderecoRepository.getIdClienteComEmail(email);
        
        List<Endereco> enderecos = enderecoRepository.getClienteEnderecos(id);

        return enderecos;
    }
}
