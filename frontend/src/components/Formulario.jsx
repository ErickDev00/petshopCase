function Formulario({ onSubmit }) {
  return (
    <div>
      <form onSubmit={onSubmit} className="space-y-4">
        <div className="flex flex-col ">
          <label htmlFor="data" className="mb-1 font-semibold text-gray-900">
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
    </div>
  );
}

export default Formulario;
