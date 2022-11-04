import Efect1 from "../../imgs/efects1.png";
import Efect2 from "../../imgs/efects2.png";
import "../component-tela-perfil/card-perfil.css"
import { useState } from "react";

function CardPerfil(props) {
    const [name, setName] = useState(props.name)
    const [state, setState] = useState(props.state)
    const [city, setCity] = useState (props.city)
    const [technologyUsed, setTechnologyUsed] = useState(props.technologyUsed)


    return (
        <>
            <div class="card-perfil">
                <div class="enfeite1">
                    <img src={Efect1} alt="" />
                </div>
                <div class="card-perfil-info">
                    <div class="img-freelancer-perfil">
                        <img src="data:image/png;base64,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" alt="" />
                    </div>
                    <h3>{props.name}</h3>

                    <div class="card-info-dev-perfil">
                        <p>{sessionStorage.email}<img src="https://i.pinimg.com/originals/8f/c3/7b/8fc37b74b608a622588fbaa361485f32.png" alt=""/></p>
                    </div>
                    <div class="card-info-dev-perfil">
                        <p>{props.state},{props.city}<img src="https://png.pngtree.com/png-vector/20210216/ourlarge/pngtree-location-icon-in-flat-style-png-image_2914820.jpg" alt="" /></p>
                    </div>
                </div>
                <div class="enfeite2">
                    <img src={Efect2} alt="" />
                </div>
            </div>
        </>
    )
}

export default CardPerfil;