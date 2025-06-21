📚 Projeto: Inspetoria de Alunos
Este projeto é um sistema de controle de reservas de salas de aula, professores e turmas, voltado para a gestão da Inspetoria de Alunos de uma instituição de ensino.

✅ Tecnologias utilizadas:
Java - Linguagem principal do projeto.

MySQL - Banco de dados relacional utilizado para armazenamento.

Maven - Gerenciador de dependências e build.

JUnit - Ferramenta de teste unitário para garantir a qualidade do código.

Git - Controle de versão para gerenciamento do projeto.

✅ Estrutura de Camadas (MVC):
Model: Representa as entidades principais (Reserva, Professor, Sala, Turma, Turno etc.).

DAO (Data Access Object): Responsável pelas operações de acesso ao banco de dados (consultas, inserções, edições, exclusões).

Service: Contém as regras de negócio e validações.

Main: Interface simples via terminal para interação com o usuário.

✅ Principais Funcionalidades:
Cadastro, listagem, edição e exclusão de:

Cursos

Disciplinas

Professores

Salas de Aula

Turnos

Turmas

Reservas de sala

Relatórios especiais:

Buscar reservas feitas por um professor.

Encontrar a sala de aula mais utilizada.

Contar total de agendamentos em uma determinada data.

✅ Casos de Teste (JUnit):
Foram criados testes automatizados para garantir o funcionamento correto de algumas das principais funções:

Buscar Reservas com Professor Vinculado:
Valida se existem reservas associadas a professores no sistema.

Sala de Aula Mais Utilizada:
Confirma se o sistema consegue retornar a sala com maior número de reservas.

Quantidade de Agendamentos por Data:
Verifica o total de reservas feitas em uma data específica.

✅ Proteção contra SQL Injection:
Todas as consultas que recebem dados externos usam PreparedStatement, prevenindo ataques de SQL Injection.

✅ Como executar o projeto:
Configure o banco de dados MySQL com o script SQL fornecido.

Configure as credenciais de acesso no arquivo de conexão (Conexao.java).

Compile o projeto com Maven.

Rode a aplicação pelo terminal ou pela IDE (ex.: IntelliJ).

Execute os testes com JUnit para validar o funcionamento.

✅ Observações:
Este projeto foi desenvolvido com fins educacionais.

Foco em práticas básicas de Java, JDBC e testes unitários.
