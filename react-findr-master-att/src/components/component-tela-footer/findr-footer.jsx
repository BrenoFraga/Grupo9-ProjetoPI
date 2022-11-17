
import "../component-tela-footer/findr-footer.css"
import 'primeicons/primeicons.css';
import imgFindr from "../../imgs/logo-findr.png"


function Footer() {
    return (
        <footer class="footer-findr">
            <div class="imgFindr">
                <span>Findr</span>
                <img src={imgFindr} alt="" />
            </div>
            <p>
                <span>Copyright</span> &copy; 2022
            </p>
        </footer>
    ) 
}

export default Footer;