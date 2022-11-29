import { Menu } from 'primereact/menu';
import '../styles/findr-menu-style.css'
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";  
import Footer from "../components/component-tela-footer/findr-footer"

function FindrMenu() {
    let items = [
        {label: 'Perfil', icon: 'pi pi-fw pi-user', url: '/perfil'},
        {label: 'Dashboards', icon: 'pi pi-fw pi-chart-line',  command:()=>{
            if(sessionStorage.idUsuario != null){
                window.location.href = '/dashboard-freelancer'
            }else{
                window.location.href = '/dashboard-contratante'
            }
        }},
        {label: 'Conexões', icon: 'pi pi-fw pi-sitemap',  url: ''},
        {label: 'Matchs', icon: 'pi pi-fw pi-users', command:()=>{
            if(sessionStorage.idUsuario != null){
                window.location.href = '/match'
            }else{
                window.location.href = '/match-contactor'
            }
        } },
        {label: 'Projetos', icon: 'pi pi-fw pi-id-card',  url: ''},
        {label: 'Sair', icon: 'pi pi-fw pi-sign-out',  url: 'http://52.202.44.244:80'}
    ]

    return (
        <>
        <div class="container-menu">
        <div class="user-return-container">
            <img src="https://i.pinimg.com/originals/12/5e/00/125e00eedea84514eaed380991657c44.jpg" alt="" />
           <h1>{sessionStorage.nomesuario}</h1>
        </div>
        <Menu model={items} className="menu-findr"/>
        </div>
        <Footer />
        </>
    )

}

export default FindrMenu;
