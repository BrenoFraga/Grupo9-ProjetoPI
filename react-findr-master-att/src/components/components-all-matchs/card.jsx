import axios from 'axios'
import { useEffect, useState } from 'react'
import './card.css'

export function CardMatch(props){
    const [id,setId] = useState(props.id)
    const [name, setName] = useState(props.name)
    const [email, setEmail] = useState(props.email)
    const [hability, setHability] = useState(props.hability)
    const [level, setLevel] = useState (props.level)
    const [dataMatch, setDataMatch] = useState(props.dataMatch)
    const [city, setCity] = useState(props.city)
    const [country, setCountry] = useState(props.country)
    const [image, setImage] = useState('')


    useEffect(() => {
        axios.get(`http://54.227.254.129:8080/freelancer/getImages/1`).then(res => {
            console.log(res.data)
            setImage(res.data)
        })
    }, [])

    return(

       <div className='card'>
            <div className='container-image'>
                <div className='image-content'>
                    <img className='user-image' src="https://findr-images.s3.us-east-1.amazonaws.com/24fcfe8b-5217-425d-9347-f7f0b81a8f54.jpeg?response-content-disposition=inline&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEDAaCXNhLWVhc3QtMSJHMEUCIQDgEiBOdJOiBjbpPaHL4cBaMSme87k4YTvnqLp4yoAbzwIgKU92RFJuHZcnTfX4kilcZK7h%2FlnNo6DBNG3DItf7RYQq9gIIORABGgw4NzU5NjcwOTM2MDYiDCLTsG4UeJcKcU%2FzcyrTAnw4sCg3boOTPIlOdCHpCqrVDRdqKF0GRHYNTpkP4d1xXZgTCQkDMtleNF1xUaWD2VSbdOlogNyqP1fMYnMs4LV5M6L72a8yU8ZK3rAFER5hGWkqHcjikoJV09O6bU7hgGEsEjOBG0%2BMma7zgoAijPxq4za4zrmMpVOOdCgDzrKHxNl54VcOrtd3O0Rt0U%2BrpJFN2qTdKvEIiOJM9GQ9i2FW83tcjIRSjlV%2FD%2F9CedPoFyD1cg6fhEpU%2BsG2PiGNyxwoLOIU%2Fj5SK3TVl7h5d4nOvlHwH7PkFaq%2FbjLr9K3YAaRMRhimSlqHw58DJDxQAMh123SznQbGA7cQFFk2%2B19Sholf2GY%2B6eaFc%2BH%2FJ9zsNRwyZkbwc6DlOymQOfEnyzkCjUMo3REVZGIWQCqrH5LzDopk7GwL08juzAfcq4tBMbkOSGRhLyNywWNm7krtZ0tl0zDtvNqbBjqHAg48ONUqxGa0jwBqcr9AsvsdNeZh%2F%2BKfVrtGIgVv4aZ%2F4iMw0GC0Iqv0alRj%2FCQuIrR2anDUki4hsfut2lX5tlIHAb6i7Z3LudDawjr2wzsXbO%2F9LmXZ45RJ1dpI347Oho0529bbihTJBmX7igmbUfpdfgQTe1gVux4OD9Rj9hTgugFpGcihVa3MFxmAjI5T80MqCA%2F51d4g39D9ObfXBWRB8hrL7SY5BqYJsnsvoK%2BaWSAeJPumoiN%2BI7xGqyHxLJznvFDYABv5P%2BvS5cqh4CmMHsJmEaDZYsQTa90i9f7iMqXxO0ruxLm9g1CVyXr%2FIxGTicKN%2BoRG9NX1gL72%2BOJPpw6%2FBEbH&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221118T000641Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIA4X45VDNTJ3KBFTI2%2F20221118%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=5031778ba3d5d174ccc785d3fd65fb0510360e3b9383f166733b541d9ebc2397" alt="" />
                </div>
                <div className='container-level-tec'>
                    <h5>Nivel da habilidade :</h5>
                    <div className='container-hab-change'>
                        <div className='level-hability'></div>
                    </div>

                </div>
            </div>
            <div className='container-freelancer-content'>
                <div className='container-name-freelancer'>
                    <h2>{props.name}</h2>
                </div>
                <div className='container-email-freelancer'>
                    <div className='icon-email'><img src="https://cdn-icons-png.flaticon.com/512/561/561127.png " alt="" /></div>
                    <h3 className='string-email'>{props.email}</h3>
                </div>
                <div className='container-cidade-freelancer'>
                <div className='icon-loc'><img src="https://cdn-icons-png.flaticon.com/512/1479/1479518.png " alt="" /></div>
                    <h3>{props.city},{props.country}</h3>
                </div>
                <div className='container-nome-habilidade-freelancer'>
                    <div className='icon-hab'><img src="data:image/png;base64,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 " alt="" /></div>
                    <h3>{props.hability}</h3>
                </div>

                <div className='container-data-match-freelancer'>
                    <h3>Data do match :{props.dataMatch}</h3>
                </div>
            </div>
            <div className='container-exit'>
                <div className='container-icon-close'>
                    {/* <img src="https://cdn-icons-png.flaticon.com/512/95/95068.png " alt="" /> */}
                    </div>
            </div>
       </div>
    )
}