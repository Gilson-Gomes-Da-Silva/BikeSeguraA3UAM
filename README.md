#  Bike Segura - Sistema de Apoio ao Ciclista

Projeto desenvolvido para a UC de **Algotimos e Programação** na **Universidade Anhembi Morumbi - Vila Olímpia**.

O **Bike Segura** é uma solução computacional em Java que visa resolver o problema social da falta de segurança e infraestrutura para ciclistas urbanos.

---

##  Funcionalidades (Requisitos do Projeto)

O sistema permite gerenciar a segurança do ciclista através de:
* **Gestão de Rotas:** Cadastro e listagem de trajetos com cálculo de segurança.
* **Reporte de Perigos:** Alertas sobre acidentes, obras e iluminação.
* **Pontos de Apoio:** Localização de Bebedouros, Oficinas e Pontos de Ar.
* **Avaliações:** Feedback dos usuários sobre as rotas utilizadas.


##  Conceitos de POO aplicados

A solução aplica os seguintes pilares da Programação Orientada a Objetos exigidos na avaliação:

1.  **Encapsulamento:** Todos os atributos são `private` com acesso via getters e setters.
2.  **Herança:** Utilizada para especializar tipos de perigos e pontos de apoio.
3.  **Polimorfismo:** Sobrescrita de métodos (`@Override`), como no método `toString()` e em métodos de cálculo.
4.  **Listas:** Uso de `ArrayList` para armazenamento dinâmico de objetos em memória.
5.  **Organização:** Código dividido nos pacotes `model`, `service` e `view`.

---

## Autores
* Gilson Gomes da Silva, RA: 12526160131
* Daniel dos Santos Pereira, RA: 12526158668
