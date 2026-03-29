# Front-App

## Descrição

Aplicação frontend desenvolvida em Angular para o 
desafio proposto pela BIP. Esta aplicação permite a gestão completa de benefícios, incluindo criação, edição, visualização e listagem de benefícios disponíveis.

## Tecnologias Utilizadas

- **Angular**: Framework principal para o desenvolvimento da interface.
- **TypeScript**: Linguagem de programação utilizada.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- Node.js (versão 18 ou superior)
- npm (gerenciador de pacotes do Node.js)

## Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/JeanLTP/bip-teste-integrado.git
   cd bip-teste-integrado/frontend/front-app
   ```

2. Instale as dependências:
   ```bash
   npm install
   ```

## Execução

Para executar a aplicação em modo de desenvolvimento:

```bash
npm start
```

A aplicação estará disponível em `http://localhost:4200`.

Para executar com renderização do lado do servidor:

```bash
npm run serve:ssr:front-app
```

## Estrutura do Projeto

```
src/
├── app/
│   ├── core/
│   │   └── service/
│   │       └── benefit.service.ts    # Serviço para operações com benefícios
│   ├── features/
│   │   └── benefits/
│   │       ├── benefit-detail.component.ts  # Componente de detalhe do benefício
│   │       ├── benefit-form.component.ts    # Formulário de criação/edição
│   │       └── benefit-list.component.ts    # Lista de benefícios
│   ├── models/
│   │   ├── benefit.model.ts                 # Modelo de dados do benefício
│   │   ├── create-benefit-request.model.ts  # Modelo para requisição de criação
│   │   └── create-id-response.model.ts      # Modelo para resposta de criação
│   └── app.routes.ts                        # Configuração de rotas
├── main.ts                                  # Ponto de entrada da aplicação
└── styles.css                               # Estilos globais
```

## Scripts Disponíveis

- `npm start`: Inicia o servidor de desenvolvimento.
- `npm run build`: Compila a aplicação para produção.
- `npm run watch`: Compila em modo watch para desenvolvimento.
- `npm test`: Executa os testes.
- `npm run serve:ssr:front-app`: Executa a aplicação com SSR.

## Funcionalidades

- **Listagem de Benefícios**: Visualizar todos os benefícios cadastrados.
- **Criação de Benefícios**: Adicionar novos benefícios com nome, descrição, valor e status.
- **Edição de Benefícios**: Modificar informações de benefícios existentes.
- **Detalhes do Benefício**: Visualizar informações completas de um benefício específico.

## Contribuição

Para contribuir com o projeto:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto é privado e destinado ao uso interno.
