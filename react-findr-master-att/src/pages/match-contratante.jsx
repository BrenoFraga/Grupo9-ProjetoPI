import FindrMenu from "../components/findr-menu"
import '../styles/findr-match-style.css'
import { useEffect } from "react";
import { useState } from "react";
import CardTelaMatchContratante from "../components/component-tela-match/card-tela-match-contactor";
import api from "../api";
import * as React from 'react';

function FindrMatchContratante() {
    const [infoFreelancer, setFreelancer] = useState([]);
    const [selectedIndex, setSelectedIndex] = useState(0);
    useEffect(() => {
        api.get(`specialty`).then((res) => {
            setFreelancer(res.data);
            console.log(res.data)
        }).catch((err) => {
            console.log(err);
        })
    }, [])


    const handleAccept = () => {
        const freelancer = infoFreelancer[selectedIndex];
        api.get('freelancer')
        .then(res => {

        })
        api.post('/like/freelancer/' + sessionStorage.idContactor + '/' + freelancer.fkFreelancer.idUserFreelancer + '/true/')
        .then(res => {
            setSelectedIndex(selectedIndex + 1);
            alert("Você deu Like no Freelancer " + freelancer.fkFreelancer.name)
        })
    }

    const handleRefuse = () => {
            setSelectedIndex(selectedIndex + 1);
    }


    const renderFreelancer = () => {
        const freelancer = infoFreelancer[selectedIndex];

        if (freelancer === undefined) {
            return (
                <span>Sem freelancers atualize a pagina</span>
            )
        }

        return (
            <CardTelaMatchContratante 
                name = {freelancer.fkFreelancer.name}
                ocupationArea = {freelancer.ocupationArea}
                tecnologias = {freelancer.technologyUsed}
                disponibilidade = {freelancer.fkFreelancer.avaliableTime}
                onAccept={handleAccept}
                onRefuse={handleRefuse}
            />
        )
    }

    return (
        <div className="container-match">
            <FindrMenu />
            <div className="content-match">
                {renderFreelancer()}
            </div>
        </div>
    );
}

export default FindrMatchContratante;