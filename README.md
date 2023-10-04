# cp4-kotlin

•	Exibir um TextView centralizado no topo com a seguinte string: “Corrida de cavalos”. (0,5 ponto)
•	Exibir dois botões, um para iniciar a corrida, e outro para parar a corrida. (0,5 ponto)
•	Exibir as informações de dois cavalos, sendo elas: O Nome e a cor do cavalo, e uma barra de progresso que exiba o progresso do cavalo na corrida e tenha a mesma cor do cavalo. (1 ponto)
•	No início da corrida, as barras de progresso de cada cavalo devem estar zeradas. (0,5 ponto)
•	Ao clicar no botão iniciar, as duas barras de progresso devem iniciar a corrida simultaneamente. (0,5 ponto)
•	Ao clicar no botão parar, as barras de progresso devem parar de incrementar. (1 pontos)
•	Utilize corrotinas para gerar valores aleatórios de 0 a 20 que devem ser gerados fora do thread principal (Main Thread). Esses valores devem ser incrementados em cada barra de progresso e devem ser gerados de acordo com um delay de 1500 ms (1,5 segundo). Cada barra de progresso deve ser incrementada com um valor aleatório diferente. Sua lógica deve ser feita dentro de uma ViewModel.
(5 pontos)
•	No final da corrida, quando a primeira barra de progresso atingir 100%, exiba um TextView informando qual cavalo venceu a corrida. (1 ponto)
