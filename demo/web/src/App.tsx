import { useState } from "react";
import "./App.css";
import Layout from "./components/Layout";

export default function App() {
  const [contador, setContador] = useState(1);
  console.log("Renderizando o componente App");

  return (
    <div>
      Teste da Minha Aplicação Web
      <button onClick={() => setContador(contador + 1)}>
        Contador {contador}
      </button>
      <Layout />
    </div>
  );
}
