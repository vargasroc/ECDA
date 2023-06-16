const path = require('path');

module.exports = {
  entry: './src/index.js', // Ruta de tu archivo principal de entrada
  output: {
    path: path.resolve(__dirname, 'dist'), // Ruta de salida para los archivos generados por Webpack
    filename: 'bundle.js' // Nombre del archivo generado por Webpack
  },
  resolve: {
    fallback: {
      url: require.resolve('url/')
    }
  }  
};
