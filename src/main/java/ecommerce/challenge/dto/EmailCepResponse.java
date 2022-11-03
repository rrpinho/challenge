package ecommerce.challenge.dto;

public class EmailCepResponse {
    private String Email;
    private String cep;

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
