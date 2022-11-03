# challenge
eCommerce

Segue projeto do desafio do eCommerce

Na pasta principal contém o Schema do banco, assim como seu código SQL.
E também possui uma imagem do modelo do Banco em Word, como foi pedido, mas para uma melhor visualização adicionei em PDF e Jpeg também.

Ainda na pasta principal contém o collection do Postman. Um arquivo .json.
Mas ainda assim uma explicação rápida da API:

A atividade foi feita utilizando o serviço de CEP da viacep.com.br

http://localhost:8080/getCep/41830001
Resolve a atividade 1. Usei o metodo Get apenas pra demonstrar domínio deste método.

http://localhost:8080/cep
body 
{
    "email":"teste@teste.com",
    "cep":"41830001"
}
Resolve a atividade 2. Usando o método POST. Coloquei o conteúdo que deve ser posto no body desta request.

http://localhost:8080/email
body
{
    "email":"teste@teste.com",
}
Resolve a atividade 3

OBS.: Para testar as atividades 2 e 3. Será necessário já ter um cliente cadastrado no banco.
OBS.2: Lembrar de atualizar a rota, o nome do banco e o login/senha para o banco em sua máquina.