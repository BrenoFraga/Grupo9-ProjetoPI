import FindrMenuAdmin from "../components/findr-menu-admin";
import "../styles/findr-dashboard.css"
import api from "../api";
import { Card } from 'primereact/card';
import { Chart } from 'primereact/chart';
import React, { useState } from 'react';
import { useEffect } from "react";
import { ProgressBar } from 'primereact/progressbar';
import { CircularProgressbar } from 'react-circular-progressbar';
import  'react-circular-progressbar/dist/styles.css' ;
import { QrCodeScannerOutlined } from "@mui/icons-material";
import { red } from "@material-ui/core/colors";
import axios from "axios";


function Dashboard(){

    
    const[countContactor, setCountContactor] = useState();
    const[countFreelancer, setCountFreelancer] = useState();


    const[technologyFreelancer, setTechnologyFreelancer] = useState([]);

    const [tecnologia1, setTecnologia1] = useState({
        technologyUsed: "",
        tecnologias: 0
    })

    const [tecnologiaProject, setTecnologiaProject] = useState({
        requiredLanguages: "",
        tecUsada: 0
    })

    
    useEffect(() => {
        axios.get('http://localhost:8080/contactor/total-contactor')
        .then(response =>{
            console.log(response.data)
            if(response == null){
                this.state.matchs = null
            }else{
                this.setState({items : response.data})
            }
    
        }).catch(error =>{
            console.error(error.response)
        })
    }, [])
    
    useEffect(() => {
        axios.get(`http://localhost:8080/freelancer/total-freelancer`).then(res => {
            setCountFreelancer(res.data)
            console.log(res.data)
        })
    }, [])
        


    const [linguagem1, setLinguagem1] = useState("");
    const [linguagem2, setLinguagem2] = useState("");
    const [linguagem3, setLinguagem3] = useState("");
    const [linguagem4, setLinguagem4] = useState("");
    const [linguagem5, setLinguagem5] = useState("");
    const [linguagem6, setLinguagem6] = useState("");
    const [linguagem7, setLinguagem7] = useState("");
    const [linguagem8, setLinguagem8] = useState("");
    const [linguagem9, setLinguagem9] = useState("");
    const [linguagem10, setLinguagem10] = useState("");


    useEffect(() => {
        api.get(`/project/required/languages`).then((res) =>{
            setLinguagem1(res.data[0].requiredLanguages)
            setLinguagem2(res.data[1].requiredLanguages)
            setLinguagem3(res.data[2].requiredLanguages)
            setLinguagem4(res.data[3].requiredLanguages)
            setLinguagem5(res.data[4].requiredLanguages)
            setLinguagem6(res.data[5].requiredLanguages)
            setLinguagem7(res.data[6].requiredLanguages)
            setLinguagem8(res.data[7].requiredLanguages)
            setLinguagem9(res.data[8].requiredLanguages)
            setLinguagem10(res.data[9].requiredLanguages)
            
            

            setTecnologiaProject(res.data)
            setData({
                datasets: [
                    {
                        data: [
                            res.data[0].tecUsada,
                            res.data[1].tecUsada,
                            res.data[2].tecUsada,
                            res.data[3].tecUsada,
                            res.data[4].tecUsada,
                        ],
                        backgroundColor: [
                            "#FF6384",
                            "#36A2EB",
                            "#FFCE56",
                            "#b4041e",
                            "#feb267"
                        ],
                        hoverBackgroundColor: [
                            "#FF6384",
                            "#36A2EB",
                            "#FFCE56",
                            "#b4041e",
                            "#feb267"
                        ]
                    }]
            })
        })
    }, [])

    const [specialty1, setSpecialty1] = useState("")
    const [specialty2, setSpecialty2] = useState("")
    const [specialty3, setSpecialty3] = useState("")
    const [specialty4, setSpecialty4] = useState("")
    const [specialty5, setSpecialty5] = useState("")


    useEffect(() => {
        api.get(`/specialty/required/specialty`).then((res) =>{     

            setSpecialty1(res.data[0].technologyUsed)
            setSpecialty2(res.data[1].technologyUsed)
            setSpecialty3(res.data[2].technologyUsed)
            setSpecialty4(res.data[3].technologyUsed)
            setSpecialty5(res.data[4].technologyUsed)
            setTecnologia1(res.data)
            setDataTwo({
                datasets: [
                    {
                        data: [
                            res.data[0].tecnologias, 
                            res.data[1].tecnologias, 
                            res.data[2].tecnologias, 
                            res.data[3].tecnologias, 
                            res.data[4].tecnologias
                        ],
                        backgroundColor: [
                            "#FF6384",
                            "#36A2EB",
                            "#FFCE56",
                            "#b4041e",
                            "#feb267"
                        ],
                        hoverBackgroundColor: [
                            "#FF6384",
                            "#36A2EB",
                            "#FFCE56",
                            "#b4041e",
                            "#feb267"
                        ]
                    }]
            });
        })
    }, [])

    
        
    var meta = 200
    var metaUsuario = 400
    var countUsuarios = countContactor + countFreelancer;
    var progressBarUsuarios = countUsuarios / metaUsuario * 100;
    


    const [chartData, setData] = useState({
        datasets: [
            {
                data: [],
                backgroundColor: [
                    "#FF6384",
                    "#36A2EB",
                    "#FFCE56",
                    "#b4041e",
                    "#feb267"
                ],
                hoverBackgroundColor: [
                    "#FF6384",
                    "#36A2EB",
                    "#FFCE56",
                    "#b4041e",
                    "#feb267"
                ]
            }]
    });

    const [chartDataTwo, setDataTwo] = useState({
        datasets: [
            {
                data: [],
                backgroundColor: [
                    "#FF6384",
                    "#36A2EB",
                    "#FFCE56",
                    "#b4041e",
                    "#feb267"
                ],
                hoverBackgroundColor: [
                    "#FF6384",
                    "#36A2EB",
                    "#FFCE56",
                    "#b4041e",
                    "#feb267"
                ]
            }]
    });

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
        labels: ['janeiro','fevereiro','marco','abril','maio','junho','julho','agosto','setembro','outubro','novembro','dezembro'],
        datasets: [
            {
                label: 'Usuário/mês',
                data: [12, 51, 62, 33, 21, 62, 45,80,13,50,45,70],
                fill: true,
                borderColor: '#4B1ECB',
                tension: .4,
                backgroundColor: '#4c1ecb44'
            }
        ]
    });

    const [lightOptions] = useState({
        plugins: {
            legend: {
                labels: {
                    color: '#495057'
                }
            }
        }
    });


    return (
        <div class="container-dashboard">
             <FindrMenuAdmin />
             <div class="grafics-analytics">
                <div class="card-info">
            
                    <div class="second-card-users">
                        <span class="title-card">Usuários</span>
                        <div class="infos-atual-meta">
                            <div class="info-data-atual">
                                <span>200</span>
                                <p>Atual</p>
                            </div>
                            <div class="split">|</div>
                            <div class="info-data-meta">
                                <span>400</span>
                                <p>Meta</p>
                            </div>   
                        </div>
                        <ProgressBar value={50} style={{width: '80%', marginLeft: 'auto', marginRight: 'auto', marginTop: '20px'  }}/>
                    </div>
                    <div class="third-card-projects">
                        <span class="title-card">Contratantes</span>
                        <span class="info-card">{100}</span>
                        <span class="info-card">{30}</span>
                        <CircularProgressbar  style={{marginBottom : "30px"}} value={30} text={`${50}%`} />
                    </div>
                    <div class="fourth-card-likes">
                        <span class="title-card">Freelancers</span>
                        <span class="info-card">{100}</span>
                        <CircularProgressbar  value={50} text={`${50}%`} />
                    </div>
                </div>
                <div class="grafics">
                    <div class="info-grafics">
                        <div class="title-grafics-doughnut-chart">
                            <span>Linguagens</span>
                            <div class="grafics-doughnut-chart">


                                <div class="doughnut-contratante">
                                    <div class="doughnut-contratante-data">
                                        <Chart type="doughnut" data={chartData} options={lightOptions} style={{ position: 'relative', width: '60%' }} />
                                        <div className="title-doughnut-data">
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#FF6384' }}></span>
                                                <span>{linguagem1}</span>
                                            </div>
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#36A2EB'}}></span>
                                                <span>{linguagem2}</span>
                                            </div>
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#FFCE56'}}></span>
                                                <span>{linguagem3}</span>
                                            </div>
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#b4041e'}}></span>
                                                <span>{linguagem4}</span>
                                            </div>
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#feb267'}}></span>
                                                <span>{linguagem5}</span>
                                            </div>  
                                        </div>
                                    </div>
                                    <p>Contratante</p>
                                </div>

                                <div class="doughnut-freelancer">
                                    <div class="doughnut-freelancer-data">
                                        <Chart type="doughnut" data={chartDataTwo} options={lightOptions} style={{ position: 'relative', width: '60%' }} />
                                        <div className="title-doughnut-data">
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#FF6384' }}></span>
                                                <span>{specialty1}</span>
                                            </div>
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#36A2EB'}}></span>
                                                <span>{specialty2}</span>
                                            </div>
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#FFCE56'}}></span>
                                                <span>{specialty3}</span>
                                            </div>
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#b4041e'}}></span>
                                                <span>{specialty4}</span>
                                            </div>
                                            <div class="title-doughnut">
                                                <span class="title-color" style={{ backgroundColor: '#feb267'}}></span>
                                                <span>{specialty5}</span>
                                            </div>  
                                        </div>
                                    </div>
                                    <p>Freelancer</p>
                                </div>
                            </div>
                        </div>
                        <div class="grafics-line-chart">
                            <Chart type="line" data={lineStylesData} options={basicOptions} style={{ height: '290px', width: '95%'}}/>
                        </div>
                    </div>
                    <div class="list-required-area">
                        <p>TOP 10 -Linguagens mais requisitadas:</p>
                        <div class="top-required-area">
                            <span>1. {linguagem1}</span>
                            <span>2. {linguagem2}</span>
                            <span>3. {linguagem3}</span>
                            <span>4. {linguagem4}</span>
                            <span>5. {linguagem5}</span>
                            <span>6. {linguagem6}</span>
                            <span>7. {linguagem7}</span>
                            <span>8. {linguagem8}</span>
                            <span>9. {linguagem9}</span>
                            <span>10. {linguagem10}</span>
                            
                        </div>
                    </div>

                </div>
                
                <div className="container-analytcs">
                <h1>Analytcs</h1>
                    <iframe
                    id="frameEspecificacoes"
                    src="http://34.200.19.241:9000/model.html"
                    width="100%" 
                    height="100%"
                    style={{border: "none",
                        overflow: "hidden"}}
                    >

                    </iframe>
                </div>
             </div>


        </div>
    );

}


export default Dashboard;