import FindrAutocomplete from "../components/findr-autocomplete";
import FaqComponent from "../components/findr-faq-component";
import FindrMenu from "../components/findr-menu"
import '../styles/findr-sup-page-style.css'

function Suporte() {
    return (
        <>
            <FindrMenu/>
            <div class="container-sup-page">
                <div class="container-help-question">
                    <h1>Como podemos te ajudar?</h1>
                    <FindrAutocomplete/>
                </div>
                
                <div className="container-faq-imports">
                    <FaqComponent title="Perfil" primeiroLink="Como adicionar uma nova habilidade/projeto?" segundoLink="Como excluir um projeto ou uma habilidade?" terceiroLink="Como visualizar detalhes dos matchs que possuo?" /> 
                    <FaqComponent title="Match" primeiroLink="Como dar like ou recusar um usuário? " segundoLink="Como obter mais informações sobre um usuário?" terceiroLink="Como filtrar características dos usuários?" />
                </div>
            </div>

        </>
    );
}

export default Suporte;