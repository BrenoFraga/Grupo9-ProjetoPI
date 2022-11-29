import FindrMenu from "../components/findr-menu";
import * as React from 'react';
import CardMatch from "../components/component-tela-perfil/match/card-match";
import "../styles/findr-perfil-free-style.css";
import { useEffect } from "react";
import { useState } from "react";
import api from "../api";
import CardPerfil from "../components/component-tela-perfil/card-perfil";

function Perfil() {

    const [matchs, setMatchs] = useState([]);
    const [infoUser, setInfoUser] = useState([]);

    useEffect(() => {

        api.get(`/match/projetos/${sessionStorage.idUsuario}`).then((res) => {
            console.log(res.data)
            if (res == null) {
                setMatchs(res.data.null);
            } else {
                setMatchs(res.data);
            }
            console.log(res.data)
        }).catch((err) => {
            console.log(err);
        })

    }, [])

    useEffect(() => {

        api.get(`/freelancer/perfil/${sessionStorage.email}`).then((res) => {
            setInfoUser(res.data);
            console.log(res.data)
        }).catch((err) => {
            console.log(err);
        })

    }, [])

    return (
        <div class="screen-perfil">
            <FindrMenu />

            <div class="screen2">
                {
                    <CardPerfil
                        name={infoUser.name}
                        state={infoUser.state}
                        city={infoUser.city}
                        technologyUsed={infoUser.technologyUsed}
                    />
                }

                <div class="screen3">
                    <div className="matchs">
                        <h1>Matchs</h1>
                        <div className="container">
                            <div className="grid-container">
                                {matchs.map((item) => <CardMatch name={item.name} nameProject={item.nameProject} />)}
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default Perfil;