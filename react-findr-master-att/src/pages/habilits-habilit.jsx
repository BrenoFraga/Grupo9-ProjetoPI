import FindrMenu from "../components/findr-menu";
import "../styles/findr-habilits-habilit-style.css"
import { useState } from "react";
import api from "../api";


function HabilitsHabilit() {


    const [habilitSpecialtyInput, setHabilitSpecialtyInput] = useState("");
    const [levelKnowledgeInput, setlevelKnowledgeInput] = useState();
    const [ocupationAreaInput, setOcupationAreaInput] = useState("");

    function postSpecialtyFreelancer(e) {
        e.preventDefault();


        const objSpecialty = {
            ocupationArea: ocupationAreaInput,
            technologyUsed: habilitSpecialtyInput,
            levelKnowledge: levelKnowledgeInput,
            fkFreelancer: {
                idUserFreelancer: sessionStorage.idUsuario,
            }
        }

        api.post("specialty", objSpecialty).then(res => {
            console.log(res)
            alert("cadastrado com sucesso!");
        }).catch(erro => {
            alert("Erro no cadastro!");
            console.log(objSpecialty)
            console.log(erro);
        })
    }



    return (
        <div class="container-habilit">
            <FindrMenu />
            <form onSubmit={postSpecialtyFreelancer}>
                <div class="content-habilit">
                    <div class="habilits-freelancer">
                        <h2>Cadastro de Habilidades</h2>
                        <div class="habilits-freelancer-select">
                            <select onChange={((event) => habilitSpecialtyInput(event.target.value))}>
                                <option value={''} hidden="true" default="true">Selecione uma habiliade</option>
                                <option value={'Java'}>Java</option>
                                <option value={'Kotlin'}>Kotlin</option>
                                <option value={'JavaScript'}>Java Script</option>
                                <option value={'SpringBoot'}>Spring Boot</option>
                                <option value={'MySQL'}>MySQL</option>
                                <option value={'React'}>React</option>
                                <option value={'Angular'}>Angular</option>
                                <option value={'Viws'}>View</option>
                                <option value={'UX'}>UX</option>
                                <option value={'UI'}>UI</option>
                                <option value={'TypeScript'}>TypeScript</option>
                                <option value={'PHP'}>PHP</option>
                                <option value={'Python'}>Python</option>
                                <option value={'C#'}>C#</option>
                                <option value={'C++'}>C++</option>
                                <option value={'Ruby'}>Ruby</option>
                                <option value={'jQuery'}>jQuery</option>
                                <option value={'Vue'}>Vue</option>
                            </select>
                        </div>

                        <div class="level-habilits-freelancer">
                            <div class="title-free">NÍVEL DE HABILIDADE</div>

                            <div class="type-levels-free">

                                <div className="level-beginner-free">
                                    <input type="radio" name="levelKnowledgeInput" onChange={e => setlevelKnowledgeInput(e.target.value)} />
                                    <p>Iniciante</p>
                                </div>

                                <div class="level-intermediary-free">
                                    <input type="radio" name="levelKnowledgeInput" onChange={e => setlevelKnowledgeInput(e.target.value)} />
                                    <p>Intermediário</p>
                                </div>

                                <div class="level-advanced-free">
                                    <input type="radio" name="levelKnowledgeInput" onChange={e => setlevelKnowledgeInput(e.target.value)} />
                                    <p>Avançado</p>
                                </div>

                            </div>

                            {/* <div class="button-registration-habilit-free">
                            <button>Cadastrar habiliade</button>
                        </div> */}

                            {/* <div class="habilits-with-level-free">
                            <div class="habiit-content-free">
                            <span class="habilit-level-free">Java(Iniciante)</span>
                            </div>
                        </div> */}

                            <div class="ocupation-area">
                                <p>Àrea que deseja atuar</p>
                                <input type="text" value={ocupationAreaInput} onChange={((event) => {
                                    setOcupationAreaInput(event.target.value)
                                })} />
                            </div>

                            {/* <div class="description-project-free">
                            <p>Descreva seus conhecimentos</p>
                            <div class="description-free">
                                <textarea></textarea>
                            </div>
                        </div> */}
                        </div>
                    </div>


                    <div class="info-user-freelancer">
                        <div class="info-user-freelancer-content">
                            <h1>Olá, {sessionStorage.nomeUsuario}!</h1>
                            <p>Conte-nos um pouco mais sobre os projetos que você possui</p>
                        </div>

                        <div class="btn-freelancer">
                            <button>Freelancer</button>
                        </div>

                        <div class="btn-cadastrar-free">
                            <button>Cadastrar</button>
                        </div>
                    </div>



                </div>
            </form>
        </div>
    )
}


export default HabilitsHabilit;