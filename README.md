Atividade do dia 10/04

### 1)
    A. O que é uma View no Android Framework?
    R: A View é uma classe no android que possibilita desenhar um componente visual na tela, todos os
    widgets extendem da View, como TextView, Button, etc...
---
    B. O que é um ViewGroup no contexto da interface do Android?
    R: É uma subclasse da View que tem como finalidade organizar, posicionar outras Views.
---
    C. Qual é a função dos LayoutParams dentro de um ViewGroup?
    R: Os LayoutParams são os parametros que dizem para o layout pai como posicionar e dimencionar a
    View Filha. Sendo basicamente os parametros de configuração de uma view dentro do viewgroup
--- 
    D. Por que diferentes ViewGroups (como LinearLayout, ConstraintLayout, FrameLayout) utilizam
    subclasses específicas de LayoutParams?
    R: Cada ViewGroup organiza as Views de um jeito diferente, dependendo de regras diferentes. Porem
    essas informações não existem dentro da classe base LayoutParams, então por isso cada ViewGroup
    define uma subclasse própria.