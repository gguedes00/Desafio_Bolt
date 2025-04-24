import React from "react";
import { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [usinas, setUsinas] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:8080/usina/top5")
      .then(response => {
        setUsinas(response.data);
        setLoading(false);
      })
      .catch(err => {
        setError("Erro ao carregar dados.");
        setLoading(false);
      });
  }, []);

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-50 to-blue-100 flex flex-col items-center py-10 px-4">
      <h1 className="text-3xl font-extrabold text-blue-700 mb-6 text-center shadow-sm">⚡ Top 5 Maiores Geradores de Energia</h1>
      {loading && <p className="text-blue-600 text-lg">Carregando...</p>}
      {error && <p className="text-red-600 text-lg">{error}</p>}
      {!loading && !error && (
        <div className="w-full max-w-4xl bg-white shadow-2xl rounded-2xl p-6 border border-gray-200">
          <table className="w-full table-auto text-sm text-left">
            <thead>
              <tr className="bg-blue-100 text-blue-800 uppercase text-xs">
                <th className="px-4 py-3">Nome</th>
                <th className="px-4 py-3">Potência (MW)</th>
                <th className="px-4 py-3">Tipo</th>
                <th className="px-4 py-3">UF</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-200">
              {usinas.map((usina, index) => (
                <tr key={index} className="hover:bg-blue-50 transition">
                  <td className="px-4 py-3 font-medium text-gray-700">{usina.nomeEmpreendimento}</td>
                  <td className="px-4 py-3">{usina.potenciaOrtorgadaMW.toFixed(2)}</td>
                  <td className="px-4 py-3">{usina.modeloUsina}</td>
                  <td className="px-4 py-3">{usina.uf}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default App;
