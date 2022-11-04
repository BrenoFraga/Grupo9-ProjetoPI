import {BrowserRouter, Route, Routes} from "react-router-dom";
import FindrLogin from "./pages/login-findr";
import Suporte from "./pages/suporte";
import CadastroFreelancer from "./pages/cadastro-freelancer";
import CadastroContratante from "./pages/cadastro-contratante";
import FindrMatch from "./pages/match"
import FindrMatchContratante from "./pages/match-contratante"
import Perfil from "./pages/perfil";
import HabilitsProject from "./pages/habilits-project";
import HabilitsHabilit from "./pages/habilits-habilit";
import Match from "./pages/match";
import Dashboard from "./pages/dashboard";
import AllMatchFreelancer from "./pages/all-matchs-freelancer";
import ProjectsContactor from "./pages/projects-contactor";

function Rotas(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/login" element={<FindrLogin />} />
                <Route path="/suporte" element={<Suporte />} />
                <Route path="/cadastro-freelancer" element={<CadastroFreelancer />} />
                <Route path="/cadastro-contratante" element={<CadastroContratante />} />
                <Route path="/main" element={<FindrMatch />} />
                <Route path="/perfil" element={<Perfil />} />
                <Route path="/habilits/project" element={<HabilitsProject />} />
                <Route path="/habilits/habilit" element={<HabilitsHabilit />} />
                <Route path="/match" element={<Match />} />
                <Route path="/match-contactor" element={<FindrMatchContratante />} />
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/all-matchs-freelancer" element={<AllMatchFreelancer/>}/>
                <Route path="/projects-contactor" element = {<ProjectsContactor/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default Rotas;