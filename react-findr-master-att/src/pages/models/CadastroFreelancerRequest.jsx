export default class CadastroFreelancerRequest{
    constructor(name, email, password, cpf, cnpj, phoneContact, country, state, city, avaliableTime, fkPlanFreelancer){
        this.name = name
        this.email = email
        this.password = password
        this.cpf = cpf
        this.cnpj = cnpj
        this.phoneContact = phoneContact
        this.country = country
        this.state = state
        this.city = city
        this.avaliableTime = avaliableTime
        this.fkPlanFreelancer = fkPlanFreelancer
    }
}