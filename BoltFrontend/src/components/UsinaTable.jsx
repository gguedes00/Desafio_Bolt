function UsinaTable({ usinas }) {
  return (
    <div className="max-w-4xl mx-auto bg-white shadow-md rounded-lg p-4">
      <table className="w-full table-auto">
        <thead>
          <tr className="bg-gray-200">
            <th className="px-4 py-2 text-left">Nome</th>
            <th className="px-4 py-2 text-left">Potência (MW)</th>
            <th className="px-4 py-2 text-left">Tipo</th>
            <th className="px-4 py-2 text-left">UF</th>
          </tr>
        </thead>
        <tbody>
          {usinas.map((usina, index) => (
            <tr key={index} className="border-t">
              <td className="px-4 py-2">{usina.nomeEmpreendimento}</td>
              <td className="px-4 py-2">{usina.potenciaOrtorgadaMW.toFixed(2)}</td>
              <td className="px-4 py-2">{usina.modeloUsina}</td>
              <td className="px-4 py-2">{usina.uf}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UsinaTable;
