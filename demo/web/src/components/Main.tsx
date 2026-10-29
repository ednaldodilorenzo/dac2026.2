import { useEffect, useState, type ReactNode } from "react";

type MainProps = {
  children?: ReactNode;
};

export default function Main({ children }: MainProps) {
  const [dados, setDados] = useState("");
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        setDados(data);
      });
  }, []);
  return (
    <main>
      {dados && <p>Dados carregados com sucesso!</p>}
      {dados && <p>{JSON.stringify(dados)}</p>}
      {children}
    </main>
  );
}
