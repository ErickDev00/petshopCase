import { useState } from "react";
import "./App.css";

function App() {
  const [resultado, setResultado] = useState(null);
  async function enviarForm(e) {
    e.preventDefault();

    const form = e.target;
    const data = form.data.value;
    const qtdCaesPequenos = form.qtdCaesPequenos.value;
    const qtdCaesGrandes = form.qtdCaesGrandes.value;

    const url = new URL("http://localhost:8080/petshop/melhor-opcao");
    url.searchParams.append("data", data);
    url.searchParams.append("qtdCaesPequenos", qtdCaesPequenos);
    url.searchParams.append("qtdCaesGrandes", qtdCaesGrandes);

    if (qtdCaesPequenos + qtdCaesGrandes < 1) {
      alert("Informe pelo menos um cão para o serviço.");
      return; // para o envio do formulário
    }

    try {
      const response = await fetch(url, { method: "POST" });
      const resultado = await response.json();
      setResultado(resultado);
      console.log(resultado);
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
          <form onSubmit={enviarForm} className="space-y-4">
            <div className="flex flex-col ">
              <label
                htmlFor="data"
                className="mb-1 font-semibold text-gray-900"
              >
                Data:
              </label>
              <input
                type="date"
                name="data"
                id="data"
                className="px-3 py-2 border rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:bg-blue-200 font"
                required
                min={new Date().toISOString().split("T")[0]}
              />

              <br />
            </div>

            <div className="flex flex-col">
              <label className="mb-1 font-semibold text-gray-900">
                Quantidade de cães pequenos:
              </label>
              <input
                type="number"
                name="qtdCaesPequenos"
                required
                min="0"
                step="1"
                className="px-3 py-2 border rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:bg-blue-200"
              />

              <br />
            </div>

            <div className="flex flex-col">
              <label
                htmlFor="qtdCaesGrandes"
                className="mb-1 font-semibold text-gray-900"
              >
                Quantidade de cães grandes:
              </label>
              <input
                type="number"
                name="qtdCaesGrandes"
                required
                min="0"
                step="1"
                className="px-3 py-2 border rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:bg-blue-200"
              />

              <br />
            </div>

            <button
              type="submit"
              className="w-full cursor-pointer bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-800 transition-colors"
            >
              Calcular Melhor Petshop
            </button>
          </form>

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
