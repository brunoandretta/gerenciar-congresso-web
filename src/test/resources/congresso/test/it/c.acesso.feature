Feature: Página de Acesso do Participante    
    Verificar se dados estão incorretos    
    Acessar Consulta Dados
    Acessar Alterar Dados

  Scenario: Verificar se dados estão incorretos
    When Eu navego para a página "/acesso.xhtml"
    And Eu preencho "cpf" com "68641856056"
    And Eu preencho "email" com "teste@gmail.com"
    And Eu clico no botao "acessar"
    Then Eu poderia ver "cpf e/ou e-mail incorretos!"

  Scenario: Acessar Consultar Dados
    When Eu navego para a página "/acesso.xhtml?operacao=consultar"
    And Eu preencho "cpf" com "08539403986"
    And Eu preencho "email" com "brunogandrettam@gmail.com"
    And Eu clico no botao "acessar"
    Then Eu poderia ver "Consultar"

  Scenario: Acessar Alterar Dados
    When Eu navego para a página "/acesso.xhtml?operacao=alterar"
    And Eu preencho "cpf" com "08539403986"
    And Eu preencho "email" com "brunogandrettam@gmail.com"
    And Eu clico no botao "acessar"
    Then Eu poderia ver "Formulário"