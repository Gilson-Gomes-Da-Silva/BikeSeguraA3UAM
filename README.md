#  Bike Segura - Sistema de Apoio ao Ciclista

Projeto desenvolvido para a UC de **Algotimos e Programação** na **Universidade Anhembi Morumbi - Vila Olímpia**.

O **Bike Segura** é uma solução computacional em Java que visa resolver o problema social da falta de segurança e infraestrutura para ciclistas urbanos[cite: 8, 15].

---

##  Funcionalidades (Requisitos do Projeto)

O sistema permite gerenciar a segurança do ciclista através de:
* **Gestão de Rotas:** Cadastro e listagem de trajetos com cálculo de segurança.
* **Reporte de Perigos:** Alertas sobre acidentes, obras e iluminação[cite: 75].
* **Pontos de Apoio:** Localização de Bebedouros, Oficinas e Pontos de Ar.
* **Avaliações:** Feedback dos usuários sobre as rotas utilizadas.


##  Estrutura Técnica (Conceitos de POO)

A solução aplica os seguintes pilares da Programação Orientada a Objetos exigidos na avaliação[cite: 18]:

1.  **Encapsulamento:** Todos os atributos são `private` com acesso via getters e setters[cite: 18, 60].
2.  **Herança:** Utilizada para especializar tipos de perigos e pontos de apoio[cite: 18, 78].
3.  **Polimorfismo:** Sobrescrita de métodos (`@Override`), como no método `toString()` e em métodos de cálculo[cite: 18, 55, 79].
4.  **Listas:** Uso de `ArrayList` para armazenamento dinâmico de objetos em memória[cite: 18, 62].
5.  **Organização:** Código dividido nos pacotes `model`, `service` e `view`[cite: 18, 59].

---

##  Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/Gilson-Gomes-Da-Silva/BikeSeguraA3UAM.git](https://github.com/Gilson-Gomes-Da-Silva/BikeSeguraA3UAM.git)
