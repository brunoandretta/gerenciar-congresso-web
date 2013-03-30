Feature: Cadastro do Participante no Congresso
    Passos que verificam seu o campo esta vazio
    Verifica se os campos são corretos
    Verifica se o CPF é Válido

    Scenario: verificar se o campo Nome esta vazio
        Given Estou na página de cadastro
        And Eu preencho "nome" com ""
        And Eu clico no botao "confirmar"
        Then Eu poderia ver "o valor é necessário"


    Scenario: verificar se o campo CPF esta invalido
        Given Estou na página de cadastro
        And Eu preencho "cpf" com "11111111111"
        And Eu clico no botao "confirmar"
       Then Eu poderia ver "CPF inválido"

    Scenario: verificar se os campos  estao corretos
        Given Estou na página de cadastro
        And Eu preencho "nome" com "Bruno"
        And Eu preencho "cpf" com "085394039-86"
        And Eu preencho "rg" com "102745124"
        And Eu preencho "rua" com "Rua Aristoteles"
        And Eu preencho "numero" com "76"
        And Eu preencho "cidade" com "Curitiba"
        And Eu preencho "estado" com "PR"
        And Eu preencho "cep" com "82700-010"
        And Eu preencho "telefone" com "04184711627"
        And Eu preencho "email" com "brunogandrettam@gmail.com"
        And Eu seleciono a "1"ª opção do checkbox "selcursos"
        And Eu clico no botao "confirmar"
        Then Eu poderia ver "Cadastro feito com Sucesso!"      


        
        