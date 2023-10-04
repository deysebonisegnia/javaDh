## Estrutura de diretórios:

```yaml
    src:
#     projeto principal que será compilado
      main: 
        java:
          br:
            com:
              digitalhouse:
                empresas:
#                 diretorio de entrada para a aplicação, rest, mensageria e etc
                  api:
#                   diretorios para os controladores rest
                    controller:
                    dto:
#                     objetos de requisição
                      request:
#                     objetos de resposta
                      response:
                  domain:
#                   entidades
                    entity:
#                   servicos
                    service:
#                   repositorios
                    repository:
```