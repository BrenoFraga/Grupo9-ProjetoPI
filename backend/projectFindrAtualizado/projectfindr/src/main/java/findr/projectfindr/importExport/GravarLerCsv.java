package findr.projectfindr.importExport;

import findr.projectfindr.datastructure.ListaObj;
import findr.projectfindr.model.Contactor;
import findr.projectfindr.model.ProjectModel;
import findr.projectfindr.response.UserResponse;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GravarLerCsv {
//    public  String gravaArquivoCsv(ListaObj<ProjectModel> lista, String nomeArq) {
//        FileWriter arq = null;
//        String saida = "";
//        Boolean deuRuim = false;
//        nomeArq += ".csv";
//
//        try {
//            arq = new FileWriter(nomeArq);
//        }
//        catch (IOException erro) {
//            System.out.println("Erro ao abrir o arquivo!");
//            System.exit(1);
//        }
//
//        try {
//            for (int i = 0; i < lista.getTamanho(); i++) {
//                ProjectModel projects = lista.getElemento(i);
//                saida += String.format("%d;%s;%s;%s;%s;%d" + (i == lista.getTamanho() - 1 ? "" : "\n"),
//                        projects.getIdProjectContactor(),
//                        projects.getNameProject(),
//                        projects.getDescriptionProject(),
//                        projects.getRequiredArea(),
//                        projects.getRequiredLanguages(),
//                        projects.getQuantityProfissionals());
//            }
//        }
//        catch (FormatterClosedException erro) {
//            System.out.println("Erro ao gravar arquivo");
//            deuRuim = true;
//        }
//        finally {
//            try {
//                arq.close();
//            }
//            catch (IOException erro) {
//                System.out.println("Erro ao fechar o arquivo");
//                deuRuim = true;
//            }
//            if (deuRuim) {
//                System.exit(1);
//            }
//        }
//        return saida;
//    }
//
//    public  void leArquivoCsv(String nomeArq) {
//        FileReader arq = null;
//        Scanner entrada = null;
//        Boolean deuRuim = false;
//        nomeArq += ".csv";
//
//        try {
//            arq = new FileReader(nomeArq);
//            entrada = new Scanner(arq).useDelimiter(";|\\n");
//        }
//        catch (FileNotFoundException erro) {
//            System.out.println("Arquivo não encontrado");
//            System.exit(1);
//        }
//
//        try {
//            System.out.printf("%4s %-9s %-30s %-20s %-20s %5s\n", "ID PROJECT", "NOME DO PROJETO",
//                    "DESCRIÇÃO DO PROJETO", "ÁREA REQUERIDA", "LINGUAGEM REQUERIDA", "QUANTIDADE DE PROFISSIONAIS");
//            while (entrada.hasNext()) {
//                Long idProjectContactor = entrada.nextLong();
//                String nameProject = entrada.next();
//                String descriptionProject = entrada.next();
//                String requiredArea = entrada.next();
//                String requiredLanguages = entrada.next();
//                Integer quantityProfissionals = entrada.nextInt();
//                System.out.println(quantityProfissionals);
//                System.out.printf("%04d %-9s %-30s %-20s %-20s %5d\n",
//                        idProjectContactor,
//                        nameProject,
//                        descriptionProject,
//                        requiredArea,
//                        requiredLanguages,
//                        quantityProfissionals);
//            }
//        }
//        catch (NoSuchElementException erro) {
//            System.out.println("Arquivo com problemas");
//            erro.printStackTrace();
//            deuRuim = true;
//        }
//        catch (IllegalStateException erro) {
//            System.out.println("Erro na leitura do arquivo");
//            deuRuim = true;
//        }
//        finally {
//            entrada.close();
//            try {
//                arq.close();
//            }
//            catch (IOException erro) {
//                System.out.println("Erro ao fechar o arquivo");
//                deuRuim = true;
//            }
//            if (deuRuim) {
//                System.exit(1);
//            }
//        }
//    }
//
//    public  void gravaRegistro(String registro, String nomeArq){
//        BufferedWriter saida = null;
//
//        try{
//            saida = new BufferedWriter(new FileWriter(nomeArq, true));
//        }
//        catch (IOException erro){
//            System.out.println("Erro ao abrir o arquivo: " + erro);
//        }
//
//        try {
//            saida.append(registro + "\n");
//            saida.close();
//        }
//        catch (IOException erro){
//            System.out.println("Erro ao abrir o arquivo" + erro);
//        }
//    }
//
//    public  String gravaArquivoTxt(ListaObj<UserResponse> lista, ListaObj<ProjectModel> lista2, String nomeArq){
//        int contaRegistroCorpo = 0;
//        String gravaTudo = null;
//        String header = "00NOTA20221";
//        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
//        header += "01";
//        gravaRegistro(header, nomeArq);
//        gravaTudo += header;
//
//        String corpo;
//        for (int i = 0; i < 1; i++){
//            UserResponse userResponse = lista.getElemento(i);
//            corpo = "02";
//            corpo += String.format("%-40.40s", userResponse.getName());
//            corpo += String.format("%-30.30s", userResponse.getEmail());
//            corpo += String.format("%-10.10s", userResponse.getPhoneContact());
//            corpo += String.format("%-10.10s", userResponse.getCountry());
//            corpo += String.format("%-20.20s", userResponse.getState());
//            corpo += String.format("%-10.10s", userResponse.getCity());
//            gravaRegistro(corpo, nomeArq);
//            contaRegistroCorpo++;
//            gravaTudo += corpo;
//        }
//
//        for (int i = 0; i < 1; i++){
//            ProjectModel projectModel = lista2.getElemento(i);
//            corpo = "03";
//            corpo += String.format("%-10.10s", projectModel.getNameProject());
//            corpo += String.format("%-30.30s", projectModel.getDescriptionProject());
//            corpo += String.format("%-20.20s", projectModel.getRequiredArea());
//            corpo += String.format("%-20.20s", projectModel.getRequiredLanguages());
//            corpo += String.format("%05d", projectModel.getQuantityProfissionals());
//            gravaRegistro(corpo, nomeArq);
//            contaRegistroCorpo++;
//            gravaTudo += corpo;
//        }
//
//        String trailer = "01";
//        trailer += String.format("%010d", contaRegistroCorpo);
//        gravaRegistro(trailer, nomeArq);
//
//        gravaTudo += trailer;
//        return gravaTudo;
//    }
//
//    public boolean lerArquivoTxt(String nomeArq){
//        BufferedReader entrada = null;
//        String registro, tipoRegistro;
//        int contaRegDadoLido = 0;
//        int qtaRegGravada;
//        String nameProject, descriptionProject, requiredArea, requiredLanguages,
//                name, email, phoneContact, country, state, city;
//        Integer quantityProfissionals;
//        List<ProjectModel> listaLida = new ArrayList<>();
//        List<Contactor> listaLida2 = new ArrayList<>();
//
//        try{
//            entrada = new BufferedReader(new FileReader(nomeArq));
//        }catch (IOException erro){
//            System.out.println("Erro ao abrir o arquivo: " + erro);
//            return false;
//        }
//
//        try{
//            registro = entrada.readLine();
//            while (registro != null){
//                tipoRegistro = registro.substring(0, 2);
//                if (tipoRegistro.equals("00")){
//                    System.out.println("É um registro de header");
//                    System.out.println("Tipo do arquivo: " + registro.substring(2, 6));
//                    System.out.println("Ano/semestre: " + registro.substring(6, 11));
//                    System.out.println("Data e hora de gravação do arquivo: " +
//                            registro.substring(11, 30));
//                    System.out.println("Versão do documento de layout: " +
//                            registro.substring(30, 32));
//                }
//                else if (tipoRegistro.equals("01")){
//                    System.out.println("É um registro de trailer");
//                    qtaRegGravada = Integer.parseInt(registro.substring(2, 12).trim());
//                    if (contaRegDadoLido == qtaRegGravada){
//                        System.out.println("Quantidade de registros lidos compatível com a quantidade de registros gravados");
//                    }else{
//                        System.out.println("Quantidade de registros lidos incompatível com a quantidade de registros grcados");
//                    }
//                } else if(tipoRegistro.equals("02")){
//                    System.out.println("É um registro de corpo");
//
//                    name = registro.substring(2, 42).trim();
//                    email = registro.substring(42, 72).trim();
//                    phoneContact = registro.substring(72, 82).trim();
//                    country = registro.substring(82, 92).trim();
//                    state = registro.substring(92, 112).trim();
//                    city = registro.substring(112, 121).trim();
//                    contaRegDadoLido++;
//                    Contactor contactor = new Contactor(name, email, phoneContact, country, state, city);
//                    //contactorRepository.save(contactor);
//                    listaLida2.add(contactor);
//                }  else if (tipoRegistro.equals("03")) {
//                    System.out.println("É um registro de corpo");
//
//                    nameProject = registro.substring(2, 12).trim();
//                    descriptionProject = registro.substring(12, 42).trim();
//                    requiredArea = registro.substring(42, 62).trim();
//                    requiredLanguages = registro.substring(62, 82).trim();
//                    quantityProfissionals = Integer.parseInt(registro.substring(82, 87).trim());
//                    contaRegDadoLido++;
//                    ProjectModel projectModel = new ProjectModel(nameProject, descriptionProject, requiredArea, requiredLanguages, quantityProfissionals);
//                    //bd.save(projectModel);
//                    listaLida.add(projectModel);
//                } else {
//                    System.out.println("Tipo de registro inválido");
//                }
//                registro = entrada.readLine();
//            }
//
//            entrada.close();
//        }
//        catch (IOException erro){
//            System.out.println("Erro de leitura o arquivo: " + erro);
//            return false;
//        }
//
//        //contactorRepository.saveAll(listaLida2);
//        //bd.saveAll(listaLida);
//        System.out.println("\nConteúdo da lista lida:");
//        for (ProjectModel projectModel : listaLida){
//            System.out.println(projectModel);
//        }
//        for (Contactor contactor : listaLida2){
//            System.out.println(contactor);
//        }
//        return true;
//    }
}
