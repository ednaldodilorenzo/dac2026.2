let mensagem = "Olá mundo!";

mensagem = "Nova mensagem";

let valor = null;
valor = false;
let id: number | string;
id = 2;
id = "2";
let status: "ABERTO" | "FECHADO" | 12;
status = "ABERTO";
status = "FECHADO";
status = 12;

let qualquer: any;
qualquer = 1;
qualquer = "string";
qualquer = true;
qualquer = {};
qualquer = [];

let lista = [1, 2, 3, 4, "5"];
//lista.push(false); // Não é possível adicionar um booleano a uma lista de números e strings

type StatusChamado = "ABERTO" | "FECHADO" | "PENDENTE"; 

let statusChamado: StatusChamado;
statusChamado = "ABERTO";
statusChamado = "FECHADO";
statusChamado = "PENDENTE";
//statusChamado = "OUTRO"; // Erro: não é possível atribuir um valor que não esteja definido no tipo StatusChamado
type ChamadoType = {
    id: number;
    titulo: string;
    status?: StatusChamado | null;
};

type Auditavel = {
    criadoEm: string;
    alteradoEm?: string;
};

type ChamadoAuditavel = ChamadoType & Auditavel;

interface EntidadeAuditavel {
    criadoEm: string;
    alteradoEm?: string;
}

interface ChamadoInterface extends EntidadeAuditavel {
    id: number;
    titulo: string;
    status?: StatusChamado | null; 
};



let chamado: ChamadoAuditavel;

chamado = {
    id: 1,
    titulo: "Chamado 1",
    criadoEm: "2026-10-21"
    //status: null
};

let listaChamado: Array<ChamadoInterface> = [];
 
listaChamado.push(
    {
        id: 1,
        titulo: "Chamado 1",
        status: "ABERTO",
        criadoEm: "2026-10-21"
    }
);

listaChamado.push(
    {
        id: 2,
        titulo: "Chamado 2",
        status: "ABERTO",
        criadoEm: "2026-10-21"
    }
);

listaChamado.push(
    {
        id: 3,
        titulo: "Chamado 3",
        status: "ABERTO",
        criadoEm: "2026-10-21"
    }
);

listaChamado.push(
    {
        id: 4,
        titulo: "Chamado 4",
        status: "FECHADO",
        criadoEm: "2026-10-21"
    }
);

let titulos: string[] = listaChamado.map(lc => lc.titulo);

//function contaChamadosAbertos(lista: {
//    id: number;
//    titulo: string;
//    status?: StatusChamado | null;
//}[]) {
//    return lista.reduce((prev, atual) => 
//        atual.status === "ABERTO" ? prev + 1 : prev, 0)
//}

let contador: (lista: {
    id: number;
    titulo: string;
    status?: StatusChamado | null;
    criadoEm: string;
}[]) => number;

let numero: number | string = 2
let numero2: number | string = "2"

//console.log(numero == numero2); // true
//console.log(numero === numero2); // false

const contaChamadosAbertos = (lista: ChamadoAuditavel[] = []) => 
    lista.reduce((prev, atual) => 
        atual.status === "ABERTO" ? prev + 1 : prev, 0)

contador = contaChamadosAbertos;
function soma(a: number, b: number) {
    return a + b;
}
//contador = soma;
console.log(contaChamadosAbertos(listaChamado));

function processarChamado(
    id: number,
    callback: (id: number) => void
) {
    console.log(`processando chamado ${id}`);
    callback(id);
}

//function x(id: number) {
//    console.log(`Entrou na função que não retorna nada id ${id}`);
//}

processarChamado(23, (id: number) => {
    console.log(`Entrou na função que não retorna nada id ${id}`);
});

type Page<T> = {
    data: T[];
    total: number;
    page: number;
    limit: number;
};

let page: Page<ChamadoAuditavel> = {
    data: listaChamado,
    total: listaChamado.length,
    page: 1,
    limit: 10
};

console.log(mensagem);
console.log(mensagem + valor);