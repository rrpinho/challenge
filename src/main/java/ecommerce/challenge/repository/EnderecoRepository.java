package ecommerce.challenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ecommerce.challenge.model.Cliente;
import ecommerce.challenge.model.Endereco;

@Repository
public class EnderecoRepository{
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer getIdClienteComEmail(String email) {
        String query = "SELECT intIdCliente FROM cliente WHERE vcEmail = \""+email+"\";";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public void setEndereco(int id, Endereco endereco){
        String query = "INSERT endereco (intIdCliente, vcEstado, vcCidade, vcBairro, vcRua, vcComplemento, vcCEP) VALUES ("+id+", \""+endereco.getEstado()+"\", \""+endereco.getCidade()+"\", \""+endereco.getBairro()+"\", \""+endereco.getRua()+"\", \""+endereco.getComplemento()+"\", \""+endereco.getCep()+"\");";
        jdbcTemplate.execute(query);
    }
    
}
