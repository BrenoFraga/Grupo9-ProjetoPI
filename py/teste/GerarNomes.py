from br_nome_gen import pessoa_random
def vetorPessoa():
    vetorContadorGenero=[0,0]
    vetorNomes=[]
    booleano=vetorContadorGenero[0]==56 and vetorContadorGenero[1]==44
    while not booleano:
        pessoa=pessoa_random()
        while len(pessoa.nome)>45:
            pessoa=pessoa_random()
        if pessoa.masc and vetorContadorGenero[1]<44:
            vetorContadorGenero[1]+=1
            vetorNomes.append(pessoa)
        elif (not pessoa.masc) and vetorContadorGenero[0]<56:
            vetorContadorGenero[0]+=1
            vetorNomes.append(pessoa)
        booleano=vetorContadorGenero[0]==56 and vetorContadorGenero[1]==44
    return vetorNomes