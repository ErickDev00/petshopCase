import "./App.css";

function App() {
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

    try {
      const response = await fetch(url, { method: "POST" });
      const resultado = await response.json();

      alert(
        `Melhor Petshop: ${
          resultado.nome
        } - Preço: R$ ${resultado.precoTotal.toFixed(2)}`
      );
    } catch (erro) {
      console.error("Erro:", erro);
    }
  }

  return (
    <>
      <div>
        <div>
          <form onSubmit={enviarForm}>
            <label>
              Data:
              <input type="date" name="data" id="data" required />
            </label>
            <br />

            <label>
              Quantidade de cães pequenos:
              <input type="number" name="qtdCaesPequenos" required />
            </label>
            <br />

            <label>
              Quantidade de cães grandes:
              <input type="number" name="qtdCaesGrandes" required />
            </label>
            <br />

            <button type="submit">Calcular Melhor Petshop</button>
          </form>
        </div>
      </div>
    </>
  );
}

export default App;
