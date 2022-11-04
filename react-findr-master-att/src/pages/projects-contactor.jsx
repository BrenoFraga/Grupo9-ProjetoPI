import '../styles/projects-contactor.css'
import FindrMenuAdmin from "../components/findr-menu-admin";
import {CardProject} from "../components/component-tela-projetos/card-project"

function ProjectsContactor(){

    return(
       <div className='container-all-content-projects'>
        <FindrMenuAdmin />
        <div className='container-content-projects'>
        <div className="container-title-projects">
                <h1>Seus Projetos</h1>
            </div>
        <div className='info-all-projects'>
            <div className='card-projects'>
                <CardProject/>
                <CardProject/>
                <CardProject/>
                <CardProject/>
                <CardProject/>
                <CardProject/>
            </div>
            <div className='description-projects'>
                <div className='container-foto-projeto'>
                    <div className='cont-fot'>
                        <div className='imagem'>
                            <img src="https://pbs.twimg.com/media/E2aHd4LXwAA23uY.jpg" alt="" />
                        </div>
                        <div className='edit-imagem'>
                            <div className='imagem-editar'><img src='https://w7.pngwing.com/pngs/740/67/png-transparent-computer-icons-icon-design-edit-angle-computer-data-thumbnail.png '/>  </div>
                        </div>
                    </div>
                    <div className='cont-data'></div>
                    <div className='cont-exit'></div>
                    </div>   
                    <div className='container-all-desc-content'></div> 
            </div>
            </div> 
            <div className='container-button-add-project'>
                <button>Cadastrar Projeto</button>
            </div>
        
        </div>
       </div>
    )
}

export default ProjectsContactor