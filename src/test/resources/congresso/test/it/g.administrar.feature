Feature: Administrar do Participante no Congresso
    Administrador edita um participante
    Administrador exclui um participante

    Scenario:  Administrador edita um participante
        When Eu navego para a página "/administracao.xhtml"        
        And Eu clico no botao "participante:1:editar"
        And Eu preencho "cpf" com "96147185527"
        And Eu clico no botao "alterar"        
        Then Eu poderia ver "Administrar"

    Scenario:  Administrador exclui um participante
        When Eu navego para a página "/administracao.xhtml"        
        And Eu clico no botao "participante:1:excluir"
        Then Eu nao poderia ver "Administrar"

        