Feature: Cadastro do Participante no Congresso
    Passos que verificam seus campos estão vazio
    Passos que os campos são corretos
    Verifica se o CPF é Válido

    Scenario: verificar se o campo Nome esta vazio
        Given Estou na página de cadastro
        And Eu preencho "nome" com ""
        And Eu clico no botao "confirmar"
        Then Eu poderia ver "Erro de valida"

#    Scenario: verificar se o campo CPF esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "cpf" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida"
#
#    Scenario: verificar se o campo CPF esta invalido
#        Given Estou na página de cadastro
#        And Eu preencho "cpf" com "11111111111"
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "CPF inv"
#
#    Scenario: verificar se o campo RG esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "rg" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida"
#
#    Scenario: verificar se o campo Endereco esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "rua" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida"

#    Scenario: verificar se o campo Numero esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "numero" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida"

#    Scenario: verificar se o campo Cidade esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "cidade" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida"

#    Scenario: verificar se o campo Estado esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "estado" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida"

#    Scenario: verificar se o campo Cep esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "cep" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida"

#    Scenario: verificar se o campo Telefone esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "telefone" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida"

#    Scenario: verificar se o campo Email esta vazio
#        Given Estou na página de cadastro
#        And Eu preencho "email" com ""
#        And Eu clico no botao "confirmar"
#        Then Eu poderia ver "Erro de valida" 

    Scenario: verificar se os campos  estao corretos
        Given Estou na página de cadastro
        And Eu preencho "nome" com "Bruno"
        And Eu preencho "cpf" com "08539403986"
        And Eu preencho "rg" com "102745124"
        And Eu preencho "rua" com "Rua Aristoteles"
        And Eu preencho "numero" com "76"
        And Eu preencho "cidade" com "Curitiba"
        And Eu preencho "estado" com "PR"
        And Eu preencho "telefone" com "04184711627"
        And Eu preencho "email" com "brunogandrettam@gmail.com"
        And Eu clico no botao "confirmar"
        Then Eu poderia ver "Cadastro Feito com Sucesso!"      


        
        