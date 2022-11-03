package ecommerce.challenge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ecommerce.challenge.model.Endereco;

@Repository
public class EnderecoRepository{
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer getIdClienteComEmail(String email) {
        String query = "SELECT intIdCliente FROM cliente WHERE vcEmail = \""+email+"\";";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public void setEnderecoComEmail(int id, Endereco endereco){
        String query = "INSERT endereco (intIdCliente, vcEstado, vcCidade, vcBairro, vcRua, vcComplemento, vcCEP) VALUES ("+id+", \""+endereco.getEstado()+"\", \""+endereco.getCidade()+"\", \""+endereco.getBairro()+"\", \""+endereco.getRua()+"\", \""+endereco.getComplemento()+"\", \""+endereco.getCep()+"\");";
        jdbcTemplate.execute(query);
    }

    public List<Endereco> getClienteEnderecos(int id){
        String query = "SELECT * FROM endereco WHERE intIdCliente = "+id+";";
        
        List<Endereco> enderecos = new ArrayList<>();
        List<Map<String, Object>> linhas = jdbcTemplate.queryForList(query);

        for (Map linha : linhas) {
            Endereco endereco = new Endereco();
            endereco.setBairro((String) linha.get("vcBairro"));
            endereco.setCep((String) linha.get("vcCEP"));
            endereco.setCidade((String) linha.get("vcCidade"));
            endereco.setComplemento((String) linha.get("vcComplemento"));
            endereco.setEstado((String) linha.get("vcEstado"));
            endereco.setRua((String) linha.get("vcRua"));

            enderecos.add(endereco);
        }
        return enderecos;
    }
    
}
