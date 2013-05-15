Feature: Inscrição do Participante no Congresso
    Passos que verificam seu o campo esta vazio
    Verifica se os campos são corretos
    Verifica se o CPF é Válido

    Scenario: verificar se o campo Nome esta vazio
        When Eu navego para a página "/inscricao.xhtml"
        And Eu preencho "nome" com ""
        And Eu clico no botao "cadastrar"
        Then Eu poderia ver "o valor é Necessário"


    Scenario: verificar se o campo CPF esta invalido
        When Eu navego para a página "/inscricao.xhtml"
        And Eu preencho "cpf" com "11111111111"
        And Eu clico no botao "cadastrar"
        Then Eu poderia ver "CPF inválido"

    Scenario: verificar se os campos  estao corretos
        When Eu navego para a página "/inscricao.xhtml"
        And Eu preencho "nome" com "João Da Silva"
        And Eu preencho "cpf" com "05103676583"
        And Eu preencho "rg" com "403289440"
        And Eu preencho "endereco" com "Rua Antônio Tosin"
        And Eu preencho "numero" com "33"
        And Eu preencho "cidade" com "Curitiba"
        And Eu preencho "estado" com "Paraná"
        And Eu preencho "cep" com "81230400"
        And Eu preencho "telefone" com "04191843176"
        And Eu preencho "email" com "joaods@gmail.com"
        And Eu seleciono a "1"ª opção do checkbox "selcurso"       
        And Eu clico no botao "cadastrar"
        Then Eu poderia ver "Cadastro feito com Sucesso!" 