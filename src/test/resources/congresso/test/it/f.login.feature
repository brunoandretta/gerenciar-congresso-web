Feature: Página de Login do Administrador    
    Verificar se dados estão incorretos    
    Acessar Administração de Participantes

  Scenario: Verificar se dados estão incorretos
    When Eu navego para a página "/login.xhtml"
    And Eu preencho "usuario" com "teste"
    And Eu preencho "senha" com "teste"
    And Eu clico no botao "logar"
    Then Eu poderia ver "usuário e/ou senha incorretos!"

  Scenario: Acessar Administração de Participantes
    When Eu navego para a página "/login.xhtml"
    And Eu preencho "usuario" com "admin"
    And Eu preencho "senha" com "admin"
    And Eu clico no botao "logar"
    Then Eu poderia ver "Administrar Inscritos"
    