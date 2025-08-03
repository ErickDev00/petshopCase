import "./App.css";

function App() {
  return (
    <>
      <div>
        <div>
          <form>
            <label>
              Data:
              <input type="date" name="data" id="data" />
            </label>
            <br />

            <label>
              Quantidade de cães pequenos:
              <input type="number" name="qtdCaesPequenos" />
            </label>
            <br />

            <label>
              Quantidade de cães grandes:
              <input type="number" name="qtdCaesGrandes" />
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
