import FindrMenuAdmin from "../components/findr-menu-admin";
import '../styles/all-matchs-freelancer.css'
import * as React from 'react';
import {CardMatch} from  '../components/components-all-matchs/card'

function AllMatchFreelancer(){
    return (
       <div className="container-all">
        <FindrMenuAdmin />
        <div className="container-all-content">
            <div className="container-title">
                <h1>Seus Matchs</h1>
            </div>
            <div className="container-card">
               <CardMatch/> 
               <CardMatch/> 
               <CardMatch/> 
               <CardMatch/> 
               <CardMatch/> 
               
            </div>
        </div>
       </div>
    )
}

export default AllMatchFreelancer