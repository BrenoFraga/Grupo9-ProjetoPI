import FindrInput from "../components/findr-input";
import "../styles/findr-cadastro-style.css"
import api from '../api';
import React, { useState } from 'react';


function CadastroContratante() {

    const [nameInput, setNameInput] = useState("");
    const [cpfInput, setCpfInput] = useState("");
    const [emailInput, setEmailInput] = useState("");
    const [telefoneInput, setTelefoneInput] = useState("");
    const [senhaInput, setSenhaInput] = useState("");
    const [nacionalidadeInput, setNacionalidadeInput] = useState("");
    const [estadoInput, setEstadoInput] = useState("");
    const [cidadeInput, setCidadeInput] = useState("");
    const [tempoInput, setTempoInput] = useState("");
    const [planoInput, setPlanoInput] = useState("");

    function postUser(e) {
        e.preventDefault();

        const objContactor = {
        name: nameInput,
        email: emailInput,
        password: senhaInput,
        cpf: cpfInput,
        cnpj: cpfInput,
        phoneContact: telefoneInput,
        country: nacionalidadeInput,
        state: estadoInput,
        city: cidadeInput,
        idContactor: "",
        fkPlanContactor: {
            idPlan: planoInput,
            planType: "",
            quantityClicks: ""
        }
    }

        const loginPost = { 
            nameUser: nameInput, 
            password: senhaInput 
        }
    
        api.post("contactor", objContactor).then(res => {
            alert("cadastrado com sucesso!");
            sessionStorage.setItem("user", nameInput);
            window.location.href="/login";
        }).catch(erro => {
            alert("Erro no cadastro!");
            console.log(erro);
        })
    }

    return (
        <>
            <div class="ajuste-tela">
                <div className="container-content-form">
                    <img src="https://images.pexels.com/photos/3201585/pexels-photo-3201585.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" alt="" />

                    <div className="container-inputs">
                        <div className="text-input">
                            <p>Crie sua conta de freelancer e encontre projetos de forma rápida e prática</p>
                        </div>
                        <form onSubmit={postUser} className="form-inputs">
                            <div class="individual-input-cadastro">
                                <p>Nome:</p>
                                <input type="text" value={nameInput} onChange={((event) => {
                                    setNameInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>CNPJ:</p>
                                <input type="text" value={cpfInput} onChange={((event) => {
                                    setCpfInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>E-mail:</p>
                                <input type="text" value={emailInput} onChange={((event) => {
                                    setEmailInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>Telefone:</p>
                                <input type="text" value={telefoneInput} onChange={((event) => {
                                    setTelefoneInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>Senha:</p>
                                <input type="password" value={senhaInput} onChange={((event) => {
                                    setSenhaInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>Confirmar senha:</p>
                                <input type="password" />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>Nacionalidade</p>
                                <input type="text" value={nacionalidadeInput} onChange={((event) => {
                                    setNacionalidadeInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>Estado:</p>
                                <input type="text" value={estadoInput} onChange={((event) => {
                                    setEstadoInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>Cidade</p>
                                <input type="text" value={cidadeInput} onChange={((event) => {
                                    setCidadeInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>Tempo disponível (em horas):</p>
                                <input type="text" value={tempoInput} onChange={((event) => {
                                    setTempoInput(event.target.value)
                                })} />
                            </div>
                            <div class="individual-input-cadastro">
                                <p>Plano:</p>
                                <input type="text" value={planoInput} onChange={((event) => {
                                    setPlanoInput(event.target.value)
                                })} />
                            </div>
                            <br />
                            <div className="text-acceptance">
                                <h3 className='i-acceptance'> <input type="checkbox" id="checkbox-accept" /> Eu aceito os termos de uso</h3>
                                <button type='submit' id="signInButton">Cadastrar</button>
                                <h4 className='login-here'>Já tem conta? Faça o login <a href="#">aqui</a> </h4>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    );
}

export default CadastroContratante;