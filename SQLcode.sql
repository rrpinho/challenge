CREATE TABLE cliente (
  intIdCliente INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  vcNome VARCHAR(45) NULL,
  vcSobrenome VARCHAR(45) NULL,
  dtNascimento DATE NULL,
  vcTelefone VARCHAR(45) NULL,
  vcEmail VARCHAR(45) NULL,
  vcCPF VARCHAR(45) NULL,
  dtCadastro TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE INDEX vcCPF_UNIQUE,
  UNIQUE INDEX vcEmail_UNIQUE,
  UNIQUE INDEX vcTelefone_UNIQUE
)

CREATE TABLE produto (
  intIdProduto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  vcCategoria VARCHAR(45) NULL
)

CREATE TABLE endereço (
  intIdEndereço INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  vcPais VARCHAR(45) NULL,
  vcEstado VARCHAR(45) NULL,
  vcCidade VARCHAR(45) NULL,
  vcBairro VARCHAR(45) NULL,
  vcRua VARCHAR(45) NULL,
  vcComplemento VARCHAR(45) NULL,
  intNumero INT NULL,
  intCEP INT NULL,
  intIdCliente INT NOT NULL,
  CONSTRAINT fk_endereço_cliente FOREIGN KEY (intIdCliente) REFERENCES cliente (intIdCliente)
)

CREATE TABLE carrinho (
  intIdCarrinho INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dcValorTotal DECIMAL NULL,
  intIdCliente INT NOT NULL,
  CONSTRAINT fk_carrinho_cliente FOREIGN KEY (intIdCliente) REFERENCES cliente (intIdCliente)
)

CREATE TABLE pedido (
  intIdPedido INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dtPedido DATE NULL,
  dtEntrega DATE NULL,
  dcValorPago VARCHAR(45) NULL,
  intIdEndereço INT NOT NULL,
  intIdCarrinho INT NOT NULL,
  CONSTRAINT fk_pedido_endereço FOREIGN KEY (intIdEndereço) REFERENCES endereço (intIdEndereço),
  CONSTRAINT fk_pedido_carrinho FOREIGN KEY (intIdCarrinho) REFERENCES carrinho (intIdCarrinho)
)

CREATE TABLE pedido_produto (
  intIdPedidoProduto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dcPreçoUnitario DECIMAL NULL,
  intQuantidade INT NULL,
  intIdPedido INT NOT NULL,
  intIdProduto INT NOT NULL,
  CONSTRAINT fk_pedido_produto_pedido FOREIGN KEY (intIdPedido) REFERENCES pedido (intIdPedido),
  CONSTRAINT fk_pedido_produto_produto FOREIGN KEY (intIdProduto) REFERENCES produto (intIdProduto)
)

CREATE TABLE carrinho_produto (
  intIdCarrinhoProduto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  dcPreçoUnitario DECIMAL NULL,
  intQuantidade INT NULL,
  intIdCarrinho INT NOT NULL,
  intIdProduto INT NOT NULL,
  CONSTRAINT fk_carrinho_produto_carrinho FOREIGN KEY (intIdCarrinho) REFERENCES ecommerce.carrinho (intIdCarrinho),
  CONSTRAINT fk_carrinho_produto_produto FOREIGN KEY (intIdProduto) REFERENCES produto (intIdProduto)
)

CREATE TABLE sku (
  intIdSku INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  vcNome VARCHAR(45) NULL,
  dcPreço DECIMAL NULL,
  intEstoque INT NULL,
  intIdProduto INT NOT NULL,
  CONSTRAINT fk_sku_produto FOREIGN KEY (intIdProduto) REFERENCES produto (intIdProduto)
)