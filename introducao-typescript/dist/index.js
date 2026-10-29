"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
let mensagem = "Olá mundo!";
mensagem = "Nova mensagem";
let valor = null;
valor = false;
let id;
id = 2;
id = "2";
let status;
status = "ABERTO";
status = "FECHADO";
status = 12;
let qualquer;
qualquer = 1;
qualquer = "string";
qualquer = true;
qualquer = {};
qualquer = [];
let lista = [1, 2, 3, 4, "5"];
let statusChamado;
statusChamado = "ABERTO";
statusChamado = "FECHADO";
statusChamado = "PENDENTE";
;
let chamado;
chamado = {
    id: 1,
    titulo: "Chamado 1",
    criadoEm: "2026-10-21"
    //status: null
};
let listaChamado = [];
listaChamado.push({
    id: 1,
    titulo: "Chamado 1",
    status: "ABERTO",
    criadoEm: "2026-10-21"
});
listaChamado.push({
    id: 2,
    titulo: "Chamado 2",
    status: "ABERTO",
    criadoEm: "2026-10-21"
});
listaChamado.push({
    id: 3,
    titulo: "Chamado 3",
    status: "ABERTO",
    criadoEm: "2026-10-21"
});
listaChamado.push({
    id: 4,
    titulo: "Chamado 4",
    status: "FECHADO",
    criadoEm: "2026-10-21"
});
let titulos = listaChamado.map(lc => lc.titulo);
//function contaChamadosAbertos(lista: {
//    id: number;
//    titulo: string;
//    status?: StatusChamado | null;
//}[]) {
//    return lista.reduce((prev, atual) => 
//        atual.status === "ABERTO" ? prev + 1 : prev, 0)
//}
let contador;
let numero = 2;
let numero2 = "2";
//console.log(numero == numero2); // true
//console.log(numero === numero2); // false
const contaChamadosAbertos = (lista = []) => lista.reduce((prev, atual) => atual.status === "ABERTO" ? prev + 1 : prev, 0);
contador = contaChamadosAbertos;
function soma(a, b) {
    return a + b;
}
//contador = soma;
console.log(contaChamadosAbertos(listaChamado));
function processarChamado(id, callback) {
    console.log(`processando chamado ${id}`);
    callback(id);
}
//function x(id: number) {
//    console.log(`Entrou na função que não retorna nada id ${id}`);
//}
processarChamado(23, (id) => {
    console.log(`Entrou na função que não retorna nada id ${id}`);
});
let page = {
    data: listaChamado,
    total: listaChamado.length,
    page: 1,
    limit: 10
};
console.log(mensagem);
console.log(mensagem + valor);
//# sourceMappingURL=index.js.map