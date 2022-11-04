
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons
 
import './App.css';
import Suporte from "./pages/suporte";
import FaqComponent from "./components/findr-faq-component";
import FindrLogin from "./pages/login-findr";
import Cadastro from "./pages/cadastro-freelancer";
import Perfil from "./pages/perfil";
import Match from "./pages/match"
import Rotas from "./routes";
import { useEffect } from "react";

function App() {

    function addClass() {
      var addStyleToMenuExit = document.querySelector(".menu-findr ul li:nth-child(6)");
      var addStyleToMenuProfile = document.querySelector(".menu-findr ul li:nth-child(1)");
      
      if(addStyleToMenuExit != undefined){
        addStyleToMenuExit.classList.add("btn-exit")
      }

      if(addStyleToMenuProfile != undefined){
        addStyleToMenuProfile.classList.add("btn-profile")
      }
    }

    useEffect(() => {
      addClass();
    })

  return (
    <>
    <Rotas/>
    </>
     );
}

export default App;
