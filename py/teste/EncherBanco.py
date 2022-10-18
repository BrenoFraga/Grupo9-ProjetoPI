import GerarCpf
import GerarCnpj
import GerarData
import GerarTelefone
from br_nome_gen import pessoa_random
from unidecode import unidecode
from random import randint
import random
import lorem
import GerarCep
import GerarNomes

def controleIdade():
    vetorData=[]
    i=0
    while i<27:
        if i<8:
            vetorData.append("20010731")
        elif i<15:
            vetorData.append("19910731")
        elif i<22:
            vetorData.append("19810731")
        elif i<27:
            vetorData.append("19710731")
        i+=1
    i=0
    while i<24:
        if i<6:
            vetorData.append("20010731")
        elif i<12:
            vetorData.append("19910731")
        elif i<19:
            vetorData.append("19810731")
        elif i<24:
            vetorData.append("19710731")
        i+=1
    i=0
    while i<12:
        if i<3:
            vetorData.append("20010731")
        elif i<6:
            vetorData.append("19910731")
        elif i<8:
            vetorData.append("19810731")
        elif i<12:
            vetorData.append("19710731")
        i+=1
    i=0
    while i<6:
        if i<1:
            vetorData.append("20010731")
        elif i<3:
            vetorData.append("19910731")
        elif i<5:
            vetorData.append("19810731")
        elif i<6:
            vetorData.append("19710731")
        i+=1
    i=0
    while i<10:
        if i<2:
            vetorData.append("20010731")
        elif i<5:
            vetorData.append("19910731")
        elif i<7:
            vetorData.append("19810731")
        elif i<10:
            vetorData.append("19710731")
        i+=1
    i=0
    while i<10:
        if i<2:
            vetorData.append("20010731")
        elif i<4:
            vetorData.append("19910731")
        elif i<7:
            vetorData.append("19810731")
        elif i<10:
            vetorData.append("19710731")
        i+=1
    i=0
    while i<6:
        if i<1:
            vetorData.append("20010731")
        elif i<3:
            vetorData.append("19910731")
        elif i<4:
            vetorData.append("19810731")
        elif i<6:
            vetorData.append("19710731")
        i+=1
    i=0
    while i<5:
        if i==0:
            vetorData.append("20010731")
        elif i==1:
            vetorData.append("19910731")
        elif i<4:
            vetorData.append("19810731")
        elif i<5:
            vetorData.append("19710731")
        i+=1
    v=GerarCep.vetorCep()
    v2=GerarNomes.vetorPessoa()
    i=0
    sql1=''
    sql2=''
    sql3=''
    sql4=''
    while i<100: 
        nomePessoa=v2[i]
        vetorNome=nomePessoa.nome.split(" ")
        usuario=vetorNome[0]+'_'+vetorNome[-1]
        lista = ['Java', 'Python', 'SQL', 'SQL Server', 'PHP', 'C#', 'C++', 'C', 'Kotlin', 'Ruby','JavaScript','Vue','React','Swift','Objective C','React Native']
        nomeLinguagem = random.choice(lista)
        area = ''
        qtdProf = randint(1,6)
        qtfFK = randint(1,100)
        levelKnl = randint(1,3)
        if nomeLinguagem == 'Java' or nomeLinguagem == 'PHP' or nomeLinguagem == 'C#' or nomeLinguagem == 'Ruby'or nomeLinguagem == 'C' or nomeLinguagem == 'C++':
            area = 'Backend'
        elif nomeLinguagem == 'Python'or nomeLinguagem == 'SQL' or nomeLinguagem == 'SQL Server' or nomeLinguagem == 'R':
            area = 'Dados'
        elif nomeLinguagem == 'JavaScript' or nomeLinguagem == 'Vue' or nomeLinguagem == 'React':
            area = "Frontend"
        elif nomeLinguagem == 'Kotlin' or nomeLinguagem == 'Swift' or nomeLinguagem == 'Objective C' or nomeLinguagem == 'React Native':
            area = 'Mobile'
        if len(usuario)>20:
            usuario=vetorNome[0]+'_'+vetorNome[1]
        osArquivo1=open("InserirContratante.sql","a")
        osArquivo2=open("InserirFreelancer.sql","a")
        osArquivo3=open("InserirProjeto.sql","a")
        osArquivo4=open("InserirHabilidade.sql","a")
        sql1 += f"""INSERT INTO contactor values (null, null,'{unidecode(nomePessoa.nome.replace("'",""))}','{unidecode(usuario)+"@gmail.com"}','Senha123','{GerarCnpj.cnpj()}','{GerarCpf.cpf()}', '{GerarTelefone.telefone()}','Brasil','São Paulo','São Paulo','{1}');\n"""
        sql2 += f"""INSERT INTO user_freelancer values (null, null,'{unidecode(nomePessoa.nome.replace("'",""))}','{unidecode(usuario)+"@gmail.com"}','Senha123',null,'{GerarCpf.cpf()}', '{GerarTelefone.telefone()}','Brasil','São Paulo','São Paulo','{4}','{1}');\n"""
        sql3 += f"""INSERT INTO register_project_contactor VALUES (null, null, '{unidecode(nomePessoa.nome.replace("'",""))}','{lorem.sentence()}','{area}','{nomeLinguagem}',{qtdProf},{qtfFK});\n"""
        sql4 += f"""INSERT INTO register_specialty_user VALUES (null, '{area}','{nomeLinguagem}','{levelKnl}',{qtfFK});\n"""
        i+=1
    osArquivo1.writelines(sql1)
    osArquivo2.writelines(sql2)
    osArquivo3.writelines(sql3)
    osArquivo4.writelines(sql4)
    osArquivo1.close()
    osArquivo2.close()
    osArquivo3.close()
    osArquivo4.close()
    ##controleOng()
    ##controleDoacao()
    
def calculoIdade(dataSorteada):
    return 2022-int(dataSorteada[:4])

def controleDoacao():
    osArquivo=open("Inserir.sql","a")
    i=1
    sql=""
    while i<=10: 
        dc=GerarData.diaCampanha()
        va=random.randint(1,1000)
        sql += f"""INSERT INTO campanha values (null, '{dc}','{lorem.sentence()}', false, 'lorem','lorem',{random.randint(1,4)},{va},{i});\n"""
        vd=0
        j=0
        booleano=True
        while booleano:
            pessoa=random.randint(1,100)
            vd=random.randint(1,100)
            j+=vd
            while j>va:
                j-=vd
                vd=random.randint(1,100)
                j+=vd
            booleano=j<va
            sql += f"""insert into doacao values (null, '{GerarData.diaDoacao(int(dc[4:6]),int(dc[6:]))}',{vd},{i},{pessoa});\n"""
        i+=1
    osArquivo.writelines(sql)

def controleOng():
    i=0
    while i<10: 
        nomePessoa=pessoa_random()
        vetorNome=nomePessoa.nome.split(" ")
        usuario=vetorNome[0]+'_'+vetorNome[-1]
        v=GerarCep.vetorCep()
        osArquivo=open("Inserir.sql","a")
        sqlOng = f"""INSERT INTO ong (cod, autenticado, cep, data_criacao_conta, email, foto_perfil, nome, numero, senha, telefone, usuario, cnpj, data_nascimento) values (null, false, '{v[i]}', '{GerarData.diaCriacao()}', '{unidecode(usuario)+"@gmail.com"}', null, '{unidecode(nomePessoa.nome.replace("'",""))}', 99, 'Senha123', '{GerarTelefone.telefone()}', '{unidecode(usuario)}', '{GerarCnpj.cnpj()}', '{GerarData.diaAniversario()}');\n"""
        osArquivo.writelines(sqlOng)
        i+=1
controleIdade()