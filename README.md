# Projeto Petshop

## Descrição

Este projeto é uma aplicação simples para ajudar o Sr. Eduardo dono do canil a encontrar o melhor petshop com base na data e na quantidade de cães pequenos e grandes para banho, considerando preço e distância.

## Como executar o sistema

### Rodando pelo GitHub Pages

- Basta acessar o link do GitHub Pages. -> https://erickdev00.github.io/petshopCase
- A API já está hospedada no Koyeb e configurada para ser acessada pelo frontend.

### Rodando localmente

1. Entre na pasta do frontend.
2. Instale as dependências (se ainda não instalou) com `npm install`.
3. Execute o servidor de desenvolvimento com `npm run dev`.
4. O frontend estará disponível na porta local e fará requisições para a API hospedada no Koyeb.

**Observação:**  
O backend não precisa ser executado localmente, pois está hospedado na plataforma Koyeb e o frontend já consome essa API pública.
Caso queira executar o backend localmente, será necessário alterar a URL da API no frontend.

## Tecnologias Utilizadas

- **Frontend:**

  - React.js com Vite
  - JavaScript (ES6+)
  - Tailwind CSS

- **Backend:**

  - Java 17
  - Spring Boot
  - Maven

- **Ferramentas:**
  - Git e GitHub
  - Koyeb (hospedagem do backend)
  - VS Code
  - IntelliJ

## Premissas assumidas

- O usuário informará uma data atual ou futura para realizar a busca.
- A quantidade mínima de cães (pequenos + grandes) para a busca é 1, não é aceito número negativos ou decimais.
- A lista de petshops é fixa no serviço.
- O frontend e backend são separados e se comunicam via API REST.

## Decisões de projeto

- Usei React com Vite para manter o frontend simples e rápido.
- Backend em Spring Boot com código direto e simples, visando clareza.
- Utilização de DTO para separar os dados recebidos no backend, evitando expor o model diretamente.
- Validação básica no frontend para evitar envios inválidos.
- API hospedada externamente para facilitar testes sem precisar rodar backend local.
- Estruturei o projeto como um monorepo, com frontend e backend em pastas separadas, facilitando o desenvolvimento e organização.

## Informações adicionais

- Configurei o frontend para aceitar só datas atuais ou futuras na seleção.
- O backend retorna o petshop com o menor preço, desempate pela distância.
- Mantive o código o mais simples possível para facilitar a manutenção.
- A comunicação entre frontend e backend utiliza JSON para troca de dados.
- Implementei testes unitários básicos no backend para validar a lógica do service e o correto funcionamento dos endpoints no controller.

---

## Contato

Em caso de dúvidas e sugestões entre em contato.

---

Obrigado por avaliar meu projeto!
