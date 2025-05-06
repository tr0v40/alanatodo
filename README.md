# TODO - Teste da Alana
Criar um app de TODO Android modular, com persistência local com Room, e UI com Jetpack Compose.
Utilizar arquitetura Clean Arquiteture e MVVM. Realizar uma pesquisa sobre ambas

## Funcionalidades mínimas
- Adicionar, listar, editar e remover tarefas.
- Marcar como concluída.
- Persistência local (Room).
- Separação por camadas (data, domain, presentation).
- Usar ViewModel e LiveData/StateFlow.
- Navegação entre telas com Jetpack Navigation.
- UI com Jetpack Compose.
- Testes unitários nos use cases e ViewModels.
- Uso de Dagger para injeção de dependência.

**Se der tempo** 
- Tela de estatísticas (total de tarefas, feitas, pendentes)
- Exportar/compartilhar tarefas

## Boas práticas
- Criar branch separada da main. Após a entrega será feito um pull request para a main aonde será feito o code review.
- Gerar documentação do projeto no formato Markdown.
- Criar diagrama de arquitetura simples (usar Mermaid e colocar no readme).
- Incluir instruções de build e rodar o app.


## Entregaveis
- Projeto Android completo no Git (com commits organizados).
- Arquivo ANNOTATION.MD aonde deve colocar todos os prompts utilizados, duvidas e dificuldades listadas.
- Apresentação do projeto para equipe, explicando as decisões, código e mostrando o App rodando.
- Apresentação da pesquisa sobre Clean Architeture e MVVM. (separado da entrega do app)


## Arquitetura
Deve seguir o padrão de arquitetura usando Clean Architeture e MVVM (Pesquisar e trazer um resumo sobre ambas)
```
todoapp/
│
├── data/
│   ├── local/
│   ├── repository/
│   └── mapper/
├── domain/
│   ├── model/
│   ├── repository/
│   └── usecase/
├── presentation/
│   ├── ui/
│   │   ├── screen/
│   │   └── components/
│   └── viewmodel/
├── di/
└── utils/
```

### Links úteis
- [Markdown](https://www.markdownguide.org/cheat-sheet/)
- [Documentação Kotlin](https://kotlinlang.org/docs/home.html)
- [Exemplo Master] (https://habitica.com/static/home)


### Exemplos de Apoio
São repos de todo-list com exemplos visuais para inspiração, use apenas isso, esqueça os codigos
- [1](https://github.com/jouwdan/Todo)
- [2](https://github.com/garg-lucifer/ToDoListApp)
- [3](https://github.com/Coding-Meet/Todo-App)
