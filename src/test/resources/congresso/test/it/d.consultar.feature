Feature: Página de Consulta do Participante    
    Verificar se acessou corretamente

  Scenario: Verificar se acessou corretamente
    When Eu navego para a página "/consulta.xhtml?participante=1"   
    Then Eu poderia ver "Bruno Guilherme Andretta de Miranda"