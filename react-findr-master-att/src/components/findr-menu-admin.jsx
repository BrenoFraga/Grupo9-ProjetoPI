import { Menu } from 'primereact/menu';
import '../styles/findr-menu-style.css'
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";  
import imgFindr from "../imgs/logo-findr.png"

function FindrMenuAdmin() {

    let items = [
        {label: 'Perfil', icon: 'pi pi-fw pi-user', url: '/perfil'},
        {label: 'Dashboards', icon: 'pi pi-fw pi-chart-line',  url: '/dashboard'},
        {label: 'Conexões', icon: 'pi pi-fw pi-sitemap',  url: ''},
        {label: 'Matchs', icon: 'pi pi-fw pi-users',  url: '/match'},
        {label: 'Projetos', icon: 'pi pi-fw pi-id-card',  url: '/perfil'},
        {label: 'Sair', icon: 'pi pi-fw pi-sign-out',  url: 'http://52.202.44.244:80'}
    ]

    return (
        <>
        <div class="container-menu">
        <div class="user-return-container">
            <img src=   {imgFindr} alt="" />
           <h1>{sessionStorage.nomesuario}</h1>
        </div>
        <Menu model={items} className="menu-findr"/>
        </div>
        
        </>
    )

}

export default FindrMenuAdmin;
