import random
def gerarCep():
    cep = random.randint(0,99999999)
    cep = str(cep).zfill(8)
    return cep

def vetorCep():
    vetorContadorRegiao=[0,0,0,0,0]
    vetorCep=[]
    booleano = vetorContadorRegiao[0]==23 and vetorContadorRegiao[1]==22 and vetorContadorRegiao[2]==21 and vetorContadorRegiao[3]==18 and vetorContadorRegiao[4]==16
    while (not booleano):
        cep = gerarCep()
        regiao = int(cep[0:3])
        if 0<=regiao<=399 and vetorContadorRegiao[1]<22:
            vetorContadorRegiao[1]+=1
            vetorCep.append(cep)
        elif 400<=regiao<=659 and vetorContadorRegiao[0]<23:
            vetorContadorRegiao[0]+=1
            vetorCep.append(cep)
        elif 800<=regiao<=999 and vetorContadorRegiao[3]<18:
            vetorContadorRegiao[3]+=1
            vetorCep.append(cep)
        elif (700<=regiao<=767 or 780<=regiao<=788 or 790<=regiao<=799) and vetorContadorRegiao[2]<21:
            vetorContadorRegiao[2]+=1
            vetorCep.append(cep)
        elif (770<=regiao<=779 or regiao==789 or 660<=regiao<=699) and vetorContadorRegiao[4]<16:
            vetorContadorRegiao[4]+=1
            vetorCep.append(cep)
        booleano = vetorContadorRegiao[0]==23 and vetorContadorRegiao[1]==22 and vetorContadorRegiao[2]==21 and vetorContadorRegiao[3]==18 and vetorContadorRegiao[4]==16
    return vetorCep