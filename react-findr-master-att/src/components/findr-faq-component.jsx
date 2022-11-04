import '../styles/findr-faq-style.css'

function FaqComponent(props){
    return(
        <>
        <div class="faq-component-container">
            <div class="container-title" > <h1>{props.title}</h1></div>
            <a href="#">{props.primeiroLink}</a>
            <a href="#">{props.segundoLink}</a>
            <a href="#">{props.terceiroLink}</a>
        </div>
        
        </>
    );
}

export default FaqComponent;