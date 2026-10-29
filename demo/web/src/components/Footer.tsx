type FooterProps = {
  texto: string;
  copyright?: string;
};

export default function Footer({ texto, copyright }: FooterProps) {
  let condicao = false;
  let valor = 30;
  function alterarValor(value: number) {
    valor = value;
  }
  condicao && alterarValor(10);
  valor = condicao ? 10 : 20;
  return <footer className="white-back">
    {texto}
    {copyright && <p>{copyright}</p>}
</footer>;
}
