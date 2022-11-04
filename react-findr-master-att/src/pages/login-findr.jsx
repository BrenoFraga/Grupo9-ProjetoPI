import FindrInput from "../components/findr-input";
import '../styles/findr-login-page-style.css';
import React, { useState } from "react";
import { Link, useNavigate } from 'react-router-dom'
import Button from '@material-ui/core/Button';
import api from "../api";
import LoginRequest from "./models/LoginRequest";


function FindrLogin() {
    const [emailUser, setEmailUser] = useState('');
    const [password, setPassword] = useState('');
    const loginPost = { email: emailUser, password: password}
    const [loginInfo, setLoginInfo] = useState('');
    const [typeLogin, setTypeLoginRadio] = useState();


    const handleCallback = (childData) => {
        setLoginInfo(childData)
    }


    
    const navigate = useNavigate()
    
    function autenticar() {
        

        if(typeLogin === 'Freelancer'){
            api.post("freelancer/login", loginPost).then((resposta) => {
                console.log(resposta)
                if (resposta.status === 200) {
                    navigate('/habilits/habilit')
                    api.get(`/freelancer/perfil/${emailUser}`).then((resposta) => {
                        sessionStorage.idUsuario = resposta.data.idUserFreelancer;
                        sessionStorage.nomeUsuario = resposta.data.name;
                        sessionStorage.email = resposta.data.email;
                        sessionStorage.ocupationArea = resposta.data.ocupationArea;
                        sessionStorage.avaliableTime = resposta.data.avaliableTime;
                        sessionStorage.levelKnowledgeInput = resposta.data.levelKnowledgeInput
                    })
                }
                else if (resposta.status === 404) {
                    console.log("usuario incorreto!")
                    alert("Usuario e/ou senha incorreto")
                }
            })
        }else{
            api.post("contactor/login", loginPost).then((resposta) =>{
                console.log(resposta)
                if(resposta.status === 200){
                    navigate('/habilits/project')
                    api.get(`/contactor/perfil/email/${emailUser}`).then((resposta) =>{
                        sessionStorage.idContactor = resposta.data.idContactor;
                        sessionStorage.nomeUsuario = resposta.data.name;
                        sessionStorage.email = resposta.data.email;
                        sessionStorage.description = resposta.data.description;
                    })
                }
                else if (resposta.status === 404) {
                    console.log("usuario incorreto!")
                    alert("Usuario e/ou senha incorreto")
                }
            })
        }


    }

    return (
        <>
            <div className="logo-findr">
                <img src="https://i.imgur.com/DGkk638.png" alt="" className="logo" />
            </div>

            <div className="container-login-user">
                <img src="https://i.imgur.com/6vXui7e.png" alt="" id="imgLogin" />
                <div className="saudacao-usuario">
                    <h1>Login</h1>
                    <h3 className="text-greetings">Venha conectar-se em sua conta e venha usufruir de
                        nossos melhores produtos e análises</h3>
                    <input id="input_id" placeholder="Usuario" handleCallback={handleCallback} onInput={(evento) => { setEmailUser(evento.target.value) }} />
                    <br />
                    <input id="input_senha" placeholder="Senha" type="password" onInput={(evento) => { setPassword(evento.target.value) }} />
                    <br />
                    <div class="type-login">
                        <div class="type-freelancer">
                            <input type="radio" name="typeLogin" value="Freelancer" onChange={e=>setTypeLoginRadio(e.target.value)}/>
                            <p>Freelancer</p>
                        </div>
                        <div class="type-contratante">
                            <input type="radio" name="typeLogin" value="Contratante" onChange={e=>setTypeLoginRadio(e.target.value)}/>
                            <p>Contratante</p>
                        </div>
                    </div>
                    <button id="btn-click-login" onClick={() => autenticar()}>Fazer Login</button>
                    
                    <div className="password-options">
                        <a href="#" className="a-href-password">Esqueceu a senha?</a>
                        <a href="#" className="a-href-password">Recuperar Senha</a>
                    </div>
                    <p className="also-login">Também faça Login com:</p>
                    <div className="login-options">
                        <i className="pi pi-facebook"></i>
                        <i className="pi pi-twitter"></i>
                        <i className="pi pi-google"></i>
                    </div>
                </div>
            </div>
        </>

    );
}

export default FindrLogin;
