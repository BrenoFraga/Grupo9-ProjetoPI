import FindrMenu from "../components/findr-menu"
import api from "../api";
import "../styles/findr-dashboard-freeCon.css"
import { Chart } from 'primereact/chart';
import React, { useEffect, useState } from 'react';
import axios from "axios";


function DashboardFreelancer() {

    const [countMatchs, setCountMatchs] = useState();
    const [countlike, setCountLike] = useState();
    const [cidade, setCidade] = useState()

    useEffect(() => {
        api.get('/match/freelancer/' + sessionStorage.idUsuario).then(res => {
            setCountMatchs(res.data.length)
        }).catch(erro => {
            console.log(erro)
        })    
    }, [])

    useEffect(() => {
        api.get('dashboard/count-likes-freelancer').then(res => {
            setCountLike(res.data)
        }).catch(erro => {
            console.log(erro)
        })    
    }, [])

    useEffect(() => {
        api.get('/freelancer/state/' + sessionStorage.idUsuario).then(res => {
            
        }).catch(erro => {
            console.log(erro)
        })    
    }, [])


    useEffect(() => {
        api.get('/like/get/like-freelancer/recebidos/' + sessionStorage.idUsuario ).then(res => {
            console.log("likeRecebidoFreelancer", res)
        }).catch(erro => {
            console.log(erro)
        })
    }, [])

    useEffect(() => {
        api.get('/like/get/like-freelancer/enviados/' + sessionStorage.idUsuario ).then(res => {
            console.log("likeEnviadoFreelancer", res)
        }).catch(erro => {
            console.log(erro)
        })
    }, [])


    let basicOptions = {
        maintainAspectRatio: false,
        aspectRatio: .6,
        plugins: {
            legend: {
                labels: {
                    color: '#495057'
                }
            }
        },
        scales: {
            x: {
                ticks: {
                    color: '#495057'
                },
                grid: {
                    color: '#ebedef'
                }
            },
            y: {
                ticks: {
                    color: '#495057'
                },
                grid: {
                    color: '#ebedef'
                }
            }
        }
    };

    const [lineStylesData] = useState({
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [
            {
                label: 'Like Dado',
                data: [65, 59, 80, 81, 56, 55, 40],
                fill: false,
                borderColor: '#4B1ECB',
                tension: .4,
            },
            {
                label: 'Like Recebido',
                data: [12, 51, 62, 33, 21, 62, 45],
                fill: false,
                borderColor: '#FFA726',
                tension: .4,
            }
        ]
    });

    return (
        <div className="container-dashboard-freeCon">
            <FindrMenu />
            <div className="grafics-analytics-freeCon">
                <div className="card-info-freeCon">
                    <div className="card-match-freeCon">
                        <span class="title-card-freeCon-match">Quantidade de matchs</span>
                        <span class="info-card-freeCon-match">{countMatchs}</span>
                    </div>
                    <div className="card-empresas-freeCon">
                        <span className="title-card-freeCon-empresa">Quantidade de likes</span>
                        <span className="info-card-freeCon-empresa">{countlike}</span>
                    </div>
                    <div className="card-local-freeCon">
                        <span className="title-card-freeCon-local">Localidade das empresas que <br></br> mais deram matchs</span>
                        <span className="info-card-freeCon-local">{cidade}</span>
                    </div>
                </div>
                <div class="grafics-line-freeCon">
                    <div class="color-high"></div>
                    <div class="title-grafic-line">Like do seu perfil</div>
                    <span class="paragro-grafic-info">Quem deu like no seu perfil no últimos 90 dias</span>
                    <div className="color-mid"></div>
                    <div class="filters">
                        <select class="empresa">
                            <option value="">Empresa</option>
                        </select>
                        <select class="localidade">
                            <option value="">Localidade</option>
                        </select>
                        <div className="color-division"></div>
                        <select class="filter-all">
                            <option value="">Todos os filtros</option>
                        </select>
                    </div>
                    <div className="color-mid"></div>
                    <div class="grafic-line-viu">
                        <div class="grafic-line-color">
                            <div class="title-vizu-grafic">
                                <span class="info-vizu">Likes dados X Likes Recebidos</span>
                            </div>
                            <Chart class="chart-line-vizu" type="line" data={lineStylesData} options={basicOptions} style={{ height: '290px', width: '95%'}}/>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    )
};


export default DashboardFreelancer;