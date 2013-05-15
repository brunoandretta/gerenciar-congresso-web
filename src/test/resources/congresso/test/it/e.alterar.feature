Feature: Página de Alteração de Dados Cadastrais   
    Altera Dados Cadastrais    

  Scenario: Altera Dados Cadastrais
    When Eu navego para a página "/acesso.xhtml"
    And Eu preencho "cpf" com "08539403986"
    And Eu preencho "email" com "brunogandrettam@gmail.com"
    And Eu clico no botao "acessar"
    And Eu preencho "telefone" com "04184134522"    
    Then Eu poderia ver "Formulário"