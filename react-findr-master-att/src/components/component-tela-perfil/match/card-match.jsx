import React, { useState } from 'react';
import "../match/card-match.css"

function CardMatch(props) {
    const [name, setName] = useState(props.name)
    const [nameProject, setNameProject] = useState(props.nameProject)

    return (
        <>
            <div className="grid-tem">
                <div className="match-info-pessoa">
                    <img src="https://ofuroquerobanho.com.br/wp-content/uploads/2018/04/projeto-icon.png" alt="" />

                    <p>{name}</p>

                    <p>{nameProject}</p>
                </div>
            </div>
        </>
    )

}

export default CardMatch;