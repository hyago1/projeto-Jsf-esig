# Projeto de Gerenciamento de Tarefas em JSF

Este projeto é uma aplicação web desenvolvida em JavaServer Faces (JSF) que permite aos usuários gerenciar suas tarefas de forma eficiente. A aplicação segue o padrão MVC (Model-View-Controller), promovendo uma estrutura clara e organizada.


## Tecnologias Utilizadas
- **Java**
- **HTML**
- **CSS**
- **JavaScript**
- **JSF**
- **PrimeFaces** (framework para JSF)


## Estrutura do Projeto JSF - item a)

### 1. **Bean**
- **TarefaBean.java**: Este é o bean principal do projeto, responsável pela lógica de negócios relacionada às tarefas. Ele manipula as requisições do usuário e interage com a camada de dados para realizar operações como criar, buscar, excluir e concluir tarefas.

### 2. **DAO**
- **TarefaDAO.java**: Este arquivo contém a implementação das conexões com o banco de dados PostgreSQL, além dos métodos necessários para realizar operações de inserção, atualização e exclusão de tarefas.

### 3. **Model**
- **TarefaModel.java**: Este modelo representa a estrutura das tarefas na aplicação. Ele contém atributos que correspondem aos campos da tabela no banco de dados e métodos para manipular esses dados.

### 4. **Banco de Dados**
Foi criada uma tabela "teste" no banco de dados com os seguintes campos:
- **numero**: Identificador único da tarefa.
- **titulo**: Título descritivo da tarefa.
- **descricao**: Detalhes adicionais sobre a tarefa.
- **responsável**: Pessoa responsável pela tarefa.
- **data**: Data de criação ou prazo da tarefa.
- **prioridade**: Nível de prioridade da tarefa.

### 5. **Interface do Usuário**
A aplicação possui uma interface limpa, minimalista e fácil de entender, projetada para proporcionar uma boa experiência ao usuário.
![image](https://github.com/user-attachments/assets/5c1c3b28-eebc-4f41-b8f7-8376cc1fe6d0)


## Funcionalidades Implementadas - item b)
- **Criar Tarefa**: Permite ao usuário adicionar novas tarefas ao sistema.
- **Buscar Tarefas**: Facilita a busca por tarefas existentes com base em critérios específicos.
- **Excluir Tarefa**: Permite que o usuário remova tarefas do sistema.
- **Concluir Tarefa**: Marca uma tarefa como concluída.
- **Editar Tarefa**: Edita uma tarefa - (bug - Edita apenas apartir da segunda tarefa).

## Instruções para Execução Local

Para rodar este projeto em um ambiente local, siga as instruções abaixo:

1. **Pré-requisitos**:
   - JDK 1.8. Configurar a versão do java do projeto no eclipse.
   - Apache Tomcat (versão 9.0)
   - Banco de dados PostgreSQL configurado com a tabela apropriada.
   - Necessario mudar os valores no arquivo TarefaDao.java de acordo com a sua tabela para a conexão. 

2. **Clonar o Repositório**:
   ```bash
   git clone <URL do repositório>
