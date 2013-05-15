Feature: Administrar do Participante no Congresso
    Administrador edita um participante
    Administrador exclui um participante

    Scenario:  Administrador edita um participante
        When Eu navego para a página "/administracao.xhtml"        
        And Eu clico no botao "participante:1:editar"
        And Eu preencho "cpf" com "96147185527"
        And Eu clico no botao "alterar"
        Then Eu poderia ver "96147185527"
        Then Eu poderia ver "joaods@gmail.com"

    Scenario:  Administrador exclui um participante
        When Eu navego para a página "/administracao.xhtml"        
        And Eu clico no botao "participante:1:excluir"
        Then Eu poderi nao poderia ver "participante:1:excluir"

        