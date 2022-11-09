import FindrMenuAdmin from "../components/findr-menu-admin";
import '../styles/all-matchs-freelancer.css'
import * as React from 'react';
import {CardMatch} from  '../components/components-all-matchs/card'
import axios from "axios";
import { ThirtyFpsSelect } from "@mui/icons-material";

class AllMatchFreelancer extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            items : []
        }
    }
    
    componentDidMount(){
        axios.get('http://localhost:5000/matchscontactor')
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
        
    }
    render(){
    return (
       <div className="container-all">
        <FindrMenuAdmin />
        <div className="container-all-content">
            <div className="container-title">
                <h1>Seus Matchs</h1>
            </div>
            <div className="container-card">
                {this.state.items.map((item) => <CardMatch
                    name = {item.name}
                    email = {item.email}
                    hability = {item.hability}
                    level = {item.level}
                    dataMatch = {item.dataMatch}
                    city = {item.city}
                    country = {item.country}

                    
                />)
            
                }
            </div>
        </div>
       </div>
    )
    }
}

export default AllMatchFreelancer