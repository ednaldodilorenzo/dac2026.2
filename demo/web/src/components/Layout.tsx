import Header from "./Header"
import Main from "./Main"
import Footer from "./Footer"
import { useState } from "react";

export default function Layout() {
    console.log("Renderizando o componente Layout");
    const [contador, setContador] = useState(0);
    const [nome, setNome] = useState("");
    
    return (
    <>
        <Header title={"Título da minha Aplicação " + nome} click={() => setNome("Ednaldo")} />
        <Main>
            <p>Conteúdo da Aplicação</p>
            <button onClick={() => setContador(contador + 1)}>
                Clique aqui
            </button>
            <p>Contador: {contador}</p>
        </Main>
        <Footer texto="Rodapé da Aplicação" copyright="Copyright © 2026 Minha Aplicação. Todos os direitos reservados." />
    </>);
}