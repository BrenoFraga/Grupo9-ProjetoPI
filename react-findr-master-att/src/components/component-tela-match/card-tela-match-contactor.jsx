import { useState } from "react";
import "../component-tela-match/card-tela-match.css"


function CardTelaMatch({ name, ocupationArea, tecnologias, disponibilidade, onAccept, onRefuse}) {
    return (
        <>
            <div className="button-align">
                <button className="button-accept" onClick={onAccept}>
                    <i className="pi pi-check" style={{'fontSize': '3em'}}/>
                </button>
            </div>
            <div className="match-information">
                <div className="imagea-usuario"></div>
                <div className="img-user-logado"></div>
                <div className="name-user">
                    <h3>{name}</h3>
                    <h3>Profissao</h3>
                    <p>{ocupationArea}</p>
                    <h3>Tecnologias</h3>
                    {tecnologias}
                    <div className="technologics">
                        <div className="tecnologics-and-levels">
                            <div className="tecnolgics-info">
                                <div className="imagem-tecno"></div>
                                <h3>Disponibilidade</h3>
                                <p>{disponibilidade}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="imagem-two"></div>
            </div>
            <div className="button-align">
                <button className="button-refused" onClick={onRefuse}>
                <i className="pi pi-times" style={{'fontSize': '3em'}}/>
                </button>
            </div>
        </>
    )
}

export default CardTelaMatch;