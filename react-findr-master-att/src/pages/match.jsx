import FindrMenu from "../components/findr-menu"
import '../styles/findr-match-style.css'
import { useEffect } from "react";
import { useState } from "react";
import CardTelaMatch from "../components/component-tela-match/card-tela-match";
import api from "../api";
import * as React from 'react';

function FindrMatch() {
    const [infoProjects, setProject] = useState([]);
    const [selectedIndex, setSelectedIndex] = useState(0);

    useEffect(() => {
        api.get(`project`).then((res) => {
            setProject(res.data);
            console.log(res.data)
        }).catch((err) => {
            console.log(err);
        })
    }, [])

    const handleAccept = () => {
        const project = infoProjects[selectedIndex];
        api.post('/like/freelancer/' + sessionStorage.idUsuario + '/' + project.fkContactor.idContactor + '/true/')
        .then(res => {
            setSelectedIndex(selectedIndex + 1);
            alert("Você deu Like no projeto " + project.nameProject)
        })
    }

    const handleRefuse = () => {
            setSelectedIndex(selectedIndex + 1);
    }


    const renderProject = () => {
        const project = infoProjects[selectedIndex];

        if (project === undefined) {
            return (
                <span>Sem projeto atualize a pagina</span>
            )
        }

        return (
            <CardTelaMatch 
                name = {project.name}
                descriptionProject = {project.descriptionProject}
                requiredArea = {project.requiredArea}
                requiredLanguages = {project.requiredLanguages}
                onAccept={handleAccept}
                onRefuse={handleRefuse}
            />
        )
    }

    return (
        <div className="container-match">
            <FindrMenu />
            <div className="content-match">
                {renderProject()}
            </div>
        </div>
    );
}

export default FindrMatch;