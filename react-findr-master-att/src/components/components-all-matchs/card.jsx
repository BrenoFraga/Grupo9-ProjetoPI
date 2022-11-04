import './card.css'

export function CardMatch(){
    return(
       <div className='card'>
            <div className='container-image'>
                <div className='image-content'><img className='user-image' src="https://pbs.twimg.com/media/E2aHd4LXwAA23uY.jpg" alt="" /></div>
                <div className='container-level-tec'>
                    <h5>Nivel da habilidade :</h5>
                    <div className='container-hab-change'>
                        <div className='level-hability'></div>
                    </div>
                    
                </div>
            </div>
            <div className='container-freelancer-content'>
                <div className='container-name-freelancer'>
                    <h2>Luiz Inácio Lula da Silva</h2>
                </div>
                <div className='container-email-freelancer'>
                    <div className='icon-email'><img src="https://cdn-icons-png.flaticon.com/512/561/561127.png " alt="" /></div>
                    <h3 className='string-email'>lula.silva@gmail.com</h3>
                </div>
                <div className='container-cidade-freelancer'>
                <div className='icon-loc'><img src="https://cdn-icons-png.flaticon.com/512/1479/1479518.png " alt="" /></div>
                    <h3>SP, Brazil</h3>
                </div>
                <div className='container-nome-habilidade-freelancer'>
                    <div className='icon-hab'><img src="data:image/png;base64,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 " alt="" /></div>
                    <h3>Javascript</h3>
                </div>
                
                <div className='container-data-match-freelancer'>
                    <h3>Data do match : 23/05/2022</h3>
                </div>      
            </div>
            <div className='container-exit'>
                <div className='container-icon-close'><img src="https://cdn-icons-png.flaticon.com/512/95/95068.png " alt="" /></div>
            </div>
       </div>
    )
}

