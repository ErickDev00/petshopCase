import { useState } from "react";
import "./App.css";
import Formulario from "./components/Formulario";

function App() {
  const [resultado, setResultado] = useState(null);
  async function enviarForm(e) {
    e.preventDefault();

    const form = e.target;
    const data = form.data.value;
    const qtdCaesPequenos = parseInt(form.qtdCaesPequenos.value);
    const qtdCaesGrandes = parseInt(form.qtdCaesGrandes.value);

    if (qtdCaesPequenos + qtdCaesGrandes < 1) {
      alert("Informe pelo menos um cão para o serviço.");
      return;
    }

    const url = new URL(
      "https://rigid-bernelle-erickteste-1e26ecd1.koyeb.app/petshop/melhor-opcao"
    );

    const dados = {
      data: data,
      qtdCaesPequenos: qtdCaesPequenos,
      qtdCaesGrandes: qtdCaesGrandes,
    };

    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(dados),
      });

      const resultado = await response.json();
      setResultado(resultado);
    } catch (erro) {
      console.log("Erro:", erro);
    }
  }

  return (
    <>
      <div className="max-w-xl mx-auto mt-10 p-6 bg-gray-100 rounded-2xl shadow-md space-y-6">
        <h1 className="text-3xl font-bold text-black">
          Bem-vindo Sr. Eduardo!
        </h1>
        <h2 className="text-lg text-black">
          Busque o estabelecimento perfeito <br /> e com melhor custo-benefício
          para os seus pets:
        </h2>

        <div>
          <Formulario onSubmit={enviarForm} />

          {resultado && (
            <div className="mt-3">
              <h3>Resultado:</h3>
              <p>
                Com base na sua necessidade, o melhor petshop será o{" "}
                {resultado.nome}
              </p>
              <p className="font-bold text-green-800">
                Preço Total: R$ {resultado.precoTotal}
              </p>
            </div>
          )}
        </div>
      </div>
    </>
  );
}

export default App;
