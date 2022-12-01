import FindrMenu from "../components/findr-menu"
import api from "../api";
import "../styles/findr-dashboard-freeCon.css"
import { Chart } from 'primereact/chart';
import React, { useEffect, useState } from 'react';
import axios from "axios";


function DashboardFreelancer() {

    const [countMatchs, setCountMatchs] = useState();
    const [countlike, setCountLike] = useState();
    const [likesDadosFree, setLikesDadosFree] = useState([]);
    const [dateFree, setDateFree] = useState([]);
    const [stateMatch, setStateMatch] = useState("");


    useEffect(() => {
        api.get('/like/data-like-freelancer/' + sessionStorage.idUsuario).then(resp => {
            console.log("resp", resp)
            var listaData = []
            var listLikesDados = []
            resp.data.map(
                (item) => {
                    listaData.push(item.data);
                    listLikesDados.push(item.fk)
                }
            )
            console.log("listaData", listaData)
            console.log("listLikesDados", listLikesDados)
            setDateFree(listaData)
            setLikesDadosFree(listLikesDados)
            setLineStylesDataFree({
                labels: dateFree,
                datasets: [
                    {
                        label: 'Likes Dados',
                        data: likesDadosFree,
                        fill: false,
                        borderColor: '#4B1ECB',
                        tension: .4,
                    }
                ]
            })
        })
    }, [])

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
            setStateMatch(res.data[0].toUpperCase())
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

    const [lineStylesDataFree, setLineStylesDataFree] = useState({
        labels: [],
        datasets: [
            {
                label: 'Likes Dados',
                data: [],
                fill: false,
                borderColor: '#4B1ECB',
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
                        <span className="info-card-freeCon-local">{stateMatch}</span>
                    </div>
                </div>
                <div class="grafics-line-freeCon">
                    <div class="color-high"></div>
                    <div class="title-grafic-line">Like do seu perfil</div>
                    <span class="paragro-grafic-info">Quem deu like no seu perfil nos últimos dias</span>
                    {/* <div className="color-mid"></div> */}
                    {/* <div class="filters">
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
                    </div> */}
                    <div className="color-mid"></div>
                    <div class="grafic-line-viu">
                        <div class="grafic-line-color">
                            {/* <div class="title-vizu-grafic">
                                <span class="info-vizu">Likes dados</span>
                            </div> */}
                            <Chart class="chart-line-vizu" type="line" data={lineStylesDataFree} options={basicOptions} style={{ height: '290px', width: '95%'}}/>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    )
};


export default DashboardFreelancer;